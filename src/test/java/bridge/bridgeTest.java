package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            bridge.judgeAnswer("U", 0);
            bridge.judgeAnswer("D", 1);
            bridge.judgeAnswer("U", 2);
            bridge.judgeAnswer("D", 3);
            assertThat(bridge.getBridgeUpperSide().contains("[O, ,O, ]"));
            assertThat(bridge.getBridgeUpperSide().contains("[ ,O, ,O]"));
        }

        @Test
        void bridgeShape가_제대로_생성되는지_테스트_실패포함() {
            bridge.judgeAnswer("U", 0);
            bridge.judgeAnswer("U", 1);
            bridge.judgeAnswer("D", 2);
            bridge.judgeAnswer("D", 3);
            assertThat(bridge.getBridgeUpperSide().contains("[O,X, , ]"));
            assertThat(bridge.getBridgeUpperSide().contains("[ , ,X,O]"));
        }

        @Test
        void 인풋이_D나_U가_아닐_때_오류_던지는지_테스트() {
            assertThatThrownBy(() -> {
                bridge.judgeAnswer("ItHavaToThrowException", 0);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 인풋유디아니고그다음에정상입력() {
            assertThatThrownBy(() -> {
                bridge.judgeAnswer("u", 0);
            }).isInstanceOf(IllegalArgumentException.class);

            assertThat(bridge.judgeAnswer("U",0)).isEqualTo(true);
        }
    }

    @Nested
    class BridgeGameTest {
        BridgeGame bridgeGame;

        @BeforeEach
        void setUp() {
            List<String> testBridge = List.of("U", "D", "U", "D");
            Player player = new Player();
            Bridge bridge = new Bridge(testBridge);
            this.bridgeGame = new BridgeGame(bridge, player);
        }

        @Test
        void playGame에서_정상적으로_불린값_리턴하는지_테스트() {
            String supposedToBeTrue = "U";
            assertThat(bridgeGame.playGame(supposedToBeTrue)).isEqualTo(true);
        }

        @Test
        void playGame에서_Player의_위치가_정상적으로_변하는지_테스트() {
            String correctPosition = "U";
            bridgeGame.playGame(correctPosition);
            assertThat(bridgeGame.getCurrentLocation()).isEqualTo(1);
        }

        @Test
        void playGame에서_정상적으로_불린값_리턴하는지_테스트2() {
            String supposedToBeFalse = "D";
            assertThat(bridgeGame.playGame(supposedToBeFalse)).isEqualTo(false);
        }

        @Test
        void 위치가_정상적으로_초기화_되고_시도_횟수가_늘어나는지_테스트() {
            String correctPosition = "U";
            bridgeGame.playGame(correctPosition);
            String correctPosition2 = "D";
            bridgeGame.playGame(correctPosition2);
            bridgeGame.retry("R");
            String correctPosition3 = "U";
            bridgeGame.playGame(correctPosition3);
            String correctPosition4 = "D";
            bridgeGame.playGame(correctPosition4);
            assertThat(bridgeGame.getCountOfTry()).isEqualTo(2);
        }

        @Test
        void 플레이어가_정답을_모두_맞췄을_때_true가_반환되는지_테스트() {
            String correctPosition = "U";
            bridgeGame.playGame(correctPosition);
            String correctPosition2 = "D";
            bridgeGame.playGame(correctPosition2);
            String correctPosition3 = "U";
            bridgeGame.playGame(correctPosition3);
            String correctPosition4 = "D";
            bridgeGame.playGame(correctPosition4);
            assertThat(bridgeGame.isUserReachedToEndOfTheBridge(4)).isEqualTo(true);
        }
    }


    @Nested
    class InputViewTest {
        InputView inputView;

        @BeforeEach
        void setUp() {
            inputView = new InputView();
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
                bridge.judgeAnswer("U", 0);
                bridge.judgeAnswer("D", 1);
                bridge.judgeAnswer("U", 2);
                bridge.judgeAnswer("D", 3);
            }

            @Test
            void printMapTest() {
                outputView.printMap(bridge);
            }
        }
    }
}
