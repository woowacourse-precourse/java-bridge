package bridge.domain.player.arguments;

import bridge.domain.game.BridgeTile;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public final class PlayerTestArguments {

    private PlayerTestArguments() {
    }

    static Stream<Arguments> getPlayerTargetTileHistoryArgument() {
        return Stream.of(
                Arguments.of(List.of(BridgeTile.DOWN, BridgeTile.UP), "  | X",  "O |  "),
                Arguments.of(List.of(BridgeTile.DOWN, BridgeTile.DOWN), "  |  ",  "O | O"),
                Arguments.of(List.of(BridgeTile.UP), "X",  " ")
        );
    }

    static Stream<Arguments> successHistoryArgument() {
        return Stream.of(
                Arguments.of(List.of(BridgeTile.DOWN, BridgeTile.UP), false),
                Arguments.of(List.of(BridgeTile.DOWN, BridgeTile.DOWN), false),
                Arguments.of(List.of(BridgeTile.DOWN, BridgeTile.DOWN, BridgeTile.UP), false),
                Arguments.of(List.of(BridgeTile.DOWN, BridgeTile.DOWN, BridgeTile.DOWN), true)
        );
    }
}
