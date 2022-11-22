package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @Nested
    @DisplayName("BridgeSize 생성자를 검증한다.")
    class Validation {
        @ParameterizedTest
        @ValueSource(strings = {"3", "20"})
        @DisplayName("다리의 길이는 3 이상 20 이하의 숫자만 입력 가능하다.")
        void validate2(String size) {
            assertThat(new BridgeSize(size)).isEqualTo(new BridgeSize(size));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "1000j", "2", "21"})
        @DisplayName("예외처리")
        void validate(String size) {
            assertThrows(IllegalArgumentException.class, () -> new BridgeSize(size));
        }
    }

    @Nested
    @DisplayName("BridgeSize 객체를 비교한다.")
    class Equals {
        @ParameterizedTest
        @ValueSource(strings = {"3", "20"})
        @DisplayName("다리의 길이가 같으면 같은 객체로 판단한다.")
        void equals(String size) {
            BridgeSize bridgeSize = new BridgeSize(size);
            assertThat(bridgeSize).isEqualTo(bridgeSize);
        }

        @ParameterizedTest
        @ValueSource(strings = {"3", "20"})
        @DisplayName("다리의 길이가 다르면 다른 객체로 판단한다.")
        void notEquals(String size) {
            assertThat(new BridgeSize(size)).isNotEqualTo(new BridgeSize("4"));
        }

        @ParameterizedTest
        @ValueSource(strings = {"3", "20"})
        @DisplayName("다른 타입의 객체와 비교하면 다른 객체로 판단한다.")
        void notEquals2(String size) {
            assertThat(new BridgeSize(size)).isNotEqualTo(new Object());
        }
    }

    @Nested
    @DisplayName("BridgeSize 객체를 비교한다.")
    class HashCode {

        @ParameterizedTest
        @ValueSource(strings = {"3", "20"})
        @DisplayName("다리의 길이가 다르면 다른 객체로 판단한다.")
        void notEquals(String size) {
            assertThat(new BridgeSize(size).hashCode()).isNotEqualTo(new BridgeSize("4").hashCode());
        }
    }
}
