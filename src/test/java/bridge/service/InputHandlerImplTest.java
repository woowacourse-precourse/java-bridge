package bridge.service;

import bridge.Constants.ErrorMessageConstant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerImplTest {
    private final InputHandlerImpl inputHandler = new InputHandlerImpl();

    @Test
    void 다리_길이_공백처리_및_정상_테스트() {
        String INPUT = "3   ";
        int EXPECTED_RESULT = 3;

        assertThat(inputHandler.getBridgeSize(INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void 다리_길이_상한선_에러_테스트() {
        String INPUT = "21   ";
        assertThatThrownBy(() -> inputHandler.getBridgeSize(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INVALID_BRIDGE_LENGTH);
    }

    @Test
    void 다리_길이_하한선_에러_테스트() {
        String INPUT = "2   ";
        assertThatThrownBy(() -> inputHandler.getBridgeSize(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INVALID_BRIDGE_LENGTH);
    }

    @Test
    void 다리_길이_숫자_처리_에러_테스트() {
        String INPUT = "  31abc   ";
        assertThatThrownBy(() -> inputHandler.getBridgeSize(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.NOT_INTEGER);
    }

    @Test
    void 이동_명령어_D_공백_처리_및_정상_테스트() {
        String INPUT = "  D   ";
        String EXPECTED_RESULT = "D";
        assertThat(inputHandler.getMovingCommand(INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void 이동_명령어_U_공백_처리_및_정상_테스트() {
        String INPUT = "  U   ";
        String EXPECTED_RESULT = "U";
        assertThat(inputHandler.getMovingCommand(INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void 이동_명령어_D_에러_테스트() {
        String INPUT = "  D  3 ";
        assertThatThrownBy(() -> inputHandler.getMovingCommand(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INVALID_MOVING_COMMAND);
    }

    @Test
    void 이동_명령어_U_에러_테스트() {
        String INPUT = "  U  3 ";
        assertThatThrownBy(() -> inputHandler.getMovingCommand(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INVALID_MOVING_COMMAND);
    }


    @Test
    void 종료_명령어_Q_공백_처리_및_정상_테스트() {
        String INPUT = "  Q   ";
        String EXPECTED_RESULT = "Q";
        assertThat(inputHandler.getGameCommand(INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void 종료_명령어_R_공백_처리_및_정상_테스트() {
        String INPUT = "  R   ";
        String EXPECTED_RESULT = "R";
        assertThat(inputHandler.getGameCommand(INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void 종료_명령어_Q_에러_테스트() {
        String INPUT = "  Q e 3 ";
        assertThatThrownBy(() -> inputHandler.getGameCommand(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INVALID_GAME_OVER_CONTROL_COMMAND);
    }

    @Test
    void 종료_명령어_R_에러_테스트() {
        String INPUT = "  Q  a3 ";
        assertThatThrownBy(() -> inputHandler.getGameCommand(INPUT))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.INVALID_GAME_OVER_CONTROL_COMMAND);
    }

}
