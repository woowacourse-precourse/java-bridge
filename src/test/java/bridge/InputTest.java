package bridge;

import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("유저에게 입력받는 값을 검증")
public class InputTest {

    @ParameterizedTest(name = "입력받은 값이 {0}일 때")
    @ValueSource(strings = {"3", "5", "10", "15", "20"})
    void 다리의_길이가_범위에_있는_경우(String input) {
        InputView.validateBridgeSize(input);
    }

    @ParameterizedTest(name = "입력받은 값이 {0}일 때 예외처리")
    @ValueSource(strings = {"0", "1", "2", "21", "22"})
    void 다리의_길이가_범위에_없는_경우(String input) {
        Assertions.assertThatThrownBy(() -> InputView.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.");
    }

    @ParameterizedTest(name = "입력받은 값이 {0}일 때")
    @ValueSource(strings = {"U", "D"})
    void 이동할_칸의_입력_값이_올바른_경우(String input) {
        InputView.validateMoveInput(input);
    }

    @ParameterizedTest(name = "입력받은 값이 {0}일 때 예외처리")
    @ValueSource(strings = {"A", "B", "C", "UU", "UD", "DU", "DD"})
    void 이동할_칸의_입력_값이_틀린_경우(String input) {
        Assertions.assertThatThrownBy(() -> InputView.validateMoveInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸은 U 또는 D만 입력할 수 있습니다.");
    }

    @ParameterizedTest(name = "입력받은 값이 {0}일 때")
    @ValueSource(strings = {"R", "Q"})
    void 재시작_여부_입력_값이_올바른_경우(String input) {
        InputView.validateCommand(input);
    }

    @ParameterizedTest(name = "입력받은 값이 {0}일 때 예외처리")
    @ValueSource(strings = {"A", "B", "C", "RR", "QR", "RQ", "QQ"})
    void 재시작_여부_입력_값이_틀린_경우(String input) {
        Assertions.assertThatThrownBy(() -> InputView.validateCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 재시작 여부는 R 또는 Q만 입력할 수 있습니다.");
    }

}
