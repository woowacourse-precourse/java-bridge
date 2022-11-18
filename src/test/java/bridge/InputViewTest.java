package bridge;

import domain.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private static final InputView inputView = new InputView();

    @Test
    @DisplayName("bridge 사이즈 요구사항 외의 값을 예외처리한다.")
    public void 다리_길이_검증_테스트() throws Exception {
        //given
        String[] inputs = {" ","다리","21","2"};

        //when then
        for (String input : inputs) {
            Assertions.assertThatThrownBy(() -> inputView.validateBridge(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("다리 건너기 위한 커맨드(U, D) 를 제외한 모든 값을 예외처리한다.")
    public void 다리_건너는_커맨드_입력_예외처리() throws Exception {
        //given
        String[] inputs = {"UP","DOWN","u","d"};

        //when then
        for (String input : inputs) {
            Assertions.assertThatThrownBy(() -> inputView.validateMovingCommand(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("게임 재시작 및 종료 커맨드(R, Q)를 제외한 모든 값을 예외처리한다.")
    public void 게임_엔딩_입력값_예외처리() throws Exception {
        //given
        String[] inputs = {"q","r"};

        //when then
        for (String input : inputs) {
            Assertions.assertThatThrownBy(() -> inputView.validateMovingCommand(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}