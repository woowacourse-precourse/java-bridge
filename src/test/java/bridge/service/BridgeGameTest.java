package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.domain.result.BridgeResult;

class BridgeGameTest {

    @DisplayName("retry메소드에 R을 입력하면 true를 반환한다.")
    @Test
    void returnsTrueFromRetry() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new BridgeResult());
        String gameCommandToRetry = "R";
        //when
        boolean retry = bridgeGame.retry(gameCommandToRetry);
        //then
        assertThat(retry).isEqualTo(true);
    }

    @DisplayName("retry메소드에 Q을 입력하면 false를 반환한다.")
    @Test
    void returnsFalseFromRetry() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new BridgeResult());
        String gameCommandToRetry = "Q";
        //when
        boolean retry = bridgeGame.retry(gameCommandToRetry);
        //then
        assertThat(retry).isEqualTo(false);
    }

    @DisplayName("현재까지 건넌 다리가 초기화 되는지 확인한다.")
    @Test
    void checkInitializingBridgeResult() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        resultBridge.addBlock("U", "O");

        BridgeGame bridgeGame = new BridgeGame(resultBridge);
        //when
        bridgeGame.initialize();
        //then
        assertThat(resultBridge.countCorrectCrossing()).isEqualTo(0);
    }

    @DisplayName("다리를 완전히 건넜다면 true를 반환한다.")
    @Test
    void completeCrossingBridgeReturnsTrue() {
        //given
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.addBlock("U", "O");
        bridgeResult.addBlock("U", "O");
        bridgeResult.addBlock("D", "O");

        BridgeGame bridgeGame = new BridgeGame(bridgeResult);

        int bridgeSize = 3;
        //when
        boolean completion = bridgeGame.completeCrossing(bridgeSize);
        //then
        assertThat(completion).isEqualTo(true);
    }

    @DisplayName("다리를 완전히 건너지 못했다면 false를 반환한다.")
    @Test
    void incompleteCrossingBridgeReturnsFalse() {
        //given
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.addBlock("U", "O");
        bridgeResult.addBlock("U", "O");
        bridgeResult.addBlock("D", "x");

        BridgeGame bridgeGame = new BridgeGame(bridgeResult);

        int bridgeSize = 3;
        //when
        boolean completion = bridgeGame.completeCrossing(bridgeSize);
        //then
        assertThat(completion).isEqualTo(false);
    }

    @DisplayName("move메소드에서 올바르게 이동했다면 BridgeResult에 O가 1번 포함되어있다.")
    @Test
    void containCorrectMarkWhenMoveCorrectly() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        BridgeGame bridgeGame = new BridgeGame(resultBridge);
        //when
        bridgeGame.move("U", "U");
        //then
        assertThat(resultBridge.countCorrectCrossing()).isEqualTo(1);
    }

    @DisplayName("move메소드에서 이동하지 못했다면 BridgeResult에 O가 포함되어 있지않다.")
    @Test
    void containWrongMarkWhenMoveIncorrectly() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        BridgeGame bridgeGame = new BridgeGame(resultBridge);
        //when
        bridgeGame.move("U", "D");
        //then
        assertThat(resultBridge.countCorrectCrossing()).isEqualTo(0);
    }
}