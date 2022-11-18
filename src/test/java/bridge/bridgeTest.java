package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class bridgeTest {

    @Nested
    public class BridgeMakerTest {

        BridgeNumberGenerator bridgeNumberGenerator;
        BridgeMaker bridgeMaker;
        @BeforeEach
        void setUp() {
            bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        }
        @Test
        @DisplayName("다리 사이즈가 3 미만일 때 정상적으로 예외를 던지고 메시지를 출력하는지 테스트")
        void validateBridgeSizeIsFour() {
            assertThatThrownBy(() -> {
                List<String> itSupposedToThrowsException = bridgeMaker.makeBridge(2);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 다리 길이는 3부터");
        }

        @Test
        @DisplayName("다리 사이즈가 20 초과일 때 정상적으로 예외를 던지고 메시지를 출력하는지 테스트")
        void validateBridgeSizeIsTwentyOne() {
            assertThatThrownBy(() -> {
                List<String> itSupposedToThrowsException = bridgeMaker.makeBridge(21);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 다리 길이는 3부터");
        }
    }

    @Nested
    class BridgeTest {
        Bridge bridge;

        @BeforeEach
        void setUp() {
            List<String> testBridge = List.of("U", "D", "U", "D");
            this.bridge = new Bridge(testBridge);
        }

        @Test
        void bridgeShape가_제대로_생성되는지_테스트_모두성공() {
            bridge.generateShape("U", 0);
            bridge.generateShape("D", 1);
            bridge.generateShape("U", 2);
            bridge.generateShape("D", 3);
            assertThat(bridge.getBridgeUpperSide().contains("[O, ,O, ]"));
            assertThat(bridge.getBridgeUpperSide().contains("[ ,O, ,O]"));
            System.out.println(bridge.getBridgeUpperSide());
            System.out.println(bridge.getBridgeDownSide());
        }

        @Test
        void bridgeShape가_제대로_생성되는지_테스트_실패포함() {
            bridge.generateShape("U", 0);
            bridge.generateShape("U", 1);
            bridge.generateShape("D", 2);
            bridge.generateShape("D", 3);
            assertThat(bridge.getBridgeUpperSide().contains("[O,X, , ]"));
            assertThat(bridge.getBridgeUpperSide().contains("[ , ,X,O]"));
            System.out.println(bridge.getBridgeUpperSide());
            System.out.println(bridge.getBridgeDownSide());
        }

        @Test
        void 인풋이_D나_U가_아닐_때_오류_던지는지_테스트() {
            assertThatThrownBy(() -> {
                bridge.generateShape("ItHavaToThrowException", 0);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Nested
    class InputViewTest {

        InputView inputView;
        @BeforeEach
        void setUp() {
            inputView = new InputView();
        }
        @Test
        @DisplayName("다리 사이즈에서 숫자만 정상적으로 받는지 테스트")
        void validateBridgeSizeIsNumberTest() {
            assertThatThrownBy(() -> {
                inputView.convertStringToInt("itCanNotBeConvertedToInt");
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자만 입력해주세요.");
        }
    }

    @Nested
    class OutputViewTest {
        OutputView outputView;
        Bridge bridge;
        @BeforeEach
        void setUp() {
            this.outputView = new OutputView();
            List<String> testBridge = List.of("U", "D", "U", "D");
            this.bridge = new Bridge(testBridge);
            bridge.generateShape("U", 0);
            bridge.generateShape("D", 1);
            bridge.generateShape("U", 2);
            bridge.generateShape("D", 3);
        }
        @Test
        void printMapTest() {
            outputView.printMap(bridge);
        }
    }
}
