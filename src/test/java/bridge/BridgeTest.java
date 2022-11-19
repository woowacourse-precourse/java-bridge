package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @DisplayName("다리 사이즈 입력 예외 테스트: IllegalArgumentException을 던지고 에러 메시지 출력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"123", "abc", "30", " "})
    void 예외_bridgeSizeInput(String input) {
        assertThatThrownBy(()-> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("error throw");
    }

    @DisplayName("다리 사이즈 정상 입력 테스트: 입력 후, 잘 저장됐는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "7:7", "18:18"}, delimiter = ':')
    void 정상_bridgeSizeInput(String input, Integer expected){
        Bridge bridge = new Bridge(input);
        int size = bridge.getBridgeSize();
        assertThat(size).isEqualTo(expected);
    }
}