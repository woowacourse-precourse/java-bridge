package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @DisplayName("다리 길이 관련 테스트")
    @Nested
    class BridgeSizeTest {

        @DisplayName("다리의 생성한 사이즈가 변화하지 않는지 확인")
        @ParameterizedTest(name = "[{index}] 번째 테스트 : size {0}")
        @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
        void BridgeSizeNotChanged(int expected) {
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(expected));
            int actual = bridge.getBridgeSize();
            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("다리의 요소가 변화하지 않는지 확인")
        @ParameterizedTest(name = "[{index}] 번째 테스트 인자 : {0},{1},{2}")
        @CsvSource({"U,U,U", "U,U,D", "U,D,U", "U,D,D", "D,U,U", "D,U,D", "D,D,U", "D,D,D"})
        void bridgeElementNotChanged(String element0, String element1, String element2) {
            ArrayList<String> expected = new ArrayList<>(List.of(element0, element1, element2));
            Bridge actual = new Bridge(expected);
            for (int i = 0; i < expected.size(); ++i) {
                assertThat(actual.getResult(expected.get(i), i)).isEqualTo(true);
            }
        }
    }

    @DisplayName("다리 인덱스 접근 관련 테스트")
    @Nested
    class BridgeIndexTest {

        @DisplayName("유효한 인덱스가 들어 왔을 때 결과를 정확히 반환하는지 확인")
        @Test
        void bridgeAccessWithValidIndex() {
            List<String> expected = new ArrayList<>(List.of("U", "U", "U"));
            Bridge bridge = new Bridge(expected);
            for (int i = 0; i < expected.size(); ++i) {
                assertThat(bridge.getResult(expected.get(i), i)).isEqualTo(true);
            }
        }

        @DisplayName("유효하지 않은 인덱스가 들어 왔을 때 Exception 을 던지는지 확인")
        @ParameterizedTest(name = "[{index}] 번째 테스트 인자 : {0}")
        @ValueSource(ints = {3, 4, 5})
        void bridgeAccessWithInvalidIndex(final int invalidIndex) {
            List<String> expected = new ArrayList<>(List.of("U", "U", "U"));
            Bridge bridge = new Bridge(expected);
            assertThatThrownBy(() -> bridge.getResult("U", invalidIndex))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}