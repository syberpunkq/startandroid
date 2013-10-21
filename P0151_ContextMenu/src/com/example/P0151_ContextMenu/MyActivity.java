package com.example.P0151_ContextMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tvcolor = (TextView) findViewById(R.id.tvColor);
        TextView tvsize = (TextView) findViewById(R.id.tvSize);

    }
}
