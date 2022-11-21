package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    @DisplayName("생성할 다리 길이가 3 이상 20 이하의 수가 아니면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 2, 21, 155})
    @ParameterizedTest
    void createBridgeWithInvalidSizeTest(int input){
        BridgeGame bridgeGame = new BridgeGame();
        assertThatThrownBy(()->{bridgeGame.createBridge(input);}).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 라운드에서 선택한 값이 U또는 D가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"R", "K", "u", "d"})
    @ParameterizedTest
    void userSelectionWithInvalidOptionTest(String input){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge(4);
        assertThatThrownBy(()->{bridgeGame.checkAnswerOfRound(input);}).isInstanceOf(IllegalArgumentException.class);
    }

}