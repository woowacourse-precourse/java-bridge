package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private List<String> bridge;

    @BeforeEach
    void initiateBridgeGameTest() {
        bridgeGame = new BridgeGame();
        String bridgeSize = "3";
        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);
        bridgeGame.requestBridge();
        bridge = bridgeGame.getBridge();
    }

    @DisplayName("윗칸 이동을 입력했을때의 이동 메소드 테스트")
    @Test
    void move() {
        String moveCommand = "U";
        InputStream in = new ByteArrayInputStream(moveCommand.getBytes());
        System.setIn(in);
        bridgeGame.move();
        if (!bridge.get(bridgeGame.getCurrentPosition()).equals(moveCommand)) {
            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
        }
        if (bridge.get(bridgeGame.getCurrentPosition()).equals(moveCommand)) {
            assertThat(bridgeGame.isSuccess()).isEqualTo(true);
        }
    }

    @DisplayName("재시작을 명령을 입력했을떄의 재시작 메소드 테스트")
    @Test
    void retry() {
        String input = "R";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int totalTryCount = bridgeGame.getTotalTryCount();
        assertThat(bridgeGame.retry()).isEqualTo(true);
        assertThat(bridgeGame.getCurrentPosition()).isEqualTo(-1);
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
        assertThat(bridgeGame.getTotalTryCount()).isEqualTo(totalTryCount + 1);
    }
}