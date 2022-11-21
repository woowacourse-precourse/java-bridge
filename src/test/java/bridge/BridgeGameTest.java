package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void initiateBridgeGameTest() {
        bridgeGame = new BridgeGame();
//        String input = "3";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        bridgeGame.requestBridge();
    }

//    @Test
//    void requestBridge() {
//
//    }

//    @Test // getBridge 해가지고. 같으면 어쩌구 다르면 어쩌구 하면 되지 않을까.
//    void move() {
//    }
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