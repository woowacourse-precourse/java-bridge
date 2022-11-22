package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @Test
    @DisplayName("사용자가 게임 종료를 선택하는 경우 테스트")
    void quitChoiceTestCase() {
        String playerCommand = "Q";
        int result = 1;
       assertThat(BridgeGame.retry(playerCommand)).isEqualTo(result);
    }

    @Test
    @DisplayName("사용자가 게임 재진행을 선택하는 경우 테스트")
    void restartChoiceTestCase() {
        String playerCommand = "R";
        int result = 0;
        assertThat(BridgeGame.retry(playerCommand)).isEqualTo(result);
    }

}