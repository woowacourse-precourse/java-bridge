package bridge;

import bridge.message.ErrorMessage;
import bridge.message.PrintMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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

    @Override
    protected void runMain() {
        new Game();
    }
}