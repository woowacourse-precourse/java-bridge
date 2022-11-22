package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

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
    @DisplayName("종료를 눌렀을 때 출력되는 값 확인.")
    void retry() {
        String input = "Q";
        int index = 1;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String result  = bridgeGame.retry(input, index);

        assertThat(result).isEqualTo("Q");
    }
}