package bridge.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeSizeTest {
    @DisplayName("다리 길이 정상 입력")
    @Test
    public void createBridgeSize() {
        String input = "12";

        assertThat(new BridgeSize(input)).isInstanceOf(BridgeSize.class);
    }

    @DisplayName("3 ~ 20 사이 숫자 형태가 아닌 다리 길이에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"21", "2", "-1", " 20"})
    public void validateByRange(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BridgeSize(input));
    }

    @DisplayName("다리 길이 입력을 안한 경우에 대한 예외 처리")
    @Test
    public void validateByBlank() {
        String input = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BridgeSize(input));
    }
}