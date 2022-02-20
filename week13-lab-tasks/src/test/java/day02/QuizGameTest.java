package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizGameTest {

    private QuizGame quizGame = new QuizGame();

    @Test
    void testReadFile() {
        quizGame.readFile(Path.of("src/test/resources/result.txt"));

        assertEquals("ABACD", quizGame.getSolutions());
        assertEquals(4, quizGame.getPlayers().size());
    }

    @Test
    void testWinner() {
        quizGame.readFile(Path.of("src/test/resources/result.txt"));

        assertEquals("GH1234", quizGame.getWinnerId());
    }
}