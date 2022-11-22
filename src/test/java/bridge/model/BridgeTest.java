package bridge.model;

import bridge.utils.Mark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private final List<String> route = List.of("U", "U", "D");
    private final Bridge bridge = new Bridge(route);

    @DisplayName("이동할 수 있는 칸을 선택하면 O 표시가 반환된다.")
    @Test
    void matchRoute() {
        //given
        String inputDirection = "U";
        int movingCount = 1;

        //when
        Mark result = bridge.matchRoute(inputDirection, movingCount);

        //then
        assertThat(result.getMark()).isEqualTo("O");
    }

    @DisplayName("이동할 수 없는 칸을 선택하면 X 표시가 반환된다.")
    @Test
    void noMatchRoute() {
        //given
        String inputDirection = "U";
        int movingCount = 2;

        //when
        Mark result = bridge.matchRoute(inputDirection, movingCount);

        //then
        assertThat(result.getMark()).isEqualTo("X");
    }
}
