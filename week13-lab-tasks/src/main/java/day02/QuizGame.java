package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizGame {
    private String solutions;
    private List<QuizPlayer> players = new ArrayList<>();

    public void readFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);

            solutions = lines.get(0);
            for (int i = 1; i < lines.size(); i++) {
                parseAnswer(lines.get(i));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot reach file", ioe);
        }
    }

    public boolean isAnswerRight(String id, int number) {
        QuizPlayer player = getPlayer(id);
        if (player != null) {
            return solutions.toCharArray()[number - 1]
                    == player.getAnswers().get(number - 1);
        }
        throw new IllegalArgumentException("Player with id " + id + " is not exist!");
    }

    public String getWinnerId() {
        int max = Integer.MIN_VALUE;
        String winner = players.get(0).getId();
        for (QuizPlayer qp : players) {
            int point = getPlayerPoints(qp);
            if (point > max) {
                max = point;
                winner = qp.getId();
            }
        }
        return winner;
    }

    public String getSolutions() {
        return solutions;
    }

    public List<QuizPlayer> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    private void parseAnswer(String line) {
        String[] values = line.trim().split(" ");
        QuizPlayer player = getPlayer(values[0]);
        if (player == null) {
            player = new QuizPlayer(values[0]);
            players.add(player);
        }
        player.addAnswer(values[1].charAt(0));
    }

    private QuizPlayer getPlayer(String id) {
        for (QuizPlayer qp : players) {
            if (qp.getId().equals(id)) {
                return qp;
            }
        }
        return null;
    }

    private int getPlayerPoints(QuizPlayer qp) {
        int points = 0;

        for (int i = 1; i <= solutions.length(); i++) {
            if (isAnswerRight(qp.getId(), i )) {
                points += i;
            } else if (qp.getAnswers().get(i - 1) != 'X') {
                points -= 2;
            }
        }

        return points;
    }
}
