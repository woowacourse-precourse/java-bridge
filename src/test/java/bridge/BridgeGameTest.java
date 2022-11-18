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
        List<String> bridge = List.of("U", "D");
        List<String> moveMapList = List.of("O","X");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bridgeGame.retry(input, bridge, moveMapList, 0);

        assertThat("최종 게임 결과\n" +
                "[ O | X ]\n" +
                "[   |   ]\n" +
                "게임 성공 여부: 성공\n" +
                "총 시도한 횟수: 1\n").isEqualTo(out.toString());
    }
}