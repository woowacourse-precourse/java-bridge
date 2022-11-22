package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    @Test
    void 다리이동() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        String move = bridgeGame.move(0);
        assertThat(move).isEqualTo("D");
    }

    @Test
    void 다시시작_한다_선택() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        assertThat(bridgeGame.retry("R")).isTrue();
    }

    @Test
    void 다시시작_안한다_선택() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        assertThat(bridgeGame.retry("Q")).isFalse();
    }

    @Test
    void 다시시작_잘못된_입력() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        assertThatThrownBy(()->bridgeGame.retry("D")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 브릿지값_받아오기() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        assertThat(bridgeGame.getBridge()).isEqualTo(new ArrayList<>(Arrays.asList("D","U","U")));
    }

    @Test
    void 마지막다리() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        assertThat(bridgeGame.getLastItem()).isEqualTo("D");
    }

    @Test
    void 브릿지_추가() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>());
        ArrayList<String> bridges = new ArrayList<>(Arrays.asList("D", "U", "U"));
        bridgeGame.addBridge(bridges);
        assertThat(bridgeGame.getBridge()).isEqualTo(bridges);
    }

    @Test
    void getCount() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","U","U")));
        bridgeGame.retry("R");
        bridgeGame.retry("R");
        bridgeGame.retry("R");
        assertThat(bridgeGame.getCount()).isEqualTo(4);
    }
}