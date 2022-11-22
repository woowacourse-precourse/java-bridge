package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BridgeTest {

    @DisplayName("compareWithPosition 메서드에 해당 위치와 일치하는 문자를 인자로 주었을 때 true를 반환하는지 검증한다.")
    @Test
    void compareWithPositionAndRightString() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        boolean firstPosition = bridge.compareWithPosition(0, "U");
        boolean secondPosition = bridge.compareWithPosition(1, "D");
        boolean thirdPosition = bridge.compareWithPosition(2, "D");

        assertThat(firstPosition).isTrue();
        assertThat(secondPosition).isTrue();
        assertThat(thirdPosition).isTrue();
    }

    @DisplayName("compareWithPosition 메서드에 해당 위치와 일치하지 않는 문자를 인자로 주었을 때 false를 반환하는지 검증한다.")
    @Test
    void compareWithPositionAndWrongString() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        boolean firstPosition = bridge.compareWithPosition(0, "D");
        boolean secondPosition = bridge.compareWithPosition(1, "U");
        boolean thirdPosition = bridge.compareWithPosition(2, "U");

        assertThat(firstPosition).isFalse();
        assertThat(secondPosition).isFalse();
        assertThat(thirdPosition).isFalse();
    }

    @DisplayName("size 메서드가 다리의 길이를 반환하는지 검증한다.")
    @Test
    void size() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        int size = bridge.size();

        assertThat(size).isEqualTo(3);
    }
}