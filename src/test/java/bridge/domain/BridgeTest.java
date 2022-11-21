package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {
    
    static Bridge bridge;

    @BeforeAll
    static void init() {
        bridge = new Bridge(List.of("U", "D", "D"));
    }


    @DisplayName("해당 위치로 움직일 수 있는지 확인한다.")
    @Test
    void canMove() {
        assertThat(bridge.canMove(BridgeCell.UP, 0)).isTrue();
        assertThat(bridge.canMove(BridgeCell.DOWN, 0)).isFalse();
    }

    @DisplayName("잘못된 위치로 이동 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 50})
    void invalidMove(int position) {
        assertThatThrownBy(() -> bridge.canMove(BridgeCell.UP, position))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

}
