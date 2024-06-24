package org.example.numbattlers.internal.service;
import org.example.numbattlers.internal.entity.Machine;
import org.example.numbattlers.internal.entity.Player;

import java.util.Random;

public class MachineService {
    private QuestionService questionService;
    private Sleeper sleeper;

    public MachineService(QuestionService questionService, Sleeper sleeper) {
        this.questionService = questionService;
        this.sleeper = sleeper;
    }

    public void machinePlay(Machine machine, String level) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String question = questionService.GetRandomQuestion(level);
            System.out.println(question);
            long responseTime = 0;
            try {
                responseTime = random.nextInt(4) + 6;
                sleeper.sleep(responseTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (responseTime < questionService.getCurrentQuestion().getMaxTime()) {
                machine.setScore((int) (machine.getScore() + 10 + (questionService.getCurrentQuestion().getMaxTime() - responseTime)));
            }
        }
    }
    }




