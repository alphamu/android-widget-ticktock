# TickTock Widget

This is a circular widget that can be used to display a count down timer or a count up timer.

![TickTock Widget](http://i.giphy.com/Pdx51JBf5f90A.gif)

## How to include

   compile 'com.bcgdv.asia.lib:ticktock:1.0'

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
   
