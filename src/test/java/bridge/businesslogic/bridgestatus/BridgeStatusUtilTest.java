package bridge.businesslogic.bridgestatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeStatusUtilTest {

    private final BridgeStatusUtil statusUtil = new BridgeStatusUtil();

    @Nested
    class CheckLastTest{

        @DisplayName("Last Pick 정답이 아니었을 때, 기존에 저장되어 있던 O가 X로 바뀌어야 한다.")
        @Test
        void checkLast_case1() {
            StringBuilder testBuilder = new StringBuilder().append("O | O");
            statusUtil.checkLast(testBuilder,false);
            assertThat(testBuilder.toString()).isEqualTo("O | X");
        }

        @DisplayName("Last Pick 정답이 아니면서 맨 처음부터 틀렸을 때, 기존에 저장되어 있던 O가 X로 바뀌어야 한다.")
        @Test
        void checkLast_case2() {
            StringBuilder testBuilder = new StringBuilder().append("O");
            statusUtil.checkLast(testBuilder,false);
            assertThat(testBuilder.toString()).isEqualTo("X");
        }

        @DisplayName("Last Pick 이 정답일 때, 여전히 O 인 상태로 남아야 한다.")
        @Test
        void checkLast_case3() {
            StringBuilder testBuilder = new StringBuilder().append("O | O");
            statusUtil.checkLast(testBuilder,true);
            assertThat(testBuilder.toString()).isEqualTo("O | O");
        }

        @DisplayName("Last Pick 이 정답이면서 첫 정답일 때 , 여전히 O 인 상태로 남아야 한다.")
        @Test
        void checkLast_case4() {
            StringBuilder testBuilder = new StringBuilder().append("O");
            statusUtil.checkLast(testBuilder,true);
            assertThat(testBuilder.toString()).isEqualTo("O");
        }

        @DisplayName("testBuilder 에 아무것도 들어있지 않으면, 여전히 비어있는 StringBuilder 를 반환한다.")
        @Test
        void checkLast_case5(){
            StringBuilder testBuilder = new StringBuilder();
            statusUtil.checkLast(testBuilder,true);
            assertThat(testBuilder.toString()).isEqualTo("");
        }
    }
}