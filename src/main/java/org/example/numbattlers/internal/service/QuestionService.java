package org.example.numbattlers.internal.service;
import com.google.gson.Gson;
import org.example.numbattlers.internal.entity.Player;
import org.example.numbattlers.internal.entity.Question;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestionService {
    private List<Question> questions;
    private List<Question> usedQuestions = new ArrayList<>();
    private Question currentQuestion;

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public QuestionService(String filePath) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            questions = gson.fromJson(reader, new TypeToken<List<Question>>() {}.getType());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String GetRandomQuestion(String level){
        Random random = new Random();
        Question question = null;
        int key;

        if (level.equals("fácil")) {
            key = random.nextInt(40) + 1;
        } else {
            key = random.nextInt(45) + 41;
        }


        List<Question> availableQuestions = questions.stream()
                .filter(q -> !usedQuestions.contains(q) && q.getKey() == key)
                .collect(Collectors.toList());

        if (!availableQuestions.isEmpty()) {
            currentQuestion = availableQuestions.get(random.nextInt(availableQuestions.size())); // set currentQuestion
            usedQuestions.add(currentQuestion);
        }

        String declare = null;
        if (currentQuestion != null) {
            declare = currentQuestion.getDeclare();
        }
        return declare;
    }

    public String getResponse() {
        if (currentQuestion != null) {
            return currentQuestion.getResponse();
        } else {
            return null;
        }
    }

    public void askQuestions(Player player, Scanner scanner, String level) {
        for (int i = 0; i < 10; i++) {
            String question = GetRandomQuestion(level);
            System.out.println(question);
            long startTime = System.currentTimeMillis();
            String answer = scanner.nextLine();
            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;
            if (timeTaken < currentQuestion.getMaxTime()) {
                if (answer.equals(getResponse())) {
                    player.setScore((int) (player.getScore() + 10 + (currentQuestion.getMaxTime() - timeTaken)));
                }
            }
        }
    }
}