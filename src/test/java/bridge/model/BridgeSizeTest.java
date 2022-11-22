package bridge.model;

import bridge.constant.Bridge;
import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {

    @DisplayName("올바른 다리 길이 입력시 정상적으로 값을 리턴한다.")
    @Test
    void createRightSize() {
        for (int size = Bridge.MIN.getNumber(); size <= Bridge.MAX.getNumber(); size++) {
            BridgeSize bridgeSize = new BridgeSize(Integer.toString(size));
            assertThat(bridgeSize.getBridgeSize()).isEqualTo(size);
        }
    }

    @DisplayName("다리 길이가 문자일 경우 에러가 발생한다.")
    @ValueSource(strings = {"aa", "3a", "3ㅁ"})
    @ParameterizedTest
    void createBridgeSizeInString(String size) {
        assertThatThrownBy(() -> new BridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_TYPE.getMessage());
    }

    @DisplayName("다리 길이가 소수일 경우 에러가 발생한다.")
    @ValueSource(strings = {"3.0", "20.0", "10.5"})
    @ParameterizedTest
    void createBridgeSizeInDecimal(String size) {
        assertThatThrownBy(() -> new BridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_TYPE.getMessage());
    }

    @DisplayName("다리 길이가 3 미만일 경우 에러가 발생한다.")
    @ValueSource(strings = {"2", "1", "0"})
    @ParameterizedTest
    void createBridgeSizeUnderRange(String size) {
        assertThatThrownBy(() -> new BridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_RANGE.getMessage());
    }

    @DisplayName("다리 길이가 20 초과일 경우 에러가 발생한다.")
    @ValueSource(strings = {"21", "100000", "30"})
    @ParameterizedTest
    void createBridgeSizeOverRange(String size) {
        assertThatThrownBy(() -> new BridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_RANGE.getMessage());
    }
}
