package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.model.Bridge;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeTest {
    List<String> testBridge = new ArrayList<>(List.of("U", "D", "D"));

    void initializeBridge() {
        Bridge bridge = new Bridge(testBridge);
    }

    @DisplayName("다리 초기화 - 다리는 U와 D로만 구성되어야 한다.")
    @Test
    void bridgeInitializeWithNoneUOrDTest() {
        // 예외 처리 구현 과정에서 개발 예정
    }

    @DisplayName("다리 초기화 - 다리의 길이는 3~20 사이여야 한다.")
    @Test
    void bridgeInitializeWithOutOfRangeLengthTest() {
        // 예외 처리 구현 과정에서 개발 예정
    }

    @DisplayName("건널 수 있는지 확인 기능 - 아직 초기화 되지 않은 다리에 대해 메소드를 호출할 경우, 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0, 'U'"})
    void canCrossNotInitializedExceptionTest(int space, String direction) {
        assertThatThrownBy(() -> {
            Bridge.canCross(space, direction);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("건널 수 있는지 확인 기능 - 위치와 문자가 입력되었을 때 건널 수 있는지 여부를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({"0, 'U', true",
            "1, 'U', false"})
    void canCrossTest(int space, String direction, boolean canCross) {
        initializeBridge();

        assertThat(Bridge.canCross(space, direction)).isEqualTo(canCross);
    }


}
