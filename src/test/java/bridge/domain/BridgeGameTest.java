package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void init() {
        bridgeGame.initMap();
    }

    @Test
    void 오답시_wrongAnswer_의_값을_true로_변환한다() {
        bridgeGame.move("U", "D");
        boolean wrongAnswer = bridgeGame.isWrongAnswer();

        Assertions.assertThat(wrongAnswer).isTrue();
    }

    @Test
    void 오답시_재시작_여부가_R이라면_true를_반환하고_totalTry를_증가시킨다(){
        boolean result = bridgeGame.retry("R");
        int totalTry = bridgeGame.countTotalTry();

        Assertions.assertThat(totalTry).isEqualTo(2);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 오답시_재시작_여부가_Q라면_false를_반환한다(){
        boolean result = bridgeGame.retry("Q");

        Assertions.assertThat(result).isFalse();
    }

}