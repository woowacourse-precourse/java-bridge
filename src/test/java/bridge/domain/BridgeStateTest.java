package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeStateTest {

    private BridgeState bridgeState;

    @BeforeEach
    void setUp() {
        bridgeState = new BridgeState();
    }

    @Nested
    class AddBridge {

        @Test
        void upBridge_다리가_추가_되는지_확인() {
            bridgeState.addBridge("U", "O");

            assertThat(bridgeState).extracting("upBridge").isEqualTo(List.of("O"));
        }

        @Test
        void upBridge_다리가_추가에_실패_하였을때_확인() {
            bridgeState.addBridge("U", "X");

            assertThat(bridgeState).extracting("upBridge").isEqualTo(List.of("X"));
        }

        @Test
        void downBridge_다리가_추가_되는지_확인() {
            bridgeState.addBridge("D", "O");

            assertThat(bridgeState).extracting("downBridge").isEqualTo(List.of("O"));
        }

        @Test
        void downBridge_다리가_추가에_실패_하였을때_확인() {
            bridgeState.addBridge("D", "X");

            assertThat(bridgeState).extracting("downBridge").isEqualTo(List.of("X"));
        }
    }


    @Nested
    class UpBridgeGenerate {

        @Test
        void upBridge가_2개_생성_되어_있는지_확인() {
            bridgeState.addBridge("U", "O");
            bridgeState.addBridge("U", "O");

            String upBridgeGenerate = bridgeState.upBridgeGenerate();

            assertThat(upBridgeGenerate).isEqualTo("[ O | O ]");
        }

        @Test
        void upBridge가_3개_생성_되어_있는지_확인() {
            bridgeState.addBridge("U", "O");
            bridgeState.addBridge("U", "O");
            bridgeState.addBridge("U", "O");

            String upBridgeGenerate = bridgeState.upBridgeGenerate();

            assertThat(upBridgeGenerate).isEqualTo("[ O | O | O ]");
        }

        @Test
        void upBridge가_실패_하였을_경우_확인() {
            bridgeState.addBridge("U", "X");

            String upBridgeGenerate = bridgeState.upBridgeGenerate();

            assertThat(upBridgeGenerate).isEqualTo("[ X ]");
        }

        @Test
        void upBridge가_첫번째_성공하고_그다음_실패_한다면_O_X표시_되는지_확인() {
            bridgeState.addBridge("U", "O");
            bridgeState.addBridge("U", "X");

            String upBridgeGenerate = bridgeState.upBridgeGenerate();

            assertThat(upBridgeGenerate).isEqualTo("[ O | X ]");
        }
    }

    @Nested
    class DownBridgeGenerate {

        @Test
        void downBridge가_2개_생성_되어_있는지_확인() {
            bridgeState.addBridge("D", "O");
            bridgeState.addBridge("D", "O");

            String downBridgeGenerate = bridgeState.downBridgeGenerate();

            assertThat(downBridgeGenerate).isEqualTo("[ O | O ]");
        }

        @Test
        void downBridge가_3개_생성_되어_있는지_확인() {
            bridgeState.addBridge("D", "O");
            bridgeState.addBridge("D", "O");
            bridgeState.addBridge("D", "O");

            String downBridgeGenerate = bridgeState.downBridgeGenerate();

            assertThat(downBridgeGenerate).isEqualTo("[ O | O | O ]");
        }

        @Test
        void downBridge가_실패_하였을_경우_확인() {
            bridgeState.addBridge("D", "X");

            String downBridgeGenerate = bridgeState.downBridgeGenerate();

            assertThat(downBridgeGenerate).isEqualTo("[ X ]");
        }

        @Test
        void downBridge가_첫번째_성공하고_그다음_실패_한다면_O_X표시_되는지_확인() {
            bridgeState.addBridge("D", "O");
            bridgeState.addBridge("D", "X");

            String downBridgeGenerate = bridgeState.downBridgeGenerate();

            assertThat(downBridgeGenerate).isEqualTo("[ O | X ]");
        }
    }

    @Nested
    class Reset {

        @Test
        void upBridge가_리셋_되는지_확인() {
            bridgeState.addBridge("U", "O");

            bridgeState.reset();
            String upBridgeGenerate = bridgeState.upBridgeGenerate();

            assertThat(upBridgeGenerate).isEqualTo("[  ]");
        }

        @Test
        void downBridge가_리셋_되는지_확인() {
            bridgeState.addBridge("U", "O");

            bridgeState.reset();
            String downBridgeGenerate = bridgeState.downBridgeGenerate();

            assertThat(downBridgeGenerate).isEqualTo("[  ]");
        }
    }
}