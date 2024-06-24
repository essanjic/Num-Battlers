package org.example.numbattlers.internal.entity;

import org.example.numbattlers.internal.entity.Machine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    @Test
    void testResponseGenerate() {
        // Arrange
        Machine machine = new Machine("TestMachine", 0, 0);

        // Act
        machine.setScore(200);
        machine.getName();

        // Assert
        assertEquals(200, machine.getScore());
        assertEquals("TestMachine", machine.getName());
    }
}
