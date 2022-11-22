package bridge.businesslogic.bridgehistorystatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeCrossingHistoryTest {

    private BridgeCrossingHistory bridgeCrossing;

    @Nested
    class UpdateStatusTest{

        @DisplayName("아무것도 없을 때 위쪽을 선택하면, 다리 위에 상태에 O 가 들어간다.")
        @Test
        void updateStatus_case1() {
            StringBuilder upLine = new StringBuilder();
            StringBuilder downLine = new StringBuilder();
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            bridgeCrossing.updateHistory("U");
            assertThat(upLine.toString()).isEqualTo("O");
            assertThat(downLine.toString()).isEqualTo(" ");
        }

        @DisplayName("아무것도 없을 때 아래쪽을 선택하면, 다리 아래 상태에 O 가 들어간다.")
        @Test
        void updateStatus_case2() {
            StringBuilder upLine = new StringBuilder();
            StringBuilder downLine = new StringBuilder();
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            bridgeCrossing.updateHistory("D");
            assertThat(upLine.toString()).isEqualTo(" ");
            assertThat(downLine.toString()).isEqualTo("O");
        }

        @DisplayName("이미 데이터가 있는 상태에서 위를 선택하면, 다리 위 상태에 | O 가 들어간다.")
        @Test
        void updateStatus_case3() {
            StringBuilder upLine = new StringBuilder("O");
            StringBuilder downLine = new StringBuilder(" ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            bridgeCrossing.updateHistory("U");
            assertThat(upLine.toString()).isEqualTo("O | O");
            assertThat(downLine.toString()).isEqualTo("  |  ");
        }

        @DisplayName("이미 데이터가 있는 상태에서 아래를 선택하면, 다리 아래 상태에 | O 가 들어간다.")
        @Test
        void updateStatus_case4() {
            StringBuilder upLine = new StringBuilder("O");
            StringBuilder downLine = new StringBuilder(" ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            bridgeCrossing.updateHistory("D");
            assertThat(upLine.toString()).isEqualTo("O |  ");
            assertThat(downLine.toString()).isEqualTo("  | O");
        }
    }

    @Nested
    class ClearAllTest{

        @DisplayName("데이터가 없을 때는, clearAll 해도 그냥 데이터가 없는 상태이다.")
        @Test
        void clearAll_case1(){
            StringBuilder upLine = new StringBuilder();
            StringBuilder downLine = new StringBuilder();
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            bridgeCrossing.clearAll();
            assertThat(upLine.toString()).isEqualTo("");
            assertThat(downLine.toString()).isEqualTo("");
        }

        @DisplayName("데이터가 있을 때, clearAll 하면 두 라인의 데이터 모두가 지워진다.")
        @Test
        void clearAll_case2(){
            StringBuilder upLine = new StringBuilder("O |   | O");
            StringBuilder downLine = new StringBuilder("  | O |  ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            bridgeCrossing.clearAll();
            assertThat(upLine.toString()).isEqualTo("");
            assertThat(downLine.toString()).isEqualTo("");
        }
    }
    @Nested
    class GetBridgeStatusTest{

        @DisplayName("첫 선택이 위면서, 정답을 맞췄을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case1(){
            StringBuilder upLine = new StringBuilder("O");
            StringBuilder downLine = new StringBuilder(" ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",true)).isEqualTo("[ O ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",true)).isEqualTo("[   ]");
        }

        @DisplayName("첫 선택이 아래면서, 정답을 맞췄을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case2(){
            StringBuilder upLine = new StringBuilder(" ");
            StringBuilder downLine = new StringBuilder("O");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",true)).isEqualTo("[   ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",true)).isEqualTo("[ O ]");
        }

        @DisplayName("첫 선택이 위면서, 정답을 틀렸을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case3(){
            StringBuilder upLine = new StringBuilder("O");
            StringBuilder downLine = new StringBuilder(" ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",false)).isEqualTo("[ X ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",false)).isEqualTo("[   ]");
        }

        @DisplayName("첫 선택이 아래면서, 정답을 틀렸을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case4(){
            StringBuilder upLine = new StringBuilder(" ");
            StringBuilder downLine = new StringBuilder("O");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",false)).isEqualTo("[   ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",false)).isEqualTo("[ X ]");
        }

        @DisplayName("마지막 선택이 위면서, 정답을 맞았을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case5(){
            StringBuilder upLine = new StringBuilder("O | O");
            StringBuilder downLine = new StringBuilder("  |  ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",true)).isEqualTo("[ O | O ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",true)).isEqualTo("[   |   ]");
        }

        @DisplayName("마지막 선택이 위면서, 정답을 틀렸을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case6(){
            StringBuilder upLine = new StringBuilder("O | O");
            StringBuilder downLine = new StringBuilder("  |  ");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",false)).isEqualTo("[ O | X ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",false)).isEqualTo("[   |   ]");
        }

        @DisplayName("마지막 선택이 아래면서, 정답을 맞았을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case7(){
            StringBuilder upLine = new StringBuilder("O |  ");
            StringBuilder downLine = new StringBuilder("  | O");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",true)).isEqualTo("[ O |   ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",true)).isEqualTo("[   | O ]");
        }

        @DisplayName("마지막 선택이 아래면서, 정답을 틀렸을 때의 BridgeStatus")
        @Test
        void getBridgeStatus_case8(){
            StringBuilder upLine = new StringBuilder("O |  ");
            StringBuilder downLine = new StringBuilder("  | O");
            bridgeCrossing = new BridgeCrossingHistory(upLine,downLine);
            assertThat(bridgeCrossing.getBridgeHistory("U",false)).isEqualTo("[ O |   ]");
            assertThat(bridgeCrossing.getBridgeHistory("D",false)).isEqualTo("[   | X ]");
        }
    }
}