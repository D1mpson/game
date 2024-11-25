package com.example.game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    GameLogic gameLogic = new GameLogic();

    @Test
    void testGetNextStep_startToVerifyPredictions() {
        String nextStep = gameLogic.getNextStep("start", "Перевірити передбачення");
        assertEquals("verify_predictions", nextStep);
    }

    @Test
    void testGetNextStep_startToDeleteProgram() {
        String nextStep = gameLogic.getNextStep("start", "Видалити програму");
        assertEquals("delete_program", nextStep);
    }

//    @Test
//    void testGetNextStep_invalidAnswer() {
//        String nextStep = gameLogic.getNextStep("start", "Невідомий вибір");
//        assertEquals("start", nextStep);
//    }
}