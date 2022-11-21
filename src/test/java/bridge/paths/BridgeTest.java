package bridge.paths;

import bridge.identifiers.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeTest {

    @Test
    void 다리길이가_안전경로_길이와_다르면_예외처리한다(){
        assertThatThrownBy(()->{
            List<String> securePath = List.of("U", "D", "D");
            Bridge bridge = new Bridge(securePath, 2);
        }).isInstanceOf(InternalError.class);
    }

    @Test
    void 안전경로가_주어지지_않으면_예외처리한다(){
        assertThatThrownBy(()->{
            Bridge bridge = new Bridge(null, 0);
        }).isInstanceOf(InternalError.class);
    }

    @Test
    void 안전경로가_사용자_경로와_같을_때_확인(){
        Bridge bridge = new Bridge(List.of("U", "D", "D"), 3);
        PlayerPath playerPath = new PlayerPath();
        playerPath.saveDirection(Direction.UP);
        playerPath.saveDirection(Direction.DOWN);
        playerPath.saveDirection(Direction.DOWN);

        assertThat(bridge.checkCollapse(playerPath)).isTrue();
    }

    @Test
    void 안전경로가_사용자_경로와_다를_때_확인(){
        Bridge bridge = new Bridge(List.of("U", "D", "D"), 3);
        PlayerPath playerPath = new PlayerPath();
        playerPath.saveDirection(Direction.UP);
        playerPath.saveDirection(Direction.DOWN);
        playerPath.saveDirection(Direction.UP);

        assertThat(bridge.checkCollapse(playerPath)).isFalse();
    }

    @Test
    void 안전경로도_사용자_경로의_마지막_인덱스로_확인하는지_검사(){
        Bridge bridge = new Bridge(List.of("U", "D", "D"), 3);
        PlayerPath playerPath = new PlayerPath();
        playerPath.saveDirection(Direction.UP);
        playerPath.saveDirection(Direction.UP);
        playerPath.saveDirection(Direction.DOWN);

        assertThat(bridge.checkCollapse(playerPath)).isTrue();
    }
}