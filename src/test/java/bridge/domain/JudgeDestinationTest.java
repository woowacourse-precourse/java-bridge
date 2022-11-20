package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import bridge.constant.GameState;
import bridge.util.Validate;
import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JudgeDestinationTest {

    private InputView inputView = new InputView();
    private GameState statement = new GameState();

    private final Boolean GAME_OVER = false;
    private final Boolean RESTART = true;

    @ParameterizedTest
    @ValueSource(strings = {"E", "123", "J"})
    @DisplayName("게임 재시작 종료 판별, 종료시 예외 입력시 오류 발생")
    void judgeRestartOrOverException(String input) {
        Validate validate = new Validate();
        Assertions.assertThatThrownBy(() -> {
            validate.validateGameDefinition(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 재시작 종료 판별, 종료시 예외 입력시 오류 발생")
    void judgeRestartOrOver() {
        JudgeDestination judgeDestination = new JudgeDestination();
        Boolean result = judgeDestination.judgeRestartOrOver(statement.QUIT);
        Boolean result2 = judgeDestination.judgeRestartOrOver(statement.RETRY);
        Assertions.assertThat(result).isEqualTo(GAME_OVER);
        Assertions.assertThat(result2).isEqualTo(RESTART);
    }


}