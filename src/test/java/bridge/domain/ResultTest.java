package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.Direction;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    private static List<Direction> toDirectionList(List<String> direction) {
        return direction.stream()
                .map(Direction::from)
                .collect(Collectors.toUnmodifiableList());
    }

    private static Stream<Arguments> provideSuccessBridgeDirectionAndPlayerDirection() {
        return Stream.of(
                Arguments.of(
                        List.of("U", "U", "U", "D", "D", "D"),
                        List.of("U", "U", "U", "D", "D", "D")
                ),
                Arguments.of(
                        List.of("D", "D", "D", "U", "U", "U"),
                        List.of("D", "D", "D", "U", "U", "U")
                ),
                Arguments.of(
                        List.of("U", "D", "U", "D", "U", "D"),
                        List.of("U", "D", "U", "D", "U", "D")
                )
        );
    }

    private static Stream<Arguments> provideFailBridgeDirectionAndPlayerDirection() {
        return Stream.of(
                Arguments.of(
                        List.of("U", "U", "U", "D", "D", "D"),
                        List.of("U", "U", "U", "D", "D", "U")
                ),
                Arguments.of(
                        List.of("D", "D", "D", "U", "U", "U"),
                        List.of("U")
                ),
                Arguments.of(
                        List.of("U", "D", "U", "D", "U", "D"),
                        List.of("U", "U")
                )
        );
    }

    @Test
    @DisplayName("다리를 건너지 못하여 게임이 종료된 경우 true를 반환한다.")
    @MethodSource("provideBridgeDirections")
    public void gameEndByFailToCrossThenFalse() throws Exception {
        //given
        Result result = new Result();
        Bridge bridge = new Bridge(List.of("U", "U", "U", "D", "D", "D"));
        Direction direction = Direction.DOWNSIDE;

        //when
        result.update(bridge, direction);

        //then
        assertThat(result.isEnd(bridge)).isEqualTo(true);
    }

    @Test
    @DisplayName("다리의 끝에 도달하여 게임이 종료된 경우 true를 반환한다.")
    public void gameEndByEndOfBridgeThenFalse() throws Exception {
        //given
        Result result = new Result();
        List<String> directions = List.of("U", "U", "U", "D", "D", "D");
        Bridge bridge = new Bridge(directions);

        //when
        for (Direction direction : toDirectionList(directions)) {
            result.update(bridge, direction);
        }

        //then
        assertThat(result.isEnd(bridge)).isEqualTo(true);
    }

    @Test
    @DisplayName("다리를 정상적으로 건너고 다리 끝에 도달하지 않아 게임이 종료되지 않은 경우 false를 반환한다.")
    public void gameContinueByAfterCrossBridgeThenBridge() throws Exception {
        //given
        Result result = new Result();
        List<String> directions = List.of("U", "U", "U", "D", "D", "D");
        Bridge bridge = new Bridge(directions);
        Direction direction = Direction.UPSIDE;

        //when
        result.update(bridge, direction);

        //then
        assertThat(result.isEnd(bridge)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("게임을 성공했을 경우 true를 반환한다.")
    @MethodSource("provideSuccessBridgeDirectionAndPlayerDirection")
    public void gameSuccessThenTrue(List<String> bridgeDirections, List<String> playerDirections) throws Exception {
        //given
        Result result = new Result();
        Bridge bridge = new Bridge(bridgeDirections);

        //when
        for (Direction playerDirection : toDirectionList(playerDirections)) {
            result.update(bridge, playerDirection);
        }

        //then
        assertThat(result.isSuccess(bridge)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("게임에 실패했을 경우 false를 반환한다.")
    @MethodSource("provideFailBridgeDirectionAndPlayerDirection")
    public void gameFailThenFalse(List<String> bridgeDirections, List<String> playerDirections) throws Exception {
        //given
        Result result = new Result();
        Bridge bridge = new Bridge(bridgeDirections);

        //when
        for (Direction playerDirection : toDirectionList(playerDirections)) {
            result.update(bridge, playerDirection);
        }

        //then
        assertThat(result.isSuccess(bridge)).isEqualTo(false);
    }
}
