package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

//    @Test
//    void requestBridge() {
//
//    }
    @DisplayName("윗칸 이동 명령을 내렸을때, 윗칸이 이동가능하면 success은 true가 "
            + "아랫칸이 이동 가능하면 false가 된다.")
    @Test
    void move() {
        String moveCommand = "U";
        InputStream in = new ByteArrayInputStream(moveCommand.getBytes());
        System.setIn(in);
        bridgeGame.move();
        if(!bridge.get(bridgeGame.getCurrentPosition()).equals(moveCommand)) {
            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
        }
        if(bridge.get(bridgeGame.getCurrentPosition()).equals(moveCommand)) {
            assertThat(bridgeGame.isSuccess()).isEqualTo(true);
        }
    }

    @DisplayName("재시작을 실행했을때, true를 반환하고, currentPosition은 -1이 되고,"
            + "success은 true, totalTryCount은 1이 증가한다.")
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