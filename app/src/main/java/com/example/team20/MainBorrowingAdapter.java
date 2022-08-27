package com.example.team20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainBorrowingAdapter extends RecyclerView.Adapter<MainBorrowingAdapter.CustomViewHolder> {

    private ArrayList<MainData> arrayList;
    private Intent intent;
    private Bitmap bitmap;
    public MainBorrowingAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainBorrowingAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainBorrowingAdapter.CustomViewHolder holder, int position) {

        bitmap = BitmapFactory.decodeByteArray(arrayList.get(holder.getAdapterPosition()).getItem_img_path(), 0, arrayList.get(position).getItem_img_path().length); //byte[]를 bitmap
        holder.item_name.setText(arrayList.get(holder.getAdapterPosition()).getItem_name());
        holder.item_img_path.setImageBitmap(bitmap); //bitmap을 img

        holder.itemView.setTag(holder.getAdapterPosition());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), BorrowingDetailActivity.class);
                intent.putExtra("이름",arrayList.get(holder.getAdapterPosition()).getItem_name());
                intent.putExtra("사진",bitmapToByteArray(bitmap));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView item_name;
        protected ImageView item_img_path;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_name = (TextView) itemView.findViewById(R.id.txt_item_name);
            this.item_img_path = (ImageView) itemView.findViewById(R.id.img_item);
        }
    }
    public byte[] bitmapToByteArray(Bitmap bitmap) { //img>bitmap>byte[] 함수 필요
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
        byte[] byteArray = stream.toByteArray() ;
        return byteArray ;
    }
}