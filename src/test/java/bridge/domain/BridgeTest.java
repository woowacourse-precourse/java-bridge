package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("생성자 테스트")
    @Test
    public void BridgeConstructorAndGetterTest() {
        // given
        List<String> list = List.of("U", "D", "D");

        // when
        Bridge bridge = new Bridge(list);

        // then
        assertThat(bridge.isEndOfIndex()).isEqualTo(false);
        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("resetGame 테스트")
    @Test
    public void resetGameTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();

        // when
        bridge.resetGame();

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("nowIndexUpdate 테스트")
    @Test
    public void nowIndexUpdateTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        // when
        bridge.nowIndexUpdate();

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("isEndOfIndex 테스트")
    @Test
    public void isEndOfIndexTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();

        // when
        boolean isEndOfIndex = bridge.isEndOfIndex();

        // then
        assertThat(isEndOfIndex).isEqualTo(true);
    }

    @DisplayName("isCorrectMoveDirection 테스트")
    @Test
    public void isCorrectMoveDirectionTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        String moveDirection = "U";

        // when
        boolean result = bridge.isCorrectMoveDirection(moveDirection);

        // then
        assertThat(result).isEqualTo(true);
    }
}
