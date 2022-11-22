package bridge.paths;

import bridge.identifiers.Direction;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerPathTest {

    @Test
    void 사용자_이동경로는_적절히_저장된다(){
        List<Direction> actual = makePlayerPathWith(
                Direction.UP,
                Direction.UP,
                Direction.DOWN
        );
        assertThat(actual).containsExactly(Direction.UP, Direction.UP, Direction.DOWN);
    }

    @Test
    void 변경_불가능한_사용자_이동경로가_반환된다(){
        assertThatThrownBy(()->{
            List<Direction> path = makePlayerPathWith(
                    Direction.UP,
                    Direction.UP,
                    Direction.DOWN
            );
            path.add(Direction.UP);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    List<Direction> makePlayerPathWith(Direction... args){
        PlayerPath playerPath = new PlayerPath();
        List<Direction> directions = Arrays.stream(args).collect(Collectors.toList());
        for(Direction direction : directions) {
            playerPath.saveDirection(direction);
        }
        return playerPath.getPath();
    }

    @Test
    @Order(0)
    void 사용자_이동경로_서수는_적절히_관리된다(){
        new PlayerPath();
        new PlayerPath();
        new PlayerPath();
        int ordinalNumber = new PlayerPath().getOrdinalNumber();

        assertThat(ordinalNumber).isEqualTo(4);
    }

    @Test
    void 사용자_이동경로는_기본적으로_생존했다고_판단한다(){
        assertThat(new PlayerPath().getIsAlive()).isTrue();
    }

    @Test
    void 사용자_이동경로를_직접_죽었다고_설정하는_것은_정상동작한다(){
        PlayerPath playerPath = new PlayerPath();
        playerPath.die();
        assertThat(playerPath.getIsAlive()).isFalse();
    }
}