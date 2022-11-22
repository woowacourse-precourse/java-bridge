package bridge;

import enumCollections.Side;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MapTest {
    private final Map map = new Map();

    @DisplayName("맵 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"UP:true:O", "DOWN:true:O", "UP:false:X", "DOWN:false:X"}, delimiter = ':')
    void 맵_생성_테스트_(String side, String movable, String expected) {
        Side movingSide = Side.get(side);
        boolean isMovable = Boolean.valueOf(movable);
        map.add(movingSide, isMovable);
        assertThat(map.get()).toString().contains(expected);
    }

    @DisplayName("맵 초기화 테스트")
    @ParameterizedTest
    @EnumSource(Side.class)
    void 윗칸_이동_성공_테스트(Side side) {
        map.add(side, true);
        map.add(side, true);
        map.add(side, true);
        map.initialize();
        assertThat(map.get())
                .toString().isEmpty();
    }

    static Stream<Arguments> generateMap() {
        return Stream.of(
                Arguments.of("U", "U", "D", "D"),
                Arguments.of("U", "D", "U", "D"),
                Arguments.of("U", "U", "D", "D", "U", "U", "D", "D", "U", "U", "D", "D"),
                Arguments.of("U", "D", "U", "D", "U", "U", "D", "D")
        );
    }
}