package bridge.domain.gameOver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

class GameRestartOrQuitTest {
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 게임_재시작_또는_종료_여부를_입력받고_유효성_검사를_한_후_반환한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = GameRestartOrQuit.takeGameRestartOrQuitCommand();

        assertThat(result).isEqualTo(input);
    }

    @ValueSource(strings = {"A", "bb", "@$%", "ABC", "가나다", "RRRR", "1234"})
    @EmptySource
    @ParameterizedTest
    void 게임_재시작_또는_종료_여부를_입력받고_유효성_검사했을_때_이상이_있을_경우_예외처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            GameRestartOrQuit.takeGameRestartOrQuitCommand();

            assertThat(outputStream.toString()).contains("[ERROR]");
        } catch (NoSuchElementException ignore) {
        }
    }
}