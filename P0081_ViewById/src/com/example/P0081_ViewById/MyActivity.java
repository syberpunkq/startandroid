package com.example.P0081_ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView myTextView = (TextView) findViewById(R.id.myText);
        Button myBtn = (Button) findViewById(R.id.button);
        CheckBox myChk = (CheckBox) findViewById(R.id.checkBox);

        myTextView.setText("this is the text");
        myBtn.setEnabled(false);
        myChk.setChecked(true);
    }
}
