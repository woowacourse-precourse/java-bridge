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
}
