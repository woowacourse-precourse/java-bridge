package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {

    @DisplayName("위의 다리를 선택했을 때, 이동할 수 있으면 O, 없으면 X가 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:true:O", "U:false:X"}, delimiter = ':')
    void addMapTop(String moving, boolean canMove, String top) {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addMap(new Moving(moving), canMove);
        List<String> topExpected = List.of(top);
        List<String> bottomExpected = List.of(" ");

        Assertions.assertThat(bridgeMap.getMap()).isEqualTo(List.of(topExpected, bottomExpected));
    }

    @DisplayName("아래 다리를 선택했을 때, 이동할 수 있으면 O, 없으면 X가 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"D:true:O", "D:false:X"}, delimiter = ':')
    void addMapBottom(String moving, boolean canMove, String bottom) {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addMap(new Moving(moving), canMove);
        List<String> topExpected = List.of(" ");
        List<String> bottomExpected = List.of(bottom);

        Assertions.assertThat(bridgeMap.getMap()).isEqualTo(List.of(topExpected, bottomExpected));
    }

    @DisplayName("clearMap메서드를 호출하면 출력 리스트는 빈 리스트가 된다.")
    @Test
    void clearMap() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addMap(new Moving("U"),true);
        bridgeMap.clearMap();
        List<String> topExpected = Collections.emptyList();
        List<String> bottomExpected = Collections.emptyList();

        Assertions.assertThat(bridgeMap.getMap()).isEqualTo(List.of(topExpected, bottomExpected));
    }
}