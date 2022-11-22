package bridge.ui.input.dto;

import bridge.ui.input.InputErrorText;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeInputTest {

    @ParameterizedTest
    @ValueSource(strings = {"1a", "", " ", "1.0", "12.4"})
    public void 다리_길이는_자연수만_가능하다(String input) {
        String expectedErrorText = InputErrorText.ERROR_BRIDGE_NUMBER.errorText();

        assertBridgeSizeCreation(input, expectedErrorText);
    }


    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21"})
    public void 다리_길이는_3에서_20사이만_가능하다(String input) {
        String expectedErrorText = InputErrorText.ERROR_BRIDGE_SIZE.errorText();

        assertBridgeSizeCreation(input, expectedErrorText);
    }

    private void assertBridgeSizeCreation(String input, String expectedErrorText) {
        Assertions.assertThatThrownBy(() ->
                        BridgeSize.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "7", "20", "10", "15"})
    public void 다리_길이는_생성_테스트(String input) {
        BridgeSize bridgeSize = BridgeSize.from(input);

        Assertions.assertThat(bridgeSize.toInteger())
                .isEqualTo(Integer.parseInt(input));
    }


}