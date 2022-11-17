package bridge.dto;

import bridge.domain.Bridge;
import bridge.domain.Visited;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BridgeGameResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeGameResultDtoTest {
    private static final Bridge bridge = new Bridge(List.of("U", "D", "U"));
    private static final Visited visited = new Visited();

    @Test
    void 잘_생성할_수_있다() {
        assertDoesNotThrow(() -> new BridgeGameResultDto(1, bridge, visited));
    }

    @Test
    void 너무_작은_숫자가_들어오면_예외() {
        try {
            assertThrows(IllegalArgumentException.class,
                    () -> new BridgeGameResultDto(0, bridge, visited));
            new BridgeGameResultDto(0, bridge, visited);
        } catch (IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("시도 횟수는 1이상이어야 합니다");
        }
    }

    @Test
    void bridge_에_null_이_포함되면_예외() {
        try {
            assertThrows(IllegalArgumentException.class,
                    () -> new BridgeGameResultDto(1, null, visited));
            new BridgeGameResultDto(1, null, visited);
        } catch (IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("bridge 에는 null 이 들어올 수 없습니다");
        }
    }

    @Test
    void visited_에_null_이_포함되면_예외() {
        try {
            assertThrows(IllegalArgumentException.class,
                    () -> new BridgeGameResultDto(1, bridge, null));
            new BridgeGameResultDto(1, bridge, null);
        } catch (IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("visited 에는 null 이 들어올 수 없습니다");
        }
    }
}
