package bridge.model;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("틀린 답을 줬을 때 게임에 잘 실패하는지 테스트")
    @Test
    void gameFailTest(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge(3);
        String testInput = "U";
        if(bridgeGame.getBridge().getBlocks().get(0) == "U") testInput = "D";
        bridgeGame.checkAnswerOfRound(testInput);
        assertTrue(bridgeGame.isGameFail());
    }

    @DisplayName("모두 정답을 줬을 때 게임에 잘 성공하는지 테스트")
    @Test
    void gameSuccessTest(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge(3);
        for(int i = 0; i < 3; i++){
            String testInput = "U";
            if(bridgeGame.getBridge().getBlocks().get(i) == "D") testInput = "D";
            bridgeGame.checkAnswerOfRound(testInput);
            assertFalse(bridgeGame.isGameFail());
            bridgeGame.move();
        }
        bridgeGame.checkGameSuccess();
        assertTrue(bridgeGame.isGameSuccess());
    }

}