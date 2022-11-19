package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {

    @DisplayName("올바른 다리 길이 입력시 정상적으로 값을 리턴한다.")
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10", "11",
            "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    @ParameterizedTest
    void createRightSize(String size) {
        BridgeSize bridgeSize = new BridgeSize(size);
        assertThat(bridgeSize.getBridgeSize()).isEqualTo(Integer.parseInt(size));
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
    @Test
    void createBridgeSizeUnderRange() {
        assertThatThrownBy(() -> new BridgeSize("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_RANGE.getMessage());
    }

    @DisplayName("다리 길이가 20 초과일 경우 에러가 발생한다.")
    @Test
    void createBridgeSizeOverRange() {
        assertThatThrownBy(() -> new BridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_RANGE.getMessage());
    }
}
