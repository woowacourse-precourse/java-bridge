package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class ContinueTypeTest {

    @EnumSource(ContinueType.class)
    @ParameterizedTest
    public void 텍스트로_계속할지_확인(ContinueType continueType) {
        Assertions.assertThat(ContinueType.searchContinueTypeToText(continueType.getText()))
                .isEqualTo(continueType);
    }

    @ValueSource(strings = {"UU", "DD", "Z", "U", "K", "W"})
    @ParameterizedTest
    public void 텍스트로_계속할지_응답불가(String text) {
        Assertions.assertThatThrownBy(() ->
                        ContinueType.searchContinueTypeToText(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 텍스트로_계속할지_null() {
        Assertions.assertThatThrownBy(() ->
                        ContinueType.searchContinueTypeToText(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}