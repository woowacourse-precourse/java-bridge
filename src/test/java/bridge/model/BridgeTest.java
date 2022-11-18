package bridge.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Nested
    @DisplayName("생성자 유효성 테스트")
    class DescribeConstructValidate {

        @Test
        @DisplayName("인자가 U,D로 이루어진 리스트가 아니라면 IllegalAgumentException을 반환")
        void receiveWrongArgument() {
            List<String> wrongBridge = List.of("A", "B");

            Assertions.assertThatThrownBy(() -> new Bridge(wrongBridge))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("U, D로 이루어진 리스트 인자를 받으면 정상적인 Bridge 생성")
        void receiveValidArgument() {
            List<String> bridge = List.of("U", "D", "U");
            Bridge actual = new Bridge(bridge);

            Assertions.assertThat(actual.getClass()).isEqualTo(Bridge.class);
        }
    }
}