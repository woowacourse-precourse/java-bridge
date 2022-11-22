package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.controller.BridgeGameController;
import bridge.model.BridgeMaker;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("BridgeGameController 클래스")
@Nested
class BridgeGameControllerTest {

    @DisplayName("decideBridgeLength 메소드는")
    @Nested
    class Describe_decideBridgeLength {

        @DisplayName("다리의 길이를 입력받는다.")
        @Test
        void decideBridgeLengthTest() {
            SoftAssertions softAssertions = new SoftAssertions();

            BridgeGameController bridgeGameController = new BridgeGameController();
            System.setIn(new ByteArrayInputStream("7".getBytes()));

            softAssertions.assertThat(bridgeGameController.decideBridgeLength()).isEqualTo(7);
            softAssertions.assertAll();
        }
    }

    @DisplayName("generateBridge 메소드는")
    @Nested
    class Describe_generateBridge {

        @DisplayName("다리의 길이를 입력받아 다리를 생성한다.")
        @Test
        void generateBridgeTest() {
            TestBridgeGameController testBridgeGameController = new TestBridgeGameController();
            List<String> bridge = testBridgeGameController.generateBridge(7);

            assertThat(bridge).isEqualTo(List.of("U", "D", "U", "D", "U", "D", "U"));
        }

    }

    class TestBridgeGameController extends BridgeGameController {

        @Override
        public List<String> generateBridge(int bridgeSize) {
            TestNumberGenerator testNumberGenerator = new TestNumberGenerator(
                    newArrayList(1, 0, 1, 0, 1, 0, 1));
            BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);

            final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

            return bridge;
        }

    }
}
