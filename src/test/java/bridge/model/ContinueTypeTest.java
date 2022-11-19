package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContinueTypeTest {

    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    public void 텍스트로_계속할지_확인(String text) {
        Assertions.assertThatCode(() ->
                        ContinueType.searchContinueTypeToText(text))
                .doesNotThrowAnyException();
    }

    @ValueSource(strings = {"UU", "DD", "Z", "U", "K", "W"})
    @ParameterizedTest
    public void 텍스트로_계속할지_응답불가(String text) {
        Assertions.assertThatThrownBy(() ->
                        ContinueType.searchContinueTypeToText(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}