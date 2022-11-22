package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeTest {

    @DisplayName("다음 이동할 칸이 이동할 수 있는 칸인지 확인한다.")
    @ParameterizedTest(name = "{0} 블럭으로 이동할때 {1} 방향으로 가면 이동가능하다.")
    @CsvSource({"0,U", "1,D", "2,U"})
    void checkMoveSuccessTest(int nextPosition, String moveDirection) {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        assertThat(bridge.determineMoveResult(nextPosition, moveDirection)).isTrue();
    }

    @DisplayName("다음 이동할 칸이 이동할 수 있는 칸이 아닌지 확인한다.")
    @ParameterizedTest(name = "{0} 블럭으로 이동할때 {1} 방향으로 가면 이동할 수 없다.")
    @CsvSource({"0,D", "1,U", "2,D"})
    void checkMoveFailTest(int nextPosition, String moveDirection) {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        assertThat(bridge.determineMoveResult(nextPosition, moveDirection)).isFalse();
    }
}
