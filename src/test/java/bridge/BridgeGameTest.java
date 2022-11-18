package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : bridge
 * fileName : BridgeGameTest
 * author : gim-yeong-geun
 * date : 2022/11/18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/18         gim-yeong-geun          최초 생성
 */
class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();
    @Test
    @DisplayName("칸을 이동 했을 때 같으면 \"O\" 을 반환함.")
    void move() {
        String randomBridge = "R";
        String input = "R";
        String result = bridgeGame.move(randomBridge, input);

        assertThat(result).contains("O");
    }

    @Test
    void retry() {
    }
}