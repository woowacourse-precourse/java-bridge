package bridge.playgametest;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {

    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("bridge 길이 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"a", "-1", "2", "21"})
    @ParameterizedTest
    void enterInvalidBridgeLengthTest(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동 관련 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"a", "0", "u", "d"})
    @ParameterizedTest
    void enterInvalidMovingBlockTest(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("재시작 관련 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"a", "0", "r", "q"})
    @ParameterizedTest
    void enterInvalidGameCommandTest(String input) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 1);
    }

    @DisplayName("bridge 길이 입력에 대한 예외처리 후 정상적인 값 입력 시 정상실행 테스트")
    @CsvSource("a,1,3")
    @ParameterizedTest
    void enterValidLengthAfterInvalidTest(
            String bridgeLengthInput1,
            String bridgeLengthInput2,
            String bridgeLengthInput3
    ) {
        assertSimpleTest(() -> {
            runException(bridgeLengthInput1, bridgeLengthInput2, bridgeLengthInput3);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        });
    }

    @DisplayName("이동할 칸 입력에 대한 예외처리 후 정상적인 값 입력 시 정상실행 테스트")
    @CsvSource("a,0,D")
    @ParameterizedTest
    void enterValidMovingBlockAfterInvalidTest(
            String invalidMovingInput1,
            String invalidMovingInput2,
            String validMovingInput
    ) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", invalidMovingInput1, invalidMovingInput2, validMovingInput);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("[ O ]");
        }, 0, 0, 1);
    }

    @DisplayName("재시작 관련 입력에 대한 예외처리 후 정상적인 값 입력 시 정상실행 테스트")
    @CsvSource("a,0,Q")
    @ParameterizedTest
    void enterValidGameCommandAfterInvalidTest(
            String invalidMovingInput1,
            String invalidMovingInput2,
            String validMovingInput
    ) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", invalidMovingInput1, invalidMovingInput2, validMovingInput);
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("최종 게임 결과");
        }, 0, 0, 1);
    }

    @Override
    protected void runMain() {

        Application.main(new String[]{});
    }
}
