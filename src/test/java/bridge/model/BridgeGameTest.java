package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    private BridgeGame bridgeGame;


    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.createBridge(List.of("U", "D", "U"));
    }

    @AfterEach
    void afterEach() {
        bridgeGame = null;
    }

    @DisplayName("이동 결과 기록을 반환한다.")
    @Test
    void getRecordByMoveTest() {
        List<List<String>> bridgeRecord = bridgeGame.getRecordByMove("U");
        List<String> upBridge = bridgeRecord.get(0);
        List<String> downBridge = bridgeRecord.get(1);

        Assertions.assertThat(upBridge).isEqualTo(List.of("O"));
        Assertions.assertThat(downBridge).isEqualTo(List.of(" "));
    }

    @DisplayName("이동 성공 여부를 판단한다.")
    @Test
    void isFailTest() {
        bridgeGame.getRecordByMove("U");

        Boolean isFail = bridgeGame.isFail();
        Boolean isPass = bridgeGame.isPass();

        Assertions.assertThat(isFail).isFalse();
        Assertions.assertThat(isPass).isTrue();
    }

    @DisplayName("남은 라운드가 있는 지 판단한다.")
    @Test
    void isRoundLeftTest() {
        bridgeGame.getRecordByMove("U");
        bridgeGame.getRecordByMove("D");
        bridgeGame.getRecordByMove("U");

        Boolean isRoundLeft = bridgeGame.isRoundLeft();

        Assertions.assertThat(isRoundLeft).isFalse();
    }
}