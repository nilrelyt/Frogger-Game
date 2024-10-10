package com.example.froggerhome;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


import androidx.annotation.NonNull;
public class OnSwipeListener implements OnTouchListener {

    private GestureDetector gestureDetector;

    public void onSwipeUp() {
    }
    public void onSwipeDown() {
    }
    public void onSwipeLeft() {
    }
    public void onSwipeRight() {
    }

    public OnSwipeListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        double x = event.getX();
        double y = event.getY();
        return gestureDetector.onTouchEvent(event);
    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(@NonNull MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX,
                               float velocityY) {
            float x1 = e1.getX();
            float y1 = e1.getY();
            float x2 = e2.getX();
            float y2 = e2.getY();
            return onSwipe(getDirection(x1, y1, x2, y2));
        }

        public boolean onSwipe(OnSwipeListener.Direction direction) {
            if (direction == OnSwipeListener.Direction.UP) {
                onSwipeUp();
                return true;
            }
            if (direction == OnSwipeListener.Direction.DOWN) {
                onSwipeDown();
                return true;
            }
            if (direction == OnSwipeListener.Direction.LEFT) {
                onSwipeLeft();
                return true;
            }
            if (direction == OnSwipeListener.Direction.RIGHT) {
                onSwipeRight();
                return true;
            }
            return false;
        }

        public OnSwipeListener.Direction getDirection(float x1, float y1, float x2, float y2) {
            double angle = getAngle(x1, y1, x2, y2);
            return OnSwipeListener.Direction.determineDirection(angle);
        }

        public double getAngle(float x1, float y1, float x2, float y2) {
            double rad = Math.atan2(y2 - y1, x2 - x1) + Math.PI;
            return (rad * 180 / Math.PI + 180) % 360;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
        public static Direction determineDirection(double angle) {
            if (angle >= 45 && angle < 135) {
                return Direction.UP;
            }
            if (angle >= 225 && angle < 315) {
                return Direction.DOWN;
            }
            if (angle >= 135 && angle < 225) {
                return Direction.LEFT;
            }
            if ((angle >= 0 && angle < 45) || (angle >= 315 && angle < 360)) {
                return Direction.RIGHT;
            }
            return null;
        }
    }
}

