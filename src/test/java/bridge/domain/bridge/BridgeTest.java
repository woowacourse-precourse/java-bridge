package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @DisplayName("다리의 길이에 문자가 포함되어있는 경우 예외가 발생한다.")
    @ValueSource(strings = {"monkey17", "wooteco", "3bridge"})
    @ParameterizedTest
    void containStringInInputOfBridgeSize(String input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 20을 초과할 때 예외가 발생한다.")
    @ValueSource(strings = {"21", "156", "2000"})
    @ParameterizedTest
    void isOverTwentyOfBridgeSize(String input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3미만일 때 예외가 발생한다.")
    @ValueSource(strings = {"-45, 0, 2"})
    @ParameterizedTest
    void isUnderThreeOfBridgeSize(String input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 인덱스가 주어질 때 해당 다리의 칸인 U, D중 하나를 반환한다.")
    @Test
    void inputToGetPositionOfBlock() {
        //given
        Bridge bridge = new Bridge("3");
        //when
        String block = bridge.getBlock(2);
        //then
        assertThat(block).isIn(List.of("U", "D"));
    }
}