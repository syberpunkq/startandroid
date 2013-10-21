package com.example.P0102_ActivityListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity implements OnClickListener{
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

        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.btnOk):
                tvOut.setText("ok");
                break;
            case(R.id.btnCancel):
                tvOut.setText("cancel");
                break;
        }
    }
}
