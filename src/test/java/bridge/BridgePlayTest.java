package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgePlayTest {

    BridgePlay bridgePlay;
    @BeforeEach
    void initiateBridgePlayTest() {
        bridgePlay = new BridgePlay();
    }

//    @Test
//    void requestReadMoving() {
//    }

    @DisplayName("이동 명령으로 1을 입력했을때 예외를 던진다.")
    @Test
    void isValidMove() {
        assertThatThrownBy(() -> bridgePlay.isValidMove("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    void requestReadRetry() {
//    }
    @DisplayName("재시작 명령으로 1을 입력했을때 예외를 던진다.")
    @Test
    void isValidRetry() {
        assertThatThrownBy(() -> bridgePlay.isValidRetry("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}