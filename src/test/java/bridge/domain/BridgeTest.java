package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    private static final String EXCEPTION_MESSAGE = "[ERROR]";

    @ParameterizedTest(name = "잘못된 다리 사이즈 입력시 예외 발생 테스트 [{index}] : {0} 개")
    @ValueSource(ints = {2, 21})
    void bridgeGenerateSizeExceptionTest(int size) {
        List<String> positions = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        assertThatThrownBy(() -> Bridge.from(positions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }

    @DisplayName("잘못된 리스트 입력시 예외 발생 테스트")
    @Test
    void bridgeGenerateWrongListExceptionTest() {
        List<String> positions = List.of("U", "D", "D", "A", "U");
        assertThatThrownBy(() -> Bridge.from(positions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }

    @ParameterizedTest(name = "다리 타일 체크 테스트 [{index}] : 테스트 결과 반환 - {2}")
    @CsvSource(value = {"3,DOWN,true", "1,UP,false"})
    void checkBridgeTileAtTest(int positionIndex, Tile tile, boolean expectedResult) {
        Bridge bridge = Bridge.from(List.of("U", "D", "U", "D"));
        assertThat(bridge.checkBridgeTileAt(positionIndex, tile)).isEqualTo(expectedResult);
    }

    @DisplayName("다리 사이즈 반환 테스트")
    @Test
    void bridgeSizeTest() {
        Bridge bridge = Bridge.from(List.of("U", "D", "U"));
        assertThat(bridge.size()).isEqualTo(3);
    }

}