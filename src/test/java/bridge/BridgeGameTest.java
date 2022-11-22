package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @Test
    void 이동가능확인1(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = List.of("U", "D", "D", "D", "U");
            BridgeGame bridgeGame = new BridgeGame(availableList);
            assertThat(true).isEqualTo(bridgeGame.checkMovable("U"));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("U 또는 D를 입력해주세요.");
        }
    }
    @Test
    void 이동가능확인2(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = List.of("U", "D", "D", "D", "U");
            BridgeGame bridgeGame = new BridgeGame(availableList);
            assertThat(true).isEqualTo(bridgeGame.checkMovable("W"));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("U 또는 D를 입력해주세요.");
        }
    }
    @Test
    void 이동확인1(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = List.of("U", "D", "U", "D", "D");
            BridgeGame bridgeGame = new BridgeGame(availableList);
            assertThat(true).isEqualTo(bridgeGame.checkMovable("U"));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("U 또는 D를 입력해주세요.");
        }
    }
    @Test
    void 이동확인2(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = List.of("U", "D", "U", "D", "D");
            BridgeGame bridgeGame = new BridgeGame(availableList);
            bridgeGame.move();
            assertThat(false).isEqualTo(bridgeGame.checkMovable("U"));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("U 또는 D를 입력해주세요.");
        }
    }
    @Test
    void 게임성공_확인(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> availableList = List.of("U", "D", "U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(availableList);
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();
        assertThat(true).isEqualTo(bridgeGame.checkEnd());
    }
}