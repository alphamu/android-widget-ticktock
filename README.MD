# TickTock Widget

This is a circular widget that can be used to display a count down timer or a count up timer.

![TickTock Widget](http://i.giphy.com/Pdx51JBf5f90A.gif)

## How to include

	compile 'com.bcgdv.asia.lib:ticktock:1.1'

## Usage

    <com.bcgdv.asia.lib.ticktock.TickTockView
        android:id="@+id/view_ticktock_countup"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_marginTop="16dp"
        android:layout_gravity="center_horizontal"
		app:tickAutoFitText="true"
        app:tickMiddleColor="#333333"
        app:tickMoveCounterClockwise="true"
        app:tickTextColor="#CCCCCC"
        app:tickDotRadius="6dp"
        app:tickEmptyRingColor="@android:color/white"
        app:tickFillRingColor="@color/colorPrimary"
        app:tickRingThickness="3dp" />
		
- `tickCircleDuration` - `minute|total_time` the circle completes a full circle every minute or the total time different between startTime and endTime. Default `minute`.
- `tickAutoFitText` - `boolean` default `true`. The text will be automatically resized to fit in the available space.
- `tickText` - Optional `String` static text to display in the middle.
- `tickTextColor` - Optional `color`
- `tickTextSize` - Optional `dimension` text size if `tickAutoFitText` is not used.
- `tickMiddleColor` - Optional `color` the color of the center of the color. Color transparent by default.
- `tickFillRingColor` - Optional `color` the color of the ring when filled. Color white by default.
- `tickEmptyRingColor` - Optional `color` the color of the ring when empty. Color blue by default.
- `tickRingThickness` - Optional `dimension` the tickness of the ring in DIP. 3dp by default.
- `tickDotRadius` - Optional `dimension` the radious in DIP of the dot. 6dp by default.
- `tickMoveCounterClockwise` Optional `boolean` false by default.

        public void onCreate(Bundle savedInstanceState) {
        ...
            mCountDown = (TickTockView) findViewById(R.id.view_ticktock_countdown);
            mCountUp = (TickTockView) findViewById(R.id.view_ticktock_countup);
            if (mCountDown != null) {
                mCountDown.setOnTickListener(new TickTockView.OnTickListener() {
                    @Override
                    public String getText(long timeRemaining) {
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
                        date.setTime(System.currentTimeMillis());
                        return format.format(date);
                    }
                });
            }
        ...
        }

        @Override
        protected void onStart() {
            super.onStart();
            Calendar end = Calendar.getInstance();
            end.add(Calendar.MINUTE, 4);
            end.add(Calendar.SECOND, 5);

            Calendar start = Calendar.getInstance();
            start.add(Calendar.MINUTE, -1);
            if (mCountDown != null) {
                mCountDown.start(start, end);
            }

            Calendar c2= Calendar.getInstance();
            c2.add(Calendar.HOUR, 2);
            c2.set(Calendar.MINUTE, 0);
            c2.set(Calendar.SECOND, 0);
            c2.set(Calendar.MILLISECOND, 0);
            if (mCountUp != null) {
                mCountUp.start(c2);
            }
        }

        @Override
        protected void onStop() {
            super.onStop();
            mCountDown.stop();
            mCountUp.stop();
        }
   
## Known Issues

- Please report any through GitHub issue tracker.