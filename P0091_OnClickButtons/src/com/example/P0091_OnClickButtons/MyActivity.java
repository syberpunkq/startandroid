package com.example.P0091_OnClickButtons;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MyActivity extends Activity {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOut.setText("OK button is pressed");
            }
        };
        OnClickListener oclBtnCancel = new OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOut.setText("Cancel button is pressed");
            }
        };

        btnOk.setOnClickListener(oclBtnOk);
        btnCancel.setOnClickListener(oclBtnCancel);
    }
}
