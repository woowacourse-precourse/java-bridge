package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    @DisplayName("다리 건너기에 성공할 경우 종료한다.")
    @Test
    void RepeatTest1() {
        String[] input = {"u", "d", "d"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.Repeat()).isEqualTo(true);
    }

    @DisplayName("다리 건너기에 실패할 경우 재시작 한다.")
    @Test
    void RepeatTest2() {
        String[] input = {"u", "u", "r", "u", "d", "d"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.Repeat()).isEqualTo(true);
    }

    @DisplayName("시도 횟수를 통해 Play 메소드 테스트")
    @Test
    void PlayTest1() {
        String[] input = {"u", "d", "d"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.Play();

        assertThat(bridgeGame.GetTryCount()).isEqualTo(1);
    }

    @DisplayName("사용자가 잘못된 값을 입력할 경우 그 부분부터 입력을 다시 받는다.")
    @Test
    void ProceedTest1() {
        String[] input = {"abc", "dd", "5", "u"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.Proceed()).isEqualTo(true);
    }

    @DisplayName("게임 진행 중 정답이 아닌 경우를 테스트")
    @Test
    void ProceedTest2() {
        String[] input = {"d"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.Proceed()).isEqualTo(false);
    }

    @DisplayName("AnalyzeBridgeInput 메소드 테스트")
    @Test
    void AnalyzeBridgeInputTest1() {
        String input = "d";

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.AnalyzeBridgeInput(input)).isEqualTo(false);
    }

    @DisplayName("move 메소드 moveCount 테스트")
    @Test
    void moveTest1() {
        String input = "d";

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move(input);

        assertThat(bridgeGame.GetMoveCount()).isEqualTo(1);
    }

    @DisplayName("move 메소드 playerList 테스트")
    @Test
    void moveTest2() {
        String input = "U";

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move(input);

        assertThat(bridgeGame.GetPlayerList()).isEqualTo(List.of("U"));
    }

    @DisplayName("게임을 재시작하는 메소드 테스트")
    @Test
    void retryTest1() {
        String input = "r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.retry()).isEqualTo(true);
    }

    @DisplayName("사용자가 잘못된 값을 입력할 경우 그 부분부터 입력을 다시 받는다.")
    @Test
    void retryTest2() {
        String[] input = {"abc", "dd", "r"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.SetMoveCount(2);

        assertThat(bridgeGame.retry()).isEqualTo(true);
    }
}