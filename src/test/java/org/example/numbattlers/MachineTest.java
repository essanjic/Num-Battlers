package org.example.numbattlers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    @Test
    void testResponseGenerate() {
        // Arrange
        Machine machine = new Machine("TestMachine", 0, 0);

        // Act
        String response = machine.responseGenerate();

        // Assert
        assertEquals("implement me!", response, "The response should be 'implement me!'");
    }
    
    @Test
    void testMachineInitialization() {
        // Arrange
        Machine machine = new Machine("TestMachine", 10, 5);

        // Assert
        assertEquals("TestMachine", machine.getName());
        assertEquals(10, machine.getScore());
        assertEquals(5, machine.getTime());
    }
}

