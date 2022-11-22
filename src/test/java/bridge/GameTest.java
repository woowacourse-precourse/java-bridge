package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest extends NsTest {

    @DisplayName("다리 사이즈가 범위 안에 있지 않으면 예외 처리")
    @ValueSource(strings = {"2", "21"})
    @ParameterizedTest
    void testBridgeSizeNotInRange(String input) {
        assertThatThrownBy(() ->runException(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 시 Q를 입력하면 -1 return")
    @Test
    void testRetryGameQ() throws Exception {
        Method retryMethod = Game.class.getDeclaredMethod("retryGame");
        retryMethod.setAccessible(true);
        String input = "Q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int value = (int)retryMethod.invoke(1);

        assertTrue(value == -1);
    }

    @DisplayName("게임 흐름이 잘 흘러가는지 확인_성공")
    @Test
    void testGameSuccess() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O |   | O |   ]",
                    "[   |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O | O |   | O |   ]");
            int downSideIndex = output().indexOf("[   |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0, 1, 0);
    }

    @DisplayName("게임 흐름이 잘 흘러가는지 확인_실패")
    @Test
    void testGameFailed() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "D", "U", "D","Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O |   | O |   ]",
                    "[   |   | O |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O | O |   | O |   ]");
            int downSideIndex = output().indexOf("[   |   | O |   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0, 1, 1);
    }

    @DisplayName("게임 흐름 예외 확인")
    @Test
    void testGameException() {
        assertThatThrownBy(() ->
                runException("3, K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        new Game();
    }
}