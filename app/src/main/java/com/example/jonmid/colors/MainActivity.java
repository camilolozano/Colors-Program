package com.example.jonmid.colors;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    int seekR, seekG, seekB, seekA;
    SeekBar seekBarRed, seekBarGreen, seekBarBlue, seekBarAlpha;
    View viewBackground;
    TextView txtRed, txtGreen, txtBlue, txtAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = (SeekBar) findViewById(R.id.id_sb_red);
        seekBarGreen = (SeekBar) findViewById(R.id.id_sb_green);
        seekBarBlue = (SeekBar) findViewById(R.id.id_sb_blue);
        seekBarAlpha = (SeekBar) findViewById(R.id.id_sb_alpha);

        txtRed = (TextView) findViewById(R.id.textRed);
        txtGreen = (TextView) findViewById(R.id.textgreen);
        txtBlue = (TextView) findViewById(R.id.textBlue);
        txtAlpha = (TextView) findViewById(R.id.textalpha);

        viewBackground = (View) findViewById(R.id.v_id_background);

        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);
        seekBarAlpha.setOnSeekBarChangeListener(this);

        registerForContextMenu(viewBackground);
        updateBackground();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.index_menu, menu);
    }

    // ******************************************************************************

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.index_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.id_menu_transparent:
                seekBarAlpha.setProgress(0);
                return true;
            case R.id.id_menu_semitransparent:
                seekBarAlpha.setProgress(128);
                return true;
            case R.id.id_menu_opaque:
                seekBarAlpha.setProgress(255);
                return true;
            case R.id.id_menu_black:
                seekBarRed.setProgress(0);
                seekBarGreen.setProgress(0);
                seekBarBlue.setProgress(0);
                return true;
            case R.id.id_menu_white:
                seekBarRed.setProgress(255);
                seekBarGreen.setProgress(255);
                seekBarBlue.setProgress(255);
                return true;
            case R.id.id_menu_red:
                seekBarRed.setProgress(255);
                seekBarGreen.setProgress(0);
                seekBarBlue.setProgress(0);
                return true;
            case R.id.id_menu_green:
                seekBarRed.setProgress(0);
                seekBarGreen.setProgress(255);
                seekBarBlue.setProgress(0);
                return true;
            case R.id.id_menu_blue:
                seekBarRed.setProgress(0);
                seekBarGreen.setProgress(0);
                seekBarBlue.setProgress(255);
                return true;
            case R.id.id_menu_magenta:
                seekBarRed.setProgress(255);
                seekBarGreen.setProgress(0);
                seekBarBlue.setProgress(255);
                return true;
            case R.id.id_menu_yellow:
                seekBarRed.setProgress(255);
                seekBarGreen.setProgress(255);
                seekBarBlue.setProgress(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // ******************************************************************************

    public void updateBackground() {

        seekR = seekBarRed.getProgress();
        seekG = seekBarGreen.getProgress();
        seekB = seekBarBlue.getProgress();
        seekA = seekBarAlpha.getProgress();

        txtRed.setText("" + seekR);
        txtBlue.setText("" + seekB);
        txtGreen.setText("" + seekG);
        txtAlpha.setText("" + seekA);

        int color = Color.argb(seekA, seekR, seekG, seekB);
        viewBackground.setBackgroundColor(color);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateBackground();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //
    }

    // ******************************************************************************
}
