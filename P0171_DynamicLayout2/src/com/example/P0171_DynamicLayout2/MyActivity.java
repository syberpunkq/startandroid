package com.example.P0171_DynamicLayout2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;

public class MyActivity extends Activity implements OnClickListener {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
       switch(v.getId()) {
           case(R.id.btnCreate):
               int gravity = Gravity.CENTER;
               LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(wrapContent, wrapContent);
               Button bt = new Button(this);
               bt.setText(etName.getText().toString());
               switch (rgGravity.getCheckedRadioButtonId()) {
                   case(R.id.rbLeft):
                       gravity = Gravity.LEFT;
                       break;
                   case(R.id.rbCenter):
                       gravity = Gravity.CENTER;
                       break;
                   case(R.id.rbRight):
                       gravity = Gravity.RIGHT;
                       break;
               }
               lp.gravity = gravity;
               bt.setLayoutParams(lp);
               llMain.addView(bt);

               break;
           case R.id.btnClear:
               llMain.removeAllViews();
               Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
               break;
       }

    }
}
