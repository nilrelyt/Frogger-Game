package com.example.froggerhome;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;


@DisplayName("Sprint 1 Test Cases")
public class  JunitTestSprint1 {
    private static String expected = "Default Player";
    private Player newPlayer;


    @Before
    public void setUp() {
        newPlayer = new Player("Doan", "1", "3");
    }


    @DisplayName("whitespaceOnlyTest")
    @Test
    public void whitespaceOnlyTest() {
        assertTrue(String.valueOf(newPlayer.isNameValid(newPlayer.getPlayerName())), true);
        newPlayer.setPlayerName("   ");

        assertTrue(String.valueOf(newPlayer.isNameValid(newPlayer.getPlayerName())), true);
        assertEquals(expected, newPlayer.getPlayerName());
    }

    @DisplayName("EmptyTest")
    @Test
    public void isEmptyTest() {
        newPlayer.setPlayerName("");

        assertTrue(String.valueOf(newPlayer.isNameValid(newPlayer.getPlayerName())), true);
        assertEquals(expected, newPlayer.getPlayerName());

    }

    @DisplayName("NullTest")
    @Test
    public void isNullTest() {
        newPlayer.setPlayerName(null);

        assertTrue(String.valueOf(newPlayer.isNameValid(newPlayer.getPlayerName())), true);
        assertEquals(expected, newPlayer.getPlayerName());

    }

    @DisplayName("Easy mode selected, expected lives 5")
    @Test
    public void easyModeLivesTest() {
        newPlayer.selectDifficulty("Easy");

        assertEquals("5", newPlayer.getLives());
    }

    @DisplayName("Medium mode selected, expected lives 3")
    @Test
    public void mediumModeLivesTest() {
        newPlayer.selectDifficulty("Medium");

        assertEquals("3", newPlayer.getLives());
    }

    @DisplayName("Hard mode selected, expected lives 1")
    @Test
    public void hardModeLivesTest() {
        newPlayer.selectDifficulty("Hard");

        assertEquals("1", newPlayer.getLives());
    }

}
