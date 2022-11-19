package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @DisplayName("해당 순서의 칸이 동일하면 true를 반환한다")
    @Test
    void judgePossibleToMove() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        boolean possibleToMove = bridge.isPossibleToMove("D", 1);

        assertThat(possibleToMove).isEqualTo(true);
    }

    @DisplayName("해당 순서의 칸이 동일하지 않으면 false를 반환한다")
    @Test
    void judgeImpossibleToMove() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        boolean possibleToMove = bridge.isPossibleToMove("U", 1);

        assertThat(possibleToMove).isEqualTo(false);
    }

    @DisplayName("순서가 마지막이면 true를 반환한다")
    @Test
    void isEndPoint() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        boolean endPoint = bridge.isEndPoint(3);

        assertThat(endPoint).isEqualTo(true);
    }

    @DisplayName("순서가 마지막이 아니면 false를 반환한다")
    @Test
    void isNotEndPoint() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        boolean endPoint = bridge.isEndPoint(2);

        assertThat(endPoint).isEqualTo(false);
    }
}
