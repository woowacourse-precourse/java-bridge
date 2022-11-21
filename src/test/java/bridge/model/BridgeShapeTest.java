package bridge.model;

import bridge.domain.BridgeShape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeShapeTest {

    BridgeShape bridgeShape = new BridgeShape();
    StringBuilder answerUpBridge = new StringBuilder();
    StringBuilder answerDownBridge = new StringBuilder();

    @Nested
    class MoveBridgeTest {

        @DisplayName("첫번째 칸을 위에 다리를 선택하고 그 칸이 지나갈수 있는 칸일때")
        @Test
        void case1() {
            bridgeShape.initializeBridgeShape();
            bridgeShape.moveBridge("U", true);

            assertThat(bridgeShape.getUpBridge()).contains("[ O ]");
            assertThat(bridgeShape.getDownBridge()).contains("[   ]");

        }

        @DisplayName("첫번째 칸을 아래 다리를 선택하고 그 칸이 지나갈 수 있는 칸이고 " +
                "두번째 칸을 위에 다리를 선택하고 그 칸이 지나갈 수 없는 칸일때")
        @Test
        void case2() {
            bridgeShape.initializeBridgeShape();
            bridgeShape.moveBridge("D", true);
            bridgeShape.moveBridge("U", false);

            assertThat(bridgeShape.getUpBridge()).contains("[   | X ]");
            assertThat(bridgeShape.getDownBridge()).contains("[ O |   ]");

        }

        @DisplayName("만들고 있던 다리 모양을 초기화 시켜주는 메서드 테스트")
        @Test
        void case3() {
            bridgeShape.moveBridge("D", true);
            bridgeShape.initializeBridgeShape();

            assertThat(bridgeShape.getUpBridge()).contains("[]");
            assertThat(bridgeShape.getDownBridge()).contains("[]");
        }

    }

}