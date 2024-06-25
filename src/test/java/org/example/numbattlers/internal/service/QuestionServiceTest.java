package org.example.numbattlers.internal.service;

import org.example.numbattlers.internal.entity.Player;
import org.example.numbattlers.internal.entity.Question;
import org.example.numbattlers.internal.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionServiceTest {
    private QuestionService questionService;
    private List<Question> questions;
    private List<Question> usedQuestions;
    private Random random;
    @BeforeEach
    public void setUp() {
        questions = new ArrayList<>();
        usedQuestions = new ArrayList<>();
        random = mock(Random.class);

        questions.add(new Question(1, "Declare 1", "Answer 1", "fácil", 10));
        questions.add(new Question(2, "Declare 2", "Answer 2", "fácil", 10));
        questions.add(new Question(42, "Declare 3", "Answer 3", "difícil", 10));

        questionService = new QuestionService(questions, usedQuestions, null, random);
    }
    @Test
    public void testQuestionServiceConstructor() {
        // Arrange
        List<Question> questions = new ArrayList<>();
        List<Question> usedQuestions = new ArrayList<>();
        Question currentQuestion = mock(Question.class);

        // Act
        QuestionService questionService = new QuestionService(questions, usedQuestions, currentQuestion, random);

        // Assert
        assertEquals(currentQuestion, questionService.getCurrentQuestion());
    }

    @Test
    public void testGetRandomQuestionWithAvailableQuestions() {
        // Arrange
        when(random.nextInt(40)).thenReturn(1); // Genera una clave de 2 para "fácil"
        when(random.nextInt(1)).thenReturn(0); // Selecciona el primer elemento en availableQuestions

        String level = "fácil";

        // Act
        String question = questionService.GetRandomQuestion(level);

        // Assert
        assertNotNull(question);
        assertEquals("Declare 2", question);

        Question currentQuestion = questionService.getCurrentQuestion();
        assertNotNull(currentQuestion);
        assertEquals(2, currentQuestion.getKey());
        assertEquals(1, usedQuestions.size());
        assertTrue(usedQuestions.contains(currentQuestion));
    }

    @Test
    public void testGetRandomQuestionEasyLevel() {
        // Arrange
        List<Question> questions = new ArrayList<>();
        List<Question> usedQuestions = new ArrayList<>();
        Question currentQuestion = mock(Question.class);
        QuestionService questionService = new QuestionService(questions, usedQuestions, currentQuestion, random);
        String level = "fácil";

        // Act
        String question = questionService.GetRandomQuestion(level);

        // Assert
        assertEquals(currentQuestion, questionService.getCurrentQuestion());
        assertEquals(question, questionService.getCurrentQuestion().getLevel());
    }
    @Test
    public void testGetRandomQuestionHardLevel() {
        // Arrange
        List<Question> questions = new ArrayList<>();
        List<Question> usedQuestions = new ArrayList<>();
        Question currentQuestion = mock(Question.class);
        QuestionService questionService = new QuestionService(questions, usedQuestions, currentQuestion, random);
        String level = "dificil";

        // Act
        String question = questionService.GetRandomQuestion(level);

        // Assert
        assertEquals(currentQuestion, questionService.getCurrentQuestion());
    }

    @Test
    public void testGetResponseIsSuccess() {
        // Arrange
        Question currentQuestion = new Question(1, "Declare 1", "Answer 1", "fácil", 10);
        questionService = new QuestionService(questions, usedQuestions, currentQuestion, random);

        // Act
        String response = questionService.getResponse();

        // Assert
        assertEquals("Answer 1", response);
    }

    @Test
    public void testGetResponseIsNull() {
        // Arrange
        questionService = new QuestionService(questions, usedQuestions, null, random);

        // Act
        String response = questionService.getResponse();

        // Assert
        assertNull(response);
    }
    @Test
    public void testQuestionServiceConstructorWithFilePath() throws IOException {
        // Arrange
        String filePath = "src/main/java/org/example/numbattlers/internal/repository/seeders.json";

        // Act
        QuestionService questionService = new QuestionService(filePath);

        // Assert
        assertNotNull(questionService);
    }
    @Test
    public void testQuestionServiceConstructorWithFilePathIsBadShouldReturnException() {
        // Arrange
        String filePath = "src/main/java/org/example/numbattlers/internal/repository/repo.xml";


        // Act & Assert
        assertThrows(IOException.class, () -> new QuestionService(filePath));
    }

    @Test
    public void testAskQuestions() {
        // Arrange
        Player player = new Player("Test Player", 0, 0);
        String level = "fácil";
        Scanner scanner = new Scanner(new ByteArrayInputStream("Answer 1\nAnswer 2\nAnswer 3\nAnswer 4\nAnswer 5\nAnswer 6\nAnswer 7\nAnswer 8\nAnswer 9\nAnswer 10\n".getBytes()));

        when(random.nextInt(40)).thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        when(random.nextInt(1)).thenReturn(0);
        when(random.nextInt(40)).thenReturn(42);
        when(random.nextInt(anyInt())).thenReturn(0);

        // Act
        questionService.askQuestions(player, scanner, level);

        // Assert
        assertTrue(player.getScore() > 0);
        assertEquals("Test Player", player.getName());
    }
}
