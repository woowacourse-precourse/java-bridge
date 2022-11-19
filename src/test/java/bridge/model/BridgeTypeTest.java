package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTypeTest {

    @ValueSource(ints = {0, 1})
    @ParameterizedTest
    public void 다리_생성_시_랜덤값_일치하는_텍스트로_전환(int randomNumber) {
        Assertions.assertThatCode(() ->
                        BridgeType.convertRandomNumberToText(randomNumber))
                .doesNotThrowAnyException();
    }

    @ValueSource(ints = {-5, 2, 3, 7, -9, 11})
    @ParameterizedTest
    public void 다리_생성_시_랜덤값_불일치(int randomNumber) {
        Assertions.assertThatThrownBy(() ->
                        BridgeType.convertRandomNumberToText(randomNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @EnumSource(BridgeType.class)
    @ParameterizedTest
    public void 텍스트로_건널_다리_찾기(BridgeType bridgeType) {
        Assertions.assertThat(BridgeType.searchBridgeToText(bridgeType.getText()))
                .isEqualTo(bridgeType);
    }

    @ValueSource(strings = {"UU", "DD", "Z", "Q", "K", "W"})
    @ParameterizedTest
    public void 텍스트로_건널_다리_검색불가(String text) {
        Assertions.assertThatThrownBy(() ->
                        BridgeType.searchBridgeToText(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 텍스트로_건널_다리_null() {
        Assertions.assertThatThrownBy(() ->
                        BridgeType.searchBridgeToText(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}