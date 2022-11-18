package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest{

    @DisplayName("정답 칸을 선택 했을 때 true를 반환")
    @Test
    void moveCorrectSpace () {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);

        assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @DisplayName("다리의 마지막까지 도달 했을 때 false를 반환")
    @Test
    void reachLastSpace () {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }

    @DisplayName("잘못된 칸으로 이동 후 Q를 입력하여 프로그램을 종료하면 false를 반환")
    @Test
    void quitAfterSelectedIncorrectSpace () {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        String command = "Q";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);

        assertThat(bridgeGame.move("D")).isEqualTo(false);
    }

    @DisplayName("잘못된 칸으로 이동 후 R을 입력하면 프로그램 재시작")
    @Test
    void retryAfterSelectedIncorrectSpace() {
        List<String> randomBridge = List.of("U", "D", "U", "U");
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        String command = "R";
        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);

        assertThat(bridgeGame.move("D")).isEqualTo(true);
    }
}
