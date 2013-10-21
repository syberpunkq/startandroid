package com.example.P0181_DynamicLayout3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MyActivity extends Activity implements OnSeekBarChangeListener{

    SeekBar sbWeight;
    Button btn1;
    Button btn2;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        lParams1.weight = i;
        lParams2.weight = seekBar.getMax()-i;
        btn1.setText(String.valueOf(i));
        btn2.setText(String.valueOf(seekBar.getMax()-i));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
