package bridge.businesslogic;

import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {

    private Bridge testBridge;
    private final BridgeNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1,0,0));
    // 테스트를 위해, 다리 길이는 3으로 고정하고, 정답 bridge 는 "U,D,D"로 제한함.

    private final BridgeMaker testBridgeMaker = new BridgeMaker(testNumberGenerator);
    private final int testBridgeSize = 3;

    @BeforeEach
    void beforeProcess(){
        testBridge = new Bridge(testBridgeMaker, testBridgeSize);
    }

    @Nested
    class IsSelectedBridgesRightTest{

        @DisplayName("첫 선택에서 위를 선택하면, 정답인 경우 true return")
        @Test
        void isSelectedBridgesRight_case1() {
            String userPick = "U";
            assertThat(testBridge.isSelectedBridgesRight(userPick)).isTrue();
        }

        @DisplayName("첫 선택에서 아래를 선택하면, 틀려서 false return")
        @Test
        void isSelectedBridgesRight_case2() {
            String userPick = "D";
            assertThat(testBridge.isSelectedBridgesRight(userPick)).isFalse();
        }

        @DisplayName("두번째 선택에서 아래를 선택하면, 정답인 경우 true return")
        @Test
        void isSelectedBridgesRight_case3() {
            testBridge.crossBridge("U");
            String userPick = "D";
            assertThat(testBridge.isSelectedBridgesRight(userPick)).isTrue();
        }

        @DisplayName("두번째 선택에서 위를 선택하면, 틀려서 false return")
        @Test
        void isSelectedBridgesRight_case4() {
            testBridge.crossBridge("U");
            String userPick = "U";
            assertThat(testBridge.isSelectedBridgesRight(userPick)).isFalse();
        }

        @DisplayName("세번째 선택에서 아래를 선택하면, 정답인 경우 true return")
        @Test
        void isSelectedBridgesRight_case5() {
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            String userPick = "D";
            assertThat(testBridge.isSelectedBridgesRight(userPick)).isTrue();
        }

        @DisplayName("세번째 선택에서 위를 선택하면, 틀려서 false return")
        @Test
        void isSelectedBridgesRight_case6() {
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            String userPick = "U";
            assertThat(testBridge.isSelectedBridgesRight(userPick)).isFalse();
        }
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}