package bridge.domain;

import bridge.constant.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMapTest {
    private BridgeMap bridgeMap;

    @BeforeEach
    void setUp() {
        bridgeMap = new BridgeMap();
    }

    @DisplayName("위의 다리를 선택했을 때, 이동할 수 있으면 O, 없으면 X가 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:true:O", "U:false:X"}, delimiter = ':')
    void addMapTop(String moving, boolean canMove, String top) {
        bridgeMap.addMap(new Moving(moving), canMove);
        List<String> topExpected = List.of(top);
        List<String> bottomExpected = List.of(Constant.BLANK);

        assertThat(bridgeMap.getMap()).isEqualTo(List.of(topExpected, bottomExpected));
    }

    @DisplayName("아래 다리를 선택했을 때, 이동할 수 있으면 O, 없으면 X가 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"D:true:O", "D:false:X"}, delimiter = ':')
    void addMapBottom(String moving, boolean canMove, String bottom) {
        bridgeMap.addMap(new Moving(moving), canMove);
        List<String> topExpected = List.of(Constant.BLANK);
        List<String> bottomExpected = List.of(bottom);

        assertThat(bridgeMap.getMap()).isEqualTo(List.of(topExpected, bottomExpected));
    }
}