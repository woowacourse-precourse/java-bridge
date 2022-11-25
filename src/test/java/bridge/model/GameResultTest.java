package bridge.model;

import bridge.constant.BridgeSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setGameResult() {
        gameResult = new GameResult();
    }

    @DisplayName("함수를 선언하면 초기값을 세팅한다.")
    @Test
    void createSetResult() {
        String expectedAttempt = "0";

        assertThat(gameResult.getSuccess()).isEqualTo(BridgeSymbol.SUCCESS.getState());
        assertThat(gameResult.getAttemptNumber()).isEqualTo(expectedAttempt);
    }

    @DisplayName("시도 횟수 함수를 호출한 만큼 횟수가 증가한다.")
    @ValueSource(ints = {1, 5, 10})
    @ParameterizedTest
    void createAddAttemptNumber(int time) {
        for (int i = 0; i < time; i++) {
            gameResult.addAttemptNumber();
        }
        assertThat(gameResult.getAttemptNumber()).isEqualTo(Integer.toString(time));
    }

    @DisplayName("성공 여부를 성공으로 바꾼다.")
    @Test
    void createChangeSuccess() {
        gameResult.changeSuccess();
        assertThat(gameResult.getSuccess()).isEqualTo(BridgeSymbol.SUCCESS.getState());
    }

    @DisplayName("성공 여부를 실패로 바꾼다.")
    @Test
    void createChangeFail() {
        gameResult.changeFail();
        assertThat(gameResult.getSuccess()).isEqualTo(BridgeSymbol.FAIL.getState());
    }
}
