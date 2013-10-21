package com.example.P0101_Listener;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity{
    /**
     * Called when the activity is first created.
     */

    TextView tvOut;
    Button btnOk;
    Button btnCancel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        OnClickListener oclBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnOk:
                tvOut.setText("Нажата кнопка ОК");
                        break;
                    case R.id.btnCancel:
                        tvOut.setText("Нажата кнопка Cancel");
                        break;
                }
            }
        };

        btnOk.setOnClickListener(oclBtn);
        btnCancel.setOnClickListener(oclBtn);

    }



}
