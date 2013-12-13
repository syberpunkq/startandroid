package com.example.P0301_ActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity implements OnClickListener{

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    TextView tvText;
    Button btnColor;
    Button btnAlign;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvText = (TextView) findViewById(R.id.tvText);
        btnAlign = (Button) findViewById(R.id.btnAlign);
        btnColor = (Button) findViewById(R.id.btnColor);
        btnAlign.setOnClickListener(this);
        btnColor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, AlignActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGN);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MYLOG","requestCode = " + requestCode + " resultCode = " + resultCode);
            if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    tvText.setTextColor(data.getIntExtra("color", Color.WHITE));
                    break;
                case REQUEST_CODE_ALIGN:
                    tvText.setGravity(data.getIntExtra("alignment", Gravity.CENTER));
                    break;
            }



            } else {
                Toast.makeText(this,"you choose nothing",Toast.LENGTH_SHORT).show();
                    }
    }
}
