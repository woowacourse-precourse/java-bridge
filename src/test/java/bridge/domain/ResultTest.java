package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("다리를 건너지 못하여 게임이 종료된 경우 true를 반환한다.")
    public void gameEndByFailToCrossThenFalse() throws Exception{
        //given
        Result result = new Result();
        Bridge bridge = Bridge.from(List.of("U", "U", "U", "D", "D", "D"));

        //when
        result.update(bridge, "D");

        //then
        assertThat(result.isEnd(bridge)).isEqualTo(true);
    }

    @Test
    @DisplayName("다리의 끝에 도달하여 게임이 종료된 경우 true를 반환한다.")
    public void gameEndByEndOfBridgeThenFalse() throws Exception{
        //given
        Result result = new Result();
        List<String> directions = List.of("U", "U", "U", "D", "D", "D");
        Bridge bridge = Bridge.from(directions);

        //when
        for (String direction : directions) {
            result.update(bridge, direction);
        }

        //then
        assertThat(result.isEnd(bridge)).isEqualTo(true);
    }

    @Test
    @DisplayName("다리를 정상적으로 건너고 다리 끝에 도달하지 않아 게임이 종료되지 않은 경우 false를 반환한다.")
    public void gameContinueByAfterCrossBridgeThenBridge() throws Exception{
        //given
        Result result = new Result();
        List<String> directions = List.of("U", "U", "U", "D", "D", "D");
        Bridge bridge = Bridge.from(directions);

        //when
        result.update(bridge,"U");

        //then
        assertThat(result.isEnd(bridge)).isEqualTo(false);
    }
}
