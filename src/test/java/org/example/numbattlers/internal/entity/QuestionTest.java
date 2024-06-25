package org.example.numbattlers.internal.entity;

import org.example.numbattlers.internal.entity.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    @Test
    void testResponseGenerate() {
        // Arrange
        Question question = new Question(31, "I'm a test?", "Yest, i'm a test.", "fácil", 10);
        final String declareExpected = "I'm Other Question?";
        final String declareResponse = "Yes, I'm Other Question.";
        final String levelExpected = "difícil";
        final int maxTimeExpected = 20;

        // Act
        question.getKey();
        question.setDeclare(declareExpected);
        question.getDeclare();
        question.setResponse(declareResponse);
        question.getResponse();
        question.setLevel(levelExpected);
        question.getLevel();
        question.setMaxTime(maxTimeExpected);


        // Assert
        assertEquals(31, question.getKey());
        assertEquals(declareExpected, question.getDeclare());
        assertEquals(declareResponse, question.getResponse());
        assertEquals(levelExpected, question.getLevel());
        assertEquals(maxTimeExpected, question.getMaxTime());
    }
}
