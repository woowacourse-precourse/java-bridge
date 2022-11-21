package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

    @DisplayName("3이상 20이하가 아닌 수일 경우 예외가 발생한다")
    @ValueSource(strings = {"-1", "0", "2", "21"})
    @ParameterizedTest()
    void 다리_길이_입력_범위_테스트(String size) {
        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.readBridgeSizeValidation(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수가 아닐 경우 예외가 발생한다")
    @ValueSource(strings = {"-j", "e5", "$", ""})
    @ParameterizedTest()
    void 잘못된_다리_길이_범위_테스트(String size) {
        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.readBridgeSizeValidation(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U(위 칸)와 D(아래 칸) 중 하나의 문자가 아닌 경우 예외가 발생한다")
    @ValueSource(strings = {"u", "d", "", "UD"})
    @ParameterizedTest()
    void 라운드마다_플레이어가_이동할_칸을_입력_값_테스트(String move) {
        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.readMovingValidation(move))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R(재시작)과 Q(종료) 중 하나의 문자가 아닌 경우 예외가 발생한다")
    @ValueSource(strings = {"r", "q", "", "RQ"})
    @ParameterizedTest()
    void 게임_재시작_종료_여부를_입력_값_테스트(String command) {
        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.readGameCommandValidation(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

}