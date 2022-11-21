package bridge.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeBlockTest {

    @DisplayName("생성 번호에 따른 올바른 문자 반환하는지 테스트")
    @Nested
    class StringReturnTest {
        @Test
        void 반환_올바른_문자_UP() {
            assertThat(BridgeBlock.getBlockIdentifier(0)).isEqualTo("D");
        }
        @Test
        void 반환_올바른_문자_DOWN() {
            assertThat(BridgeBlock.getBlockIdentifier(1)).isEqualTo("U");
        }
    }
}