package bridge;

import static bridge.domain.UpDownBridgeValidator.validateUpBridge;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeValidatorTest {
    private List<String> upBridge;
    private List<String> downBridge;

    @DisplayName("upBridge에 아무 값이 추가되지 않았을 시 예외 발생")
    @Test
    void upBridgeNullTest() {
        upBridge = new ArrayList<>();
        assertThatThrownBy(() -> validateUpBridge(upBridge))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("upBridge에 O,X,공백 외의 문자가 추가될 시 예외 발생")
    @Test
    void upBridgeDataTest() {
        upBridge = new ArrayList<>(List.of("o", "x", "R", "Q", "0"));
        assertThatThrownBy(() -> validateUpBridge(upBridge))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("downBridge에 아무 값이 추가되지 않았을 시 예외 발생")
    @Test
    void downBridgeNullTest() {
        downBridge = new ArrayList<>();
        assertThatThrownBy(() -> validateUpBridge(downBridge))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("downBridge에 O,X,공백 외의 문자가 추가될 시 예외 발생")
    @Test
    void downBridgeDataTest() {
        downBridge = new ArrayList<>(List.of("o", "x", "R", "Q", "0"));
        assertThatThrownBy(() -> validateUpBridge(downBridge))
                .isInstanceOf(IllegalStateException.class);
    }
}
