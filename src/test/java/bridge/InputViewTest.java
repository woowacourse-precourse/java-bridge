package bridge;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputValidation;

public class InputViewTest {

    InputValidation inputValidation = new InputValidation();

    @DisplayName("입력받은 수가 3미만 20초과 일떄 에러가 발생한다.")
    @Test
    void 다리길이_입력값_범위_예외처리() {
        assertThatThrownBy(
                () -> {
                    List<String> inputList = asList("1", "2", "21", "22", "23", "24", "100");

                    for (String input : inputList) {
                        InputValidation.validateBridgeSize(input);
                    }
                    ;
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 입력값을 넣을때 'D'나 'U'를 제외한 나머지는 에러가 발생한다. ")
    @Test
    void 다리이동_입력값_예외처리() {
        assertThatThrownBy(
                () -> {
                    List<String> inputList = asList("1", "2", "Q", "R", "C", "d", "u");

                    for (String input : inputList) {
                        InputValidation.validateBridgeSize(input);
                    }
                    ;
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부 입력값을 넣을때 'Q'나 'R'을 제외한 나머지는 에러가 발생한다. ")
    @Test
    void 게임재시작_입력값_예외처리() {
        assertThatThrownBy(
                () -> {
                    List<String> inputList = asList("1", "2", "D", "U", "C", "q", "r");

                    for (String input : inputList) {
                        InputValidation.validateBridgeSize(input);
                    }
                    ;
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }
}


