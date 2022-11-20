package bridge;

import bridge.service.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static BridgeGame bridgeGame = new BridgeGame();
    
    @ParameterizedTest
    @CsvSource({"U,U,D,U,0,true","D,U,D,U,0,false"})
    @DisplayName("결과_확인")
    public void trueCheck(String input, String list1, String list2, String list3, int idx, boolean expect) {
        boolean actual = bridgeGame.move(input, List.of(list1, list2, list3), idx);
        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"G","0","59","..","ab"})
    @DisplayName("다리길이_입력값_예외")
    public void bridgeLengthNull(String length) {
        assertSimpleTest(() -> {
            run(length);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리길이_빈값_입력_예외")
    public void bridgeLengthEmpty() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource({"3,G","1,3","3,5"})
    @DisplayName("이동_입력_예외")
    public void moveFail1(String length, String input) {
        assertSimpleTest(() -> {
            run(length, input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("이동_빈칸_입력")
    public void moveEmpty() {
        assertSimpleTest(() -> {
            run("3", "");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource({"3,U,D,D,o","3,U,D,D,D"})
    @DisplayName("다시시작_예외")
    public void retryFail(String length, String input1, String input2, String input3, String retry) {
        assertRandomNumberInRangeTest(() -> {
            run(length, input1, input2, input3, retry);
            assertThat(output()).contains(
                    (ERROR_MESSAGE)
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("다시시작_빈값")
    public void retryEmpty() {
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

