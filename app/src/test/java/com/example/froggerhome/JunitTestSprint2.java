package com.example.froggerhome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import org.mockito.Mockito;

@DisplayName("Sprint 2 Test Cases")
public class JunitTestSprint2 {

    @DisplayName("rightDirectionTest")
    @Test
    public void rightDirectionTest() {
        OnSwipeListener.Direction right1 = OnSwipeListener.Direction.determineDirection(25);
        OnSwipeListener.Direction right2 = OnSwipeListener.Direction.determineDirection(0);

        OnSwipeListener.Direction expected = OnSwipeListener.Direction.RIGHT;
        OnSwipeListener.GestureListener gestureListener =
                Mockito.mock(OnSwipeListener.GestureListener.class);

        Mockito.when(gestureListener.onSwipe(right1)).thenReturn(true);
        assertEquals(expected, right1);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(right1));

        Mockito.when(gestureListener.onSwipe(right2)).thenReturn(true);
        assertEquals(expected, right2);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(right2));
    }

    @DisplayName("leftDirectionTest")
    @Test
    public void leftDirectionTest() {
        OnSwipeListener.Direction left1 = OnSwipeListener.Direction.determineDirection(140);
        OnSwipeListener.Direction left2 = OnSwipeListener.Direction.determineDirection(220);

        OnSwipeListener.Direction expected = OnSwipeListener.Direction.LEFT;
        OnSwipeListener.GestureListener gestureListener =
                Mockito.mock(OnSwipeListener.GestureListener.class);

        Mockito.when(gestureListener.onSwipe(left1)).thenReturn(true);
        assertEquals(left1, expected);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(left1));

        Mockito.when(gestureListener.onSwipe(left2)).thenReturn(true);
        assertEquals(left2, expected);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(left2));
    }

    @DisplayName("upDirectionTest")
    @Test
    public void upDirectionTest() {
        OnSwipeListener.Direction up1 = OnSwipeListener.Direction.determineDirection(50);
        OnSwipeListener.Direction up2 = OnSwipeListener.Direction.determineDirection(120);

        OnSwipeListener.Direction expected = OnSwipeListener.Direction.UP;
        OnSwipeListener.GestureListener gestureListener =
                Mockito.mock(OnSwipeListener.GestureListener.class);

        Mockito.when(gestureListener.onSwipe(up1)).thenReturn(true);
        assertEquals(up1, expected);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(up1));

        Mockito.when(gestureListener.onSwipe(up2)).thenReturn(true);
        assertEquals(up2, expected);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(up2));
    }

    @DisplayName("downDirectionTest")
    @Test
    public void downDirectionTest() {
        OnSwipeListener.Direction down1 = OnSwipeListener.Direction.determineDirection(230);
        OnSwipeListener.Direction down2 = OnSwipeListener.Direction.determineDirection(305);

        OnSwipeListener.Direction expected = OnSwipeListener.Direction.DOWN;
        OnSwipeListener.GestureListener gestureListener =
                Mockito.mock(OnSwipeListener.GestureListener.class);

        Mockito.when(gestureListener.onSwipe(down1)).thenReturn(true);
        assertEquals(down1, expected);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(down1));

        Mockito.when(gestureListener.onSwipe(down2)).thenReturn(true);
        assertEquals(down2, expected);
        assertTrue(String.valueOf(gestureListener.onSwipe(expected)),
                gestureListener.onSwipe(down2));
    }

}
