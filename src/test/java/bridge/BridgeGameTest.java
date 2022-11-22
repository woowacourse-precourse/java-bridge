package bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class BridgeGameTest {
    List<String> movableTest = List.of("U","U","U");
    BridgeGame game = new BridgeGame(movableTest);
    @DisplayName("이동할 칸과 사용자 값이 일치하는 지 확인")
    @Test
    void bridgeGameMoving() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThat(game.move("D",0)).isFalse();
    }
    @DisplayName("게임을 계속할건지 확인")
    @Test
    void bridgeGameRetry() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThat(game.retry("Q")).isFalse();
    }

}
