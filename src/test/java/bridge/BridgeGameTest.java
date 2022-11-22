package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 1));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(5);

    public void bridgeMove(BridgeGame bridgeGame) {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
    }

    @Test
    @DisplayName("재시작 종료 검증")
    void retryTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeMove(bridgeGame);

        assertThat(bridgeGame.retry("R")).isTrue();
        assertThat(bridgeGame.retry("Q")).isFalse();
        assertThatThrownBy(() -> bridgeGame.retry("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 입력 기록 테스트")
    void historyTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeMove(bridgeGame);

        List<String> history = List.of("U", "D", "UF", "DF", "DF");

        assertThat(bridgeGame.inputHistory()).isEqualTo(history);
    }

    @Test
    @DisplayName("입력 값에 따른 반환 값 테스트")
    void returnResultValue() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeMove(bridgeGame);

        assertThat(bridgeGame.returnResultValue(0)).isEqualTo("U");
        assertThat(bridgeGame.returnResultValue(1)).isEqualTo("D");
        assertThat(bridgeGame.returnResultValue(2)).isEqualTo("UF");
        assertThat(bridgeGame.returnResultValue(3)).isEqualTo("DF");
        assertThat(bridgeGame.returnResultValue(4)).isEqualTo("DF");
    }

    @Test
    @DisplayName("이동 종료 여부")
    void isMoveFinishTest_success() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        assertThat(bridgeGame.isMoveFinish()).isFalse();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.isMoveFinish()).isFalse();
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.isMoveFinish()).isTrue();
    }

    @Test
    @DisplayName("이동 종료 여부")
    void isMoveFinishTest_fail() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        assertThat(bridgeGame.isMoveFinish()).isFalse();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.isMoveFinish()).isTrue();

    }

}