package com.example.team20;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class RequestDialog extends Dialog {
    private TextView txt;
    private Button btn;

    public RequestDialog(@NonNull Context context, String contents, String btn_txt) {
        super(context);
        setContentView(R.layout.activity_one_dialog);

        txt = findViewById(R.id.txt);
        txt.setText(contents);
        btn = findViewById(R.id.btn);
        btn.setText(btn_txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
