package bridge.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static bridge.Constant.InputValue.SELECTION_DOWN;
import static bridge.Constant.InputValue.SELECTION_UP;

import static org.assertj.core.api.Assertions.assertThat;



class BridgeBlockTest {
    private static final int SELECTION_UP_NUMBER = 1;
    private static final int SELECTION_DOWN_NUMBER = 0;

    @DisplayName("생성 번호에 따른 올바른 문자 반환하는지 테스트")
    @Nested
    class StringReturnTest {
        @Test
        void 반환_올바른_문자_UP() {
            assertThat(BridgeBlock.getBlockIdentifier(SELECTION_UP_NUMBER)).isEqualTo(SELECTION_UP);
        }
        @Test
        void 반환_올바른_문자_DOWN() {
            assertThat(BridgeBlock.getBlockIdentifier(SELECTION_DOWN_NUMBER)).isEqualTo(SELECTION_DOWN);
        }
    }
}