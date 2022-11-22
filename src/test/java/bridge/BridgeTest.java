package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static bridge.Exception.BridgeSizeCheck;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("다리의 길이는 3과 20사이 숫자")
    @CsvSource(value = {"3:3", "5:5", "20:20"}, delimiter = ':')
    @ParameterizedTest
    void bridgeSizeIsBetween3And20(String input, int value) {
        BridgeSizeCheck(input);
        assertThat(Integer.parseInt(input)).isEqualTo(value);
    }

    @DisplayName("다리의 길이는 문자 불가능")
    @CsvSource(value = {"3.3", "abc", "ssssss"})
    @ParameterizedTest
    void bridgeSizeIsOnlyNumber(String input) {
        assertThatThrownBy(() -> BridgeSizeCheck(input))
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("다리의 길이는 양의 숫자")
    @CsvSource(value = {"-5", "-4", "-3333"})
    @ParameterizedTest
    void bridgeSizeIsOnlyPlusNumber(String input) {
        assertThatThrownBy(() -> BridgeSizeCheck(input))
                .hasMessageContaining("[ERROR]");
    }
}
