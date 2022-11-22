package bridge.domain;

import bridge.constant.Direction;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest {

    @Test
    @DisplayName("주어진 방향으로 진행이 안되는 경우 false를 반환한다.")
    public void canMoveImpossibleThenFalse() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        Direction nextDirection = Direction.from("D");
        int location = 0;

        //when
        boolean result = bridge.canMove(nextDirection, location);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("주어진 방향으로 진행이 가능한 경우 true를 반환한다.")
    public void canMovePossibleThenTrue() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        Direction nextDirection = Direction.from("D");
        int location = 1;

        //when
        boolean result = bridge.canMove(nextDirection, location);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("다리의 끝에 도달하였으면 true를 반환한다.")
    public void isEndOfBridge_then_true() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        int location = 3;

        //when
        boolean result = bridge.isEnd(location);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("다리의 끝에 도달하지 않았다면 false를 반환한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void isNotEndOfBridge_then_false(int location) throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U", "D", "U"));

        //when
        boolean result = bridge.isEnd(location);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }
}
