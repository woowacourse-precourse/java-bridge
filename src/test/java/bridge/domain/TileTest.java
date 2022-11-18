package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TileTest {

    private static final String EXCEPTION_MESSAGE = "[ERROR]";

    @ParameterizedTest(name = "findByCode 테스트 [{index}] : {1}")
    @CsvSource(value = {"0,DOWN", "1,UP"})
    void findByCodeTest(int code, Tile expectedTile) {
        Tile actualTile = Tile.findByCode(code);
        assertThat(actualTile).isEqualTo(expectedTile);
    }

    @ParameterizedTest(name = "findByCode 조건 외 입력 시 예외 발생 테스트 [{index}] : {0} 입력")
    @ValueSource(ints = {2, 3, 4, 12, 334, -1})
    void findByCodeExceptionTest(int code) {
        assertThatThrownBy(() -> Tile.findByCode(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }

    @ParameterizedTest(name = "findByTilePosition 테스트 [{index}] : {1}")
    @CsvSource(value = {"D,DOWN", "U,UP"})
    void findByPositionSignTest(String position, Tile expectedTil) {
        Tile actualTile = Tile.findByPositionSign(position);
        assertThat(actualTile).isEqualTo(expectedTil);
    }

    @ParameterizedTest(name = "findByTilePosition 에 조건 외 입력 시 예외 발생 테스트 [{index}] : {0} 입력")
    @ValueSource(strings = {"asd", "a", "B", "0", "1"})
    void findByPositionSignExceptionTest(String positionInput) {
        assertThatThrownBy(() -> Tile.findByPositionSign(positionInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }

    @ParameterizedTest(name = "다리 지도용 toString 테스트 [{index}] : [{3}] 출력")
    @CsvSource(value = {"UP,UP,true,' O '", "DOWN,DOWN,false,' X '", "UP,DOWN,ture,'   '"})
    void toFormatStringTest(Tile baseTile, Tile playerTile, boolean isSurvive, String expectedResult) {
        assertThat(baseTile.toFormatString(playerTile, isSurvive)).isEqualTo(expectedResult);
    }
}