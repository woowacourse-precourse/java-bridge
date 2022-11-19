package bridge;

import bridge.service.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static BridgeGame bridgeGame = new BridgeGame();
    
    @Test
    @DisplayName("결과_참_확인")
    public void trueCheck() {
        boolean actual = bridgeGame.move("U", List.of("U", "D", "U"), 0);
        Assertions.assertThat(actual).isEqualTo(true);
    }
    
    @Test
    @DisplayName("결과_거짓_확인")
    public void falseCheck() {
        boolean actual = bridgeGame.move("D", List.of("U", "D", "U"), 0);
        Assertions.assertThat(actual).isEqualTo(false);
    }
    @Test
    @DisplayName("다리길이_빈값_입력_예외")
    public void bridgeLengthNull() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리길이_최솟값_미달")
    public void bridgeLengthMin() {
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리길이_최대값_초과")
    public void bridgeLengthOverMax() {
        assertSimpleTest(() -> {
            run("59");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("이동_입력_예외1")
    public void moveFail1() {
        assertSimpleTest(() -> {
            run("3", "G");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("이동_입력_예외2")
    public void moveFail2() {
        assertSimpleTest(() -> {
            run("3", "");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다시시작_예외")
    public void retryFail() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "o");
            assertThat(output()).contains(
                    (ERROR_MESSAGE)
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("다시시작_빈값")
    public void retryNull() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "");
            assertThat(output()).contains(
                    (ERROR_MESSAGE)
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}

