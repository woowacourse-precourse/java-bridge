package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.InputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest extends NsTest {

    @DisplayName("다리 길이 공백 입력 테스트")
    @ValueSource(strings = {" ", "\n"})
    @ParameterizedTest
    void createBlankBridgeSize(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.BLANK_BRIDGE_LENGTH.getExceptionMessage());
        });
    }

    @DisplayName("숫자가 아닌 다리 길이 입력 테스트")
    @ValueSource(strings = {"k", "5291j", "akefjlw", "2j5j21", "@"})
    @ParameterizedTest
    void createNotNumberBridgeSize(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.NOT_NUMBER_BRIDGE_LENGTH.getExceptionMessage());
        });
    }

    @DisplayName("범위를 벗어난 다리 길이 입력 테스트")
    @ValueSource(strings = {"2", "21", "0", "52"})
    @ParameterizedTest
    void createInvalidRangeBridgeSize(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.OUT_OF_RANGE_BRIDGE_LENGTH.getExceptionMessage());
        });
    }

    @DisplayName("플레이어 이동 공백인지 확인하는 테스트")
    @ValueSource(strings = {" ", "\n"})
    @ParameterizedTest
    void createBlankUserMove(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(InputException.BLANK_PLAYER_MOVE.getExceptionMessage());
        });
    }

    @DisplayName("플레이어의 이동이 U,D가 아닌 입력 테스트")
    @ValueSource(strings = {"q", "u", "@", "8"})
    @ParameterizedTest
    void createInvalidUserMove(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(InputException.INVALID_PLAYER_MOVE.getExceptionMessage());
        });
    }

    @DisplayName("게임 재시작/종료 여부 공백 입력 테스트")
    @ValueSource(strings = {" ", "\n"})
    @ParameterizedTest
    void createBlankGameCommand(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", input);
            assertThat(output()).contains(InputException.BLANK_GAME_END_INPUT.getExceptionMessage());
        }, 1, 1, 1);
    }

    @DisplayName("게임 재시작/종료가 R, Q가 아닌 테스트")
    @ValueSource(strings = {"r", "q", "3", "*", "w", "make"})
    @ParameterizedTest
    void createInvalidGameCommand(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", input);
            assertThat(output()).contains(InputException.INVALID_GAME_END_INPUT.getExceptionMessage());
        }, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
