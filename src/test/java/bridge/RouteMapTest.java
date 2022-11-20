package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteMapTest {

    private static final List<String> upSide = List.of("O", " ", "X");
    private static final List<String> downSide = List.of(" ", "O", " ");

    @DisplayName("RouteMap 객체를 알맞는 형식의 문자열로 반환한다")
    @Test
    void formatTest() {
        RouteMap routeMap = new RouteMap(upSide, downSide);
        assertThat(routeMap.format())
                .isEqualTo(List.of(
                        "[ O |   | X ]",
                        "[   | O |   ]"
                ));
    }

    @DisplayName("같은 경로를 가진 두 객체는 동일하다")
    @Test
    void equalsTest() {
        RouteMap routeMap1 = new RouteMap(upSide, downSide);
        RouteMap routeMap2 = new RouteMap(upSide, downSide);

        assertThat(routeMap1).isEqualTo(routeMap2);
    }

    @DisplayName("다른 경로를 가진 두 객체는 동일하지 않다")
    @Test
    void notEqualsTest() {
        RouteMap routeMap1 = new RouteMap(upSide, downSide);
        RouteMap routeMap2 = new RouteMap(downSide, upSide);

        assertThat(routeMap1).isNotEqualTo(routeMap2);
    }
}
