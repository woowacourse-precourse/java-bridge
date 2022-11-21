package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U", "U", "U"));

    @DisplayName("이동 성공")
    @Test
    void move1() {
        boolean isMove = bridgeGame.move(0, "U");

        assertThat(isMove).isTrue();
    }

    @DisplayName("이동 실패")
    @Test
    void move2() {
        boolean isMove = bridgeGame.move(0, "D");

        assertThat(isMove).isFalse();
    }

    @DisplayName("재시도")
    @Test
    void retry() {
        assertThat(bridgeGame.retry("R")).isTrue();
        assertThat(bridgeGame.retry("Q")).isFalse();
    }

    @DisplayName("종료")
    @Test
    void end() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        bridgeGame.end();
        assertThat(output.toString()).contains("최종 게임 결과",
                "게임 성공 여부",
                "총 시도한 횟수"
        );
    }
}