package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final List<String> bridge = List.of("D", "U", "U");

    /** 0 -> down 성공, 1 -> down 실패, 2 -> up 성공, 3 -> up 실패 **/
    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다: 1. down 성공")
    @Test
    void moveSuccess_down() {
        assertEquals(0, BridgeGame.move(bridge, 0, "D"));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다: 2. up 성공")
    @Test
    void moveSuccess_up() {
        assertEquals(2, BridgeGame.move(bridge, 2, "U"));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다: 3. down 실패")
    @Test
    void moveFailure_down() {
        assertEquals(1, BridgeGame.move(bridge, 2, "D"));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다: 4. up 실패")
    @Test
    void moveFailure_up() {
        assertEquals(3, BridgeGame.move(bridge, 0, "U"));
    }

    @DisplayName("")
    @Test
    void retry() {
    }
}