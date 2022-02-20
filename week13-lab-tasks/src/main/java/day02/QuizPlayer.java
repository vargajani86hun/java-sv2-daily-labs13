package day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizPlayer {
    private String id;
    private List<Character> answers = new ArrayList<>();

    public QuizPlayer(String id) {
        this.id = id;
    }

    public void addAnswer(char answer) {
        answers.add(answer);
    }

    public String getId() {
        return id;
    }

    public List<Character> getAnswers() {
        return Collections.unmodifiableList(answers);
    }
}
