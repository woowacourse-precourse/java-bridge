package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TileTest {

    @DisplayName("다리의 각 칸이 건널 수 있는지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("provideTileStatusWithOutput")
    void returnTrueIfCrossTile(Tile tile, boolean expected) {
        assertThat(tile.isPassable()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTileStatusWithOutput() {
        return Stream.of(
            Arguments.of(Tile.PASS, true),
            Arguments.of(Tile.NO_PASS, false)
        );
    }
}
