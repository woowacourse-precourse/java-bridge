package bridge;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    private static final String EXCEPTION_MESSAGE_OVER_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    @DisplayName("최소길이의 다리를 setBridge 할때 정상적으로 작동한다.")
    @Test
    void executeSetBridge1() {
        Bridge bridge = new Bridge();
        List<String> testBridge = List.of("U", "U", "D");
        boolean result = true;
        try {
            bridge.setBridge(testBridge);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("최대길이의 다리를 setBridge 할때 정상적으로 작동한다.")
    @Test
    void executeSetBridge2() {
        Bridge bridge = new Bridge();
        List<String> testBridge = List.of("U", "U", "D", "U", "U", "D", "U", "U", "D", "U"
                , "U", "D", "U", "U", "D", "U", "U", "D", "U", "U");
        boolean result = true;
        try {
            bridge.setBridge(testBridge);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("다리의 길이가 3보다 작으면 setBridge 함수가 예외를 발생한다.")
    @Test
    void setBridgeBySmallSize() {
        Bridge bridge = new Bridge();
        List<String> testBridge = List.of("U", "D");
        assertThatThrownBy(() -> bridge.setBridge(testBridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(EXCEPTION_MESSAGE_OVER_SIZE));
    }

    @DisplayName("다리의 길이가 20보다 크면 setBridge 함수가 예외를 발생한다.")
    @Test
    void setBridgeByBigSize() {
        Bridge bridge = new Bridge();
        List<String> testBridge = List.of("U", "U", "D", "U", "U", "D", "U", "U", "D", "U"
                , "U", "D", "U", "U", "D", "U", "U", "D", "U", "U"
                , "D");
        assertThatThrownBy(() -> bridge.setBridge(testBridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(EXCEPTION_MESSAGE_OVER_SIZE));
    }

}
