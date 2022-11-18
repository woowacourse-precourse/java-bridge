package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    @DisplayName("주어진 방향으로 진행이 안되는 경우")
    public void canMoveImpossible() throws Exception{
        //given
        Bridge bridge = Bridge.from(List.of("U", "D", "U"));
        String nextDirection = "D";
        int location =0;

        //when
        boolean result = bridge.canMove(nextDirection, location);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("주어진 방향으로 진행이 가능한 경우")
    public void canMovePossible() throws Exception{
        //given
        Bridge bridge = Bridge.from(List.of("U", "D", "U"));
        String nextDirection = "D";
        int location =1;

        //when
        boolean result = bridge.canMove(nextDirection, location);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }
}
