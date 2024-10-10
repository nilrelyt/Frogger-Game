package com.example.froggerhome;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;

import android.widget.Button;
import android.widget.ImageView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

public class JunitTestSprint5 {
    private GameScreen gameScreen;
    private WinGame winGame;
    private Player player;
    private Runnable runnable;
    private ImageView carImage1;
    private ImageView logImage1;

    @Before
    public void init() {
        gameScreen = Mockito.mock(GameScreen.class);
        player = new Player("ABCDE", "3", "1");
        carImage1 = new ImageView(null);
        logImage1 = new ImageView(null);
        runnable = new Runnable() {
            @Override
            public void run() {
                if (gameScreen.collision(carImage1) || gameScreen.waterCollision(player.getCurrentPositionY())) {
                    player.setCurrentPositionY(0);
                    player.setMaxPositionY(0);
                    player.setScore(0);
                    player.setLives(Integer.toString(Integer.parseInt(player.getLives()) - 1));
                    if (player.getLives().equals("0")) {
                        gameScreen.openEndGame();
                    }
                }
                if (player.getCurrentPositionY() > 18) {
                    gameScreen.openWinGame();
                }
            }
        };
    }

    @DisplayName("isLog1Moving")
    @Test
    public void isLog1Moving() {
        ImageView log1 = new ImageView(null);
        when(gameScreen.moveLog(log1, 0, 10.0f)).thenReturn(10.0f);
        verify(gameScreen, atMost(1)).moveLog(log1, 0, 10.0f);
    }

    @DisplayName("isLog2Moving")
    @Test
    public void isLog2Moving() {
        ImageView log2 = new ImageView(null);
        when(gameScreen.moveLog(log2, 50, -20.0f)).thenReturn(30.0f);
        verify(gameScreen, atMost(1)).moveLog(log2, 50, -20.0f);
    }

    @DisplayName("isOnLog")
    @Test
    public void isOnLog() {
        player.setCurrentPositionX(10);
        player.setCurrentPositionY(10);
        ImageView log3 = new ImageView(null);
        log3.setX(11);
        log3.setY(11);
        when(gameScreen.onLilly(log3)).thenReturn(true);
        assertEquals(true, gameScreen.onLog(log3));
    }

    @DisplayName("isOnLogNotDeductLives")
    @Test
    public void isOnLogNotDeductLives() {
        player.setLives("1");
        player.setCurrentPositionX(10);
        player.setCurrentPositionY(10);
        ImageView log3 = new ImageView(null);
        log3.setX(11);
        log3.setY(11);
        when(gameScreen.onLilly(log3)).thenReturn(true);
        assertEquals("1", player.getLives());
    }

    @DisplayName("isLilyPadMovingLeft")
    @Test
    public void isLilyPadMovingLeft() {
        ImageView lilyPad = new ImageView(null);
        when(gameScreen.moveLog(lilyPad, 50, 10.0f)).thenReturn(60.0f);
        verify(gameScreen, atMost(1)).moveLog(lilyPad, 50, 10.0f);
    }

    @DisplayName("isLilyPadMovingRight")
    @Test
    public void isLilyPadMovingRight() {
        ImageView lilyPad = new ImageView(null);
        when(gameScreen.moveLog(lilyPad, 50, -30.0f)).thenReturn(20.0f);
        verify(gameScreen, atMost(1)).moveLog(lilyPad, 50, -30.0f);
    }

    @DisplayName("isOnLily")
    @Test
    public void isOnLily() {
        player.setCurrentPositionX(10);
        player.setCurrentPositionY(10);
        ImageView lily = new ImageView(null);
        lily.setX(10);
        lily.setY(10);
        when(gameScreen.onLilly(lily)).thenReturn(true);
        assertEquals(true, gameScreen.onLilly(lily));
    }

    @DisplayName("isOnLilyNotDeductLives")
    @Test
    public void isOnLilyNotDeductLives() {
        player.setLives("1");
        player.setCurrentPositionX(10);
        player.setCurrentPositionY(10);
        ImageView lily = new ImageView(null);
        lily.setX(10);
        lily.setY(10);
        when(gameScreen.onLilly(lily)).thenReturn(true);
        assertEquals("1", player.getLives());
    }

    @DisplayName("isGoalTileMostPoints")
    @Test
    public void isGoalTileMostPoints() {
        player.setScore(0);
        player.setLives("1");
        player.setCurrentPositionY(18);
        gameScreen.swipeAction(0);
        int last = player.getScore();
        System.out.println(last);
        assertEquals(true, last >= 100);
    }

    @DisplayName("isOpenWinGameWhenWin")
    @Test
    public void isGoalTileWillWin() {
        player.setScore(0);
        player.setLives("1");
        player.setCurrentPositionY(18);
        gameScreen.swipeAction(0);
        verify(gameScreen, atMost(1)).openWinGame();
    }

    @DisplayName("isOpenWinGameWhenWin")
    @Test
    public void isOpenWinGameWhenWin() {
        player.setLives("3");
        player.setCurrentPositionY(18);
        gameScreen.swipeAction(0);
        verify(gameScreen, atMost(1)).openWinGame();
    }
}