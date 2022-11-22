package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;

public class ExceptionTest extends NsTest {
    final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 생성 길이의 범위를 벗어남")
    @Test
    void RangeOutOfBridgeSize() {
        assertSimpleTest(() -> {
            runException("2", "21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 생성 시에 숫자가 아닌 값을 넣을 경우")
    @Test
    void IncorrectInput() {
        assertSimpleTest(() -> {
            runException("a", "b", "c", "%", "#");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 생성 후 u,d,U,D가 아닌 움직임 명령을 넣을 경우")
    @Test
    void IncorrectInput2() {
        assertSimpleTest(() -> {
            runException("3", "A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("움직임이 틀렸을 때 재시작 혹은 종료가 아닌 값을 입력했을 때")
    @Test
    void IncorrectInput3() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            runException("3", "D", "U", "G");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, new ArrayList<>(Arrays.asList(1, 0, 1)));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
