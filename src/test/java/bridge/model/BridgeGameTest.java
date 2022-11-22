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

        Assertions.assertThat(isFail).isFalse();
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

    @DisplayName("재시작 시, 시도 횟수/라운드 넘버/이동 기록이 업데이트된다.")
    @Test
    void retryTest() {
        bridgeGame.getRecordByMove("U");
        bridgeGame.getRecordByMove("D");
        bridgeGame.retry();

        Record record = bridgeGame.getRecord();
        List<List<String>> bridgeRecord = record.getBridgeRecord();
        Result result = bridgeGame.getResult();

        Assertions.assertThat(bridgeRecord.get(0)).isEmpty();
        Assertions.assertThat(bridgeRecord.get(1)).isEmpty();
        Assertions.assertThat(result.getTryCount()).isEqualTo(2);
    }
}