package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
    }

    @Test
    void addTest() {
        gameResult.add(0, "O");
        List<String>[] result = gameResult.getResult();
        assertThat(result[0]).containsExactly("O");
        assertThat(result[1]).containsExactly(" ");
    }
    @Test
    void addTest2() {
        gameResult.add(0, "X");
        List<String>[] result = gameResult.getResult();
        assertThat(result[0]).containsExactly("X");
        assertThat(result[1]).containsExactly(" ");
    }
    @Test
    void addTest3() {
        gameResult.add(0, "X");
        gameResult.add(1, "O");
        List<String>[] result = gameResult.getResult();
        assertThat(result[0]).containsExactly("X", " ");
        assertThat(result[1]).containsExactly(" ", "O");
    }

    @Test
    void isUnavailableTest() {
        gameResult.add(0, "X");
        int lastIndex = 0;
        assertThat(gameResult.isUnavailable(lastIndex)).isEqualTo(true);
    }
    @Test
    void isUnavailableTest2() {
        gameResult.add(0, "O");
        int lastIndex = 0;
        assertThat(gameResult.isUnavailable(lastIndex)).isEqualTo(false);
    }

    @Test
    void clearTest() {
        gameResult.add(0, "O");
        gameResult.clear();
        List<String>[] result = gameResult.getResult();
        assertThat(result[0].isEmpty()).isEqualTo(true);
        assertThat(result[1].isEmpty()).isEqualTo(true);
    }
}