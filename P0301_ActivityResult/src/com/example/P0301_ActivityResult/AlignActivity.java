package com.example.P0301_ActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class AlignActivity extends Activity implements OnClickListener{

    Button btnLeft;
    Button btnRight;
    Button btnCenter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.align);

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        btnCenter = (Button) findViewById(R.id.btnCenter);

        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnLeft:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
            case R.id.btnRight:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
            case R.id.btnCenter:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}