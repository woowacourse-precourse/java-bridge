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

    @Nested
    class IsBridgeAllCrossedTest{

        @DisplayName("하나도 건너지 않았을 경우, false return")
        @Test
        void isBridgeAllCrossed_case1(){
            assertThat(testBridge.isBridgeAllCrossed()).isFalse();
        }

        @DisplayName("하나 건넜을 경우, 덜 건넜으니 false return")
        @Test
        void isBridgeAllCrossed_case2(){
            testBridge.crossBridge("U");
            assertThat(testBridge.isBridgeAllCrossed()).isFalse();
        }

        @DisplayName("두개 건넜을 경우, 덜 건넜으니 false return")
        @Test
        void isBridgeAllCrossed_case3(){
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            assertThat(testBridge.isBridgeAllCrossed()).isFalse();
        }

        @DisplayName("세개 건넜을 경우, 다 건넜으니 true return")
        @Test
        void isBridgeAllCrossed_case4(){
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            testBridge.crossBridge("D");
            assertThat(testBridge.isBridgeAllCrossed()).isTrue();
        }
    }

    @Nested
    class GetAlreadyCrossedBridgeTest{

        @DisplayName("위쪽 하나 건너는 데 성공한 상황에서, 얼마나 건넜는지 확인하기")
        @Test
        void getAlreadyCrossedBridgeTest_case1(){
            testBridge.crossBridge("U");
            List<String> getCrossedBridge = testBridge.getAlreadyCrossedBridge(true);
            assertThat(getCrossedBridge.get(0)).isEqualTo("[ O ]");
            assertThat(getCrossedBridge.get(1)).isEqualTo("[   ]");
        }

        @DisplayName("아래쪽 하나 건너는 데 실패한 상황에서, 얼마나 건넜는지 확인하기")
        @Test
        void getAlreadyCrossedBridgeTest_case2(){
            testBridge.crossBridge("D");
            List<String> getCrossedBridge = testBridge.getAlreadyCrossedBridge(false);
            assertThat(getCrossedBridge.get(0)).isEqualTo("[   ]");
            assertThat(getCrossedBridge.get(1)).isEqualTo("[ X ]");
        }

        @DisplayName("두번째에서 아래를 선택해 성공했을 때, 얼마나 건넜는지 확인하기")
        @Test
        void getAlreadyCrossedBridgeTest_case3(){
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            List<String> getCrossedBridge = testBridge.getAlreadyCrossedBridge(true);
            assertThat(getCrossedBridge.get(0)).isEqualTo("[ O |   ]");
            assertThat(getCrossedBridge.get(1)).isEqualTo("[   | O ]");
        }

        @DisplayName("두번째에서 위를 선택해 실패했을 때, 얼마나 건넜는지 확인하기")
        @Test
        void getAlreadyCrossedBridgeTest_case4(){
            testBridge.crossBridge("U");
            testBridge.crossBridge("U");
            List<String> getCrossedBridge = testBridge.getAlreadyCrossedBridge(false);
            assertThat(getCrossedBridge.get(0)).isEqualTo("[ O | X ]");
            assertThat(getCrossedBridge.get(1)).isEqualTo("[   |   ]");
        }

        @DisplayName("세번째에서 아래를 선택해 성공했을 때, 얼마나 건넜는지 확인하기")
        @Test
        void getAlreadyCrossedBridgeTest_case5(){
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            testBridge.crossBridge("D");
            List<String> getCrossedBridge = testBridge.getAlreadyCrossedBridge(true);
            assertThat(getCrossedBridge.get(0)).isEqualTo("[ O |   |   ]");
            assertThat(getCrossedBridge.get(1)).isEqualTo("[   | O | O ]");
        }

        @DisplayName("세번째에서 위를 선택해 실패했을 때, 얼마나 건넜는지 확인하기")
        @Test
        void getAlreadyCrossedBridgeTest_case6(){
            testBridge.crossBridge("U");
            testBridge.crossBridge("D");
            testBridge.crossBridge("U");
            List<String> getCrossedBridge = testBridge.getAlreadyCrossedBridge(false);
            assertThat(getCrossedBridge.get(0)).isEqualTo("[ O |   | X ]");
            assertThat(getCrossedBridge.get(1)).isEqualTo("[   | O |   ]");
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