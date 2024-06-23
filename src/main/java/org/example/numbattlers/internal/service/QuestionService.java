package org.example.numbattlers.internal.service;
import com.google.gson.Gson;
import org.example.numbattlers.internal.entity.Question;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class QuestionService {
    private List<Question> questions;

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

    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}