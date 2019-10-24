package com.bcgdv.asia.ticktock;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bcgdv.asia.lib.ticktock.TickTockView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TickTockView mCountDown = null;
    private TickTockView mCountUp = null;
    private TextView mTxtHeadline = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtHeadline = (TextView) findViewById(R.id.txt_headline);
        mTxtHeadline.setText("Hello World2");
        mCountDown = (TickTockView) findViewById(R.id.view_ticktock_countdown);
        mCountUp = (TickTockView) findViewById(R.id.view_ticktock_countup);
        if (mCountDown != null) {
            mCountDown.setOnTickListener(new TickTockView.OnTickListener() {
                @Override
                public String getText(long timeRemaining) {

                    if(timeRemaining == 0.0)
                    {
                        Toast.makeText(getApplicationContext(),"finished",Toast.LENGTH_LONG).show();
                    }

                    int seconds = (int) (timeRemaining / 1000) % 60;
                    int minutes = (int) ((timeRemaining / (1000 * 60)) % 60);
                    int hours = (int) ((timeRemaining / (1000 * 60 * 60)) % 24);
                    int days = (int) (timeRemaining / (1000 * 60 * 60 * 24));
                    boolean hasDays = days > 0;
                    return String.format("%1$02d%4$s %2$02d%5$s %3$02d%6$s",
                            hasDays ? days : hours,
                            hasDays ? hours : minutes,
                            hasDays ? minutes : seconds,
                            hasDays ? "d" : "h",
                            hasDays ? "h" : "m",
                            hasDays ? "m" : "s");
                }
            });
        }

        if (mCountUp != null) {
            mCountUp.setOnTickListener(new TickTockView.OnTickListener() {
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                Date date = new Date();
                @Override
                public String getText(long timeRemaining) {

                    if(timeRemaining == 0.0)
                    {
                        Toast.makeText(getApplicationContext(),"finished1",Toast.LENGTH_LONG).show();
                    }

                    date.setTime(System.currentTimeMillis());
                    return format.format(date);
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Calendar end = Calendar.getInstance();
//        end.add(Calendar.MINUTE, 4);
        end.add(Calendar.SECOND, 5);

        Calendar start = Calendar.getInstance();
        start.add(Calendar.SECOND, 3);
        if (mCountDown != null) {
            mCountDown.start(start, end);
        }

        Calendar c2= Calendar.getInstance();
        c2.add(Calendar.SECOND, 30);

        Calendar start1 = Calendar.getInstance();
        start.add(Calendar.SECOND, 3);

        if (mCountUp != null) {
            mCountUp.start(start1,40);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCountDown.stop();
        mCountUp.stop();
    }
}
