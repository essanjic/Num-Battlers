package org.example.numbattlers.internal.service;

import org.example.numbattlers.internal.entity.Machine;

public class MachineService{

    private static Machine machine = new Machine("Máquina", 0, 0);
    public static void GetMachine(int difficulty) {

        if (difficulty != 1 && difficulty != 2) {
            throw new IllegalArgumentException("Número inválido de dificultad, debe ser 1 o 2.");
        }
        if (difficulty == 1) {
            machine.setDifficulty("fácil");
        } else {
            machine.setDifficulty("difícil");
        }
    }

}





