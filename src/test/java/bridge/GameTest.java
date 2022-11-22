package bridge;

import bridge.message.ErrorMessage;
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
    void testMakeGame(String input) {
        assertThatThrownBy(() ->runException(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        new Game();
    }
}