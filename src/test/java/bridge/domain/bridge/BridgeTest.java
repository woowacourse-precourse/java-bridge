package bridge.domain.bridge;

import bridge.domain.move.MoveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void init() {
        List<String> bridgeList = List.of("U", "U", "D", "U");
        bridge = Bridge.valueOf(bridgeList);
    }

    @DisplayName("다리를 건널 수 있다면 true 를 반환한다.")
    @Test
    void moveSuccess() {
        Square square = new Square(MoveType.UP);
        int position = 0;

        boolean move = bridge.canMoveForward(square, position);
        assertThat(move).isTrue();
    }

    @DisplayName("다리를 건널 수 없다면 false 를 반환한다.")
    @Test
    void moveFail() {
        Square square = new Square(MoveType.DOWN);
        int position = 0;

        boolean move = bridge.canMoveForward(square, position);
        assertThat(move).isFalse();
    }
}