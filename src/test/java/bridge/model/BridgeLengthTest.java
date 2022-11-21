package bridge.model;

import bridge.model.BridgeLength;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeLengthTest{

    @DisplayName("다리의 길이가 숫자가 아닌 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a","bc","$",".@#!#!"})
    void 다리_길이_숫자_예외_테스트(String length){
        assertThatThrownBy(() ->
                 BridgeLength.createBridgeLength(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3부터 20 사이의 숫자가 아닌 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0","1","2","21"})
    void 다리_길이_범위_예외_테스트(String length){
        assertThatThrownBy(() ->
                 BridgeLength.createBridgeLength(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
