package bridge.validation;

import bridge.view.InputView;
import bridge.view.validation.BridgeLengthValidator;
import bridge.view.validation.InputMoveValidator;
import bridge.view.validation.InputRestartValidator;
import bridge.vo.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class inputValidationTest {

    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRDIGE_LENGTH = 20;

    @DisplayName("3에서 20 사이의 숫자 외에 공백, 한글 등 조건에 맞지 않는 값이 입력되면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "22222222222222222222222222", "-1", "기", "aa", "2"})
    public void 잘못된_다리_길이_입력에_대한_예외_테스트(String input) {

        assertThatThrownBy(() -> BridgeLengthValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR_MESSAGE.toString(),
                        MIN_BRIDGE_LENGTH, MAX_BRDIGE_LENGTH));
    }

    @DisplayName("U, D 이외의 값이 이동 방향으로 입력되면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "UU", "DD", "UD", "u", "d", "111111111111111111"})
    public void 잘못된_이동_방향_입력에_대한_예외_테스트(String input) {
        assertThatThrownBy(() -> InputMoveValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_NOT_U_AND_NOT_D_MESSAGE.toString());
    }

    @DisplayName("R, Q 이외의 값이 게임 재시작 여부에 대한 값으로 입력되면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "RR", "QQ", "RQ", "r", "q", "111111111111111111"})
    public void 잘못된_게임_재시작_여부_입력_값에_대한_예외_테스트(String input) {
        assertThatThrownBy(() -> InputRestartValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_NOT_R_AND_NOT_Q_MESSAGE.toString());
    }
}
