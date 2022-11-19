package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    Bridge bridge;

    @DisplayName("이동이 가능여부 판단 기능 테스트")
    @Test
    void checkingMovableTest() {
        List<String> inputs = List.of("U", "D", "U");
        for (int i = 0; i < 3; i++) {
            boolean movableBlock = bridge.isMovableBlock(i, inputs.get(i));
            Assertions.assertThat(movableBlock).isTrue();
        }
    }

    @DisplayName("다리의 각 블록 중 유효하지 않은 값이 저장되면 오류가 발생함")
    @Test
    void insertInvalidBlocks() {
        List<String> movableBlocks = List.of("U", "F", "A");
        Assertions.assertThatThrownBy(() -> new Bridge(movableBlocks))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 문자가 포함되어 있습니다.");
    }
}
