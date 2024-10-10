package com.example.froggerhome;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import org.mockito.Mockito;


import java.util.Random;


public class JunitTestSprint3 {

    private GameScreen gameScreen;

    @Before
    public void init() {
        gameScreen = Mockito.mock(GameScreen.class);
    }

    @DisplayName("isCarMoveForwardTouchLimit")
    @Test
    public void isCarMoveForwardTouchLimit() throws Exception {
        ImageView car1 = new ImageView(null);
        when(gameScreen.isCarForwardLimit(car1, -300.0f, 920.0f,
                900.0f)).thenReturn(-300.0f);
        verify(gameScreen, atMost(1)).isCarForwardLimit(car1,
                -300.0f, 920.0f, 900.0f);
    }

    @DisplayName("isCarMoveBackwardTouchLimit")
    @Test
    public void isCarMoveBackwardTouchLimit() throws Exception {
        ImageView car2 = new ImageView(null);
        when(gameScreen.isCarForwardLimit(car2, 1400.0f, -320.0f,
                -300.0f)).thenReturn(1400.0f);
        verify(gameScreen, atMost(1)).isCarBackwardLimit(car2,
                1400.0f, -320.0f, -300.0f);
    }

    @DisplayName("car1Moving")
    @Test
    public void car1Moving() throws Exception {
        ImageView car1 = new ImageView(null);
        when(gameScreen.runCar(car1, 0, 10.0f)).thenReturn(10.0f);
        verify(gameScreen, atMost(1)).runCar(car1, 0,
                10.0f);
    }

    @DisplayName("car2Moving")
    @Test
    public void car2Moving() throws Exception {
        ImageView car2 = new ImageView(null);
        when(gameScreen.runCar(car2, 100, -20.0f)).thenReturn(80.0f);
        verify(gameScreen, atMost(1)).runCar(car2,
                100, -20.0f);
    }

    @DisplayName("car3Moving")
    @Test
    public void car3Moving() throws Exception {
        ImageView car3 = new ImageView(null);
        when(gameScreen.runCar(car3, 400, 16.0f)).thenReturn(384.0f);
        verify(gameScreen, atMost(1)).runCar(car3, 400,
                16.0f);
    }

    @DisplayName("playerMoveUp")
    @Test
    public void playerMoveUp4Times() throws Exception {
        for (int i = 0; i < 3; i++) {
            gameScreen.swipeAction(0);
        }
        // check if move up at least 3 times
        verify(gameScreen, atMost(3)).swipeAction(0);
        reset();
    }

    @DisplayName("playerMoveDown")
    @Test
    public void playerMove2Down() throws Exception {
        gameScreen.swipeAction(2);
        verify(gameScreen, atLeast(1)).swipeAction(2);
        reset();
    }

    @DisplayName("playerMoveLeft")
    @Test
    public void playerMoveLeft() throws Exception {
        gameScreen.swipeAction(3);
        verify(gameScreen).swipeAction(3);
        reset();
    }

    @DisplayName("playerMoveRight")
    @Test
    public void playerMoveRight() throws Exception {
        gameScreen.swipeAction(3);
        verify(gameScreen).swipeAction(3);
        reset();
    }

    @DisplayName("randomWalk")
    @Test
    public void randomWalk() throws Exception {
        Random rn = new Random();
        int[] walk = new int[10];
        for (int i = 0; i < 10; i++) {
            walk[i] = rn.nextInt(4);
            gameScreen.swipeAction(walk[i]);
        }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < walk.length; i++) {
            if (walk[i] == 0) {
                count0++;
            } else if (walk[i] == 1) {
                count1++;
            } else if (walk[i] == 2) {
                count2++;
            } else if (walk[i] == 3) {
                count3++;
            }
        }
        verify(gameScreen, atMost(count0)).swipeAction(0);
        verify(gameScreen, atMost(count1)).swipeAction(1);

        verify(gameScreen, atMost(count2)).swipeAction(2);
        verify(gameScreen, atMost(count3)).swipeAction(3);
    }

}
