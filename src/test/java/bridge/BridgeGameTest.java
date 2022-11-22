package bridge;

import domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeGameTest {
    @DisplayName("시도횟수1, 성공 테스트")
    @Test
    void oneTrySuccess() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        bridgeGame.initUserMove();
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isTrue();
        assertThat(bridgeGame.getTryTimes()).isEqualTo(1);
    }

    @DisplayName("시도횟수1, 실패 테스트")
    @Test
    void oneTryFail() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        bridgeGame.initUserMove();
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isFalse();
        assertThat(bridgeGame.retry("Q")).isFalse();
        assertThat(bridgeGame.getTryTimes()).isEqualTo(1);
    }

    @DisplayName("브릿지를 다 안건넜을때 테스트")
    @Test
    void moreAskTest_fail() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        bridgeGame.initUserMove();
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.moreAsk()).isFalse();
    }

    @DisplayName("브릿지를 다 건넜을때 테스트")
    @Test
    void moreAskTest_success() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        bridgeGame.initUserMove();
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.moreAsk()).isTrue();
    }

    @DisplayName("이동 입력 값 예외 확인")
    @Test
    void moveException() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        String input = "d";
        assertThatThrownBy(() -> bridgeGame.move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다시 시도 했을때 입력 값 예외 확인")
    @Test
    void retryException() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        String input = "r";
        assertThatThrownBy(() -> bridgeGame.retry(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
