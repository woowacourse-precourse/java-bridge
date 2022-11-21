package bridge.domain.object;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("다리 기능 테스트")
class BridgeTest {
    @DisplayName("모든 경로가 일치하면 true 를 반환한다.")
    @Test
    void checkCorrectRouteTrue() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        boolean correctRoute = bridge.checkCorrectRoute(List.of("U", "D", "D"));

        assertThat(correctRoute).isTrue();
    }

    @DisplayName("모든 경로가 일치하지 않으면 false 를 반환한다.")
    @Test
    void checkCorrectRouteFalse() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        boolean correctRoute = bridge.checkCorrectRoute(List.of("U", "D", "U"));

        assertThat(correctRoute).isFalse();
    }

    @DisplayName("다리보다 입력받은 경로길이가 더 길면 예외가 발생한다.")
    @Test
    void checkCorrectRouteExcept() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        assertThatThrownBy(
                () ->bridge.checkCorrectRoute(List.of("U", "D", "U", "D"))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("현재까지의 경로가 다리와 다르면 true를 반환한다.")
    @Test
    void checkDifferentRoute() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        boolean differentRoute = bridge.checkDifferentRoute(List.of("U", "U"));

        assertThat(differentRoute).isTrue();
    }

    @DisplayName("현재까지의 경로가 다리와 같으면 false 를 반환한다.")
    @Test
    void checkDifferentRouteFalse() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        boolean differentRoute = bridge.checkDifferentRoute(List.of("U", "D"));

        assertThat(differentRoute).isFalse();
    }

    @DisplayName("다리보다 입력받은 경로길이가 더 길면 예외가 발생한다.")
    @Test
    void checkDifferentRouteExcept() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        assertThatThrownBy(
                () ->bridge.checkDifferentRoute(List.of("U", "D", "U", "D"))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}