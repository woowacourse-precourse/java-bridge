package bridge;

import bridge.domain.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {

    @Test
    @DisplayName("다리 건널 때마다 'O' 또는 'X' 결과 확인")
    void 다리_건너기_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "D");
        List<String> moveResult = bridgeGame.move(List.of("U", "D", "D"), "U");

        assertThat(moveResult).isEqualTo(List.of("O", " ", " ", "O", "X", " "));
    }

    @Test
    @DisplayName("게임 재시도 할시 이동 결과 초기화")
    void 다리_게임_재시도_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "D");
        List<String> moveResult = bridgeGame.retry("R");

        assertThat(moveResult).isEqualTo(List.of());
    }

    @Test
    @DisplayName("게임 건널 때마다 성공 여부 확인")
    void 다리_게임_움직일때마다_성공_여부_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "U");
        boolean failGame = bridgeGame.isFailGame();

        assertThat(failGame).isTrue();
    }

    @Test
    @DisplayName("다리 게임 최종 결과 성공")
    void 다리_게임_최종_결과_성공_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "D");
        bridgeGame.move(bridge, "D");
        boolean failGame = bridgeGame.isFailFinalGame(bridge);

        assertThat(failGame).isFalse();
    }

    @Test
    @DisplayName("다리 게임 최종 결과 실패")
    void 다리_게임_최종_결과_실패_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "U");
        boolean failGame = bridgeGame.isFailFinalGame(bridge);

        assertThat(failGame).isTrue();
    }

    @Test
    @DisplayName("게임 재시도 횟수 확인")
    void 다리_게임_재시도_횟수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.retry("R");
        bridgeGame.retry("R");
        int retryCount = bridgeGame.checkRetryCount();

        assertThat(retryCount).isEqualTo(3);
    }

}
