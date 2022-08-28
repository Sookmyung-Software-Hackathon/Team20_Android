package com.example.team20;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import com.example.team20.databinding.ActivityJoinBinding;
import com.example.team20.domain.Member;
import com.example.team20.retrofit.MemberApi;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JoinActivity extends AppCompatActivity {
    private ActivityJoinBinding binding;
    private retrofit2.Retrofit retrofit;
    private String id;
    private String pw;
    private String name; //etxt_nickname
    private byte[] img; //drawble에서
    private String number; //etxt_number
    private String mail;
    private Bitmap bitmap;
    private byte[] byteArray_basicProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJoinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://192.168.219.100:9000") //cmd 창에서 확인 가능 - ipv4 주소 :9000
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        Bitmap bitmap_basicProfile = BitmapFactory.decodeResource(getResources(), R.drawable.basic_profile);
        byteArray_basicProfile = bitmapToByteArray(bitmap_basicProfile);

        MemberApi service = retrofit.create(MemberApi.class);
        id = binding.etxtJoinId.getText().toString();
        pw = binding.etxtJoinPw.getText().toString();
        name = binding.etxtNickname.getText().toString();
        img = byteArray_basicProfile;
        number = binding.etxtNumber.getText().toString();
        mail = binding.etxtJoinEmail.getText().toString();
        Member member = new Member(id, name, img, pw,mail,number);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        binding.btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Call<Member> memberCall = service.save(member);
                    showSuccessDialog();
                    Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }catch (IllegalStateException e){
                    showFailDialog();
                }
            }
        });

        binding.btnJoinCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                finishAndRemoveTask();
                System.runFinalization();
            }
        });
    }
    void showFailDialog(){
        AlertDialog.Builder changeBuilder = new AlertDialog.Builder(JoinActivity.this)
                .setMessage("아이디 중복입니다.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog changeDlg = changeBuilder.create();
        changeDlg.show();
    }
    void showSuccessDialog(){
        AlertDialog.Builder changeBuilder = new AlertDialog.Builder(JoinActivity.this)
                .setMessage("사용할 수 있는 아이디입니다.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog changeDlg = changeBuilder.create();
        changeDlg.show();
    }
    public byte[] bitmapToByteArray(Bitmap bitmap) { //img>bitmap>byte[] 함수 필요
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
        byte[] byteArray = stream.toByteArray() ;
        return byteArray ;
    }
}