package org.example.numbattlers.internal.service;

import org.example.numbattlers.internal.entity.Machine;
import org.example.numbattlers.internal.entity.Question;
import org.example.numbattlers.internal.service.MachineService;
import org.example.numbattlers.internal.service.QuestionService;
import org.example.numbattlers.internal.service.Sleeper;
import org.example.numbattlers.internal.service.ThreadSleeper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MachineServiceTest {
    @Test
    void testMachineServiceConstructor() {
        // Arrange
        QuestionService mockQuestionService = mock(QuestionService.class);

        // Act
        MachineService machineService = new MachineService(mockQuestionService, new ThreadSleeper());

        // Assert
        assertNotNull(machineService);
    }
    @Test
    void testMachinePlaySleepInterruptedException() {
        // Arrange
        QuestionService mockQuestionService = mock(QuestionService.class);
        Sleeper mockSleeper = mock(Sleeper.class);
        MachineService machineService = new MachineService(mockQuestionService, mockSleeper);
        Machine machine = new Machine("TestMachine", 0, 0);
        String level = "fácil";
        Question mockQuestion = new Question(1, "Test Question", "Test Answer", "fácil", 10);
        mockQuestion.setMaxTime(10);
        when(mockQuestionService.GetRandomQuestion(level)).thenReturn(String.valueOf(mockQuestion));
        when(mockQuestionService.getCurrentQuestion()).thenReturn(mockQuestion);

        // Act
        try {
            doThrow(new InterruptedException()).when(mockSleeper).sleep(anyLong());
            machineService.machinePlay(machine, level);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockSleeper, times(10)).sleep(anyLong());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testMachinePlay() {
        // Arrange
        QuestionService mockQuestionService = mock(QuestionService.class);
        MachineService machineService = new MachineService(mockQuestionService, new ThreadSleeper());
        Machine machine = new Machine("TestMachine", 0, 0);
        String level = "fácil";
        Question mockQuestion = new Question(1, "Test Question", "Test Answer", "fácil", 10);
        mockQuestion.setMaxTime(10);
        when(mockQuestionService.GetRandomQuestion(level)).thenReturn(String.valueOf(mockQuestion));
        when(mockQuestionService.getCurrentQuestion()).thenReturn(mockQuestion);

        // Act
        machineService.machinePlay(machine, level);

        // Assert
        assertNotEquals(0, machine.getScore());
        assertTrue(machine.getScore() > 0);
    }
}
