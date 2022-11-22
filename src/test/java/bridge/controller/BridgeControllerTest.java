package bridge.controller;

import bridge.mock.MockObjectMaker;
import bridge.vo.Bridge;
import bridge.vo.GameResult;
import bridge.vo.StepResult;
import bridge.vo.enums.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeControllerTest {

    public static final String UP = Step.U.toString();
    public static final String DOWN = Step.D.toString();

    @Nested
    @DisplayName("주어진 다리를 이용해 다리 건너기 게임을 진행하는 doGame 메서드")
    class DoGameTest {
        @Test
        @DisplayName("주어진 다리를 이용해 다리 건너기 게임을 진행한 후 게임 결과를 반환한다.")
        void givenBridge_whenDoingGame_thenReturnsGameResult() {
            //given
            BridgeController bridgeController = MockObjectMaker.makeMockBridgeController(List.of(UP, DOWN, UP, UP));
            Bridge bridge = new Bridge(Step.from(List.of(UP, DOWN, UP, UP)));
            //when
            GameResult gameResult = bridgeController.doGame(bridge);
            //then
            assertThat(gameResult.getStepResults())
                    .containsExactly(
                            new StepResult(Step.U, true), new StepResult(Step.D, true),
                            new StepResult(Step.U, true), new StepResult(Step.U, true)
                    );
        }

        @Test
        @DisplayName("사용자가 잘못된 값을 입력하면 올바른 값을 입력할 때까지 다시 받는다.")
        void givenWrongInput_whenDoingGame_thenRepeatsAndReturnsGameResult() {
            //given
            BridgeController bridgeController = MockObjectMaker.makeMockBridgeController(List.of(UP, "ㅆ", DOWN, UP));
            Bridge bridge = new Bridge(Step.from(List.of(UP, DOWN, UP)));
            //when
            GameResult gameResult = bridgeController.doGame(bridge);
            //then
            assertThat(gameResult.getStepResults())
                    .containsExactly(
                            new StepResult(Step.U, true), new StepResult(Step.D, true),
                            new StepResult(Step.U, true)
                    );
        }
    }

    @Nested
    @DisplayName("사용자로부터 입력을 받아 다리를 만드는 makeBridge 메서드")
    class MakeBridgeTest {
        @Test
        @DisplayName("사용자가 입력한 다리 길이만큼의 다리를 생성한다.")
        void givenInput_whenMakingBridge_thenReturnsBridgeOfInputSize() {
            //given
            BridgeController bridgeController = MockObjectMaker.makeMockBridgeController(List.of("5"));

            //when
            Bridge bridge = bridgeController.makeBridge();

            //then
            assertThat(bridge.size()).isEqualTo(5);
        }

        @Test
        @DisplayName("사용자가 잘못된 값을 입력하면 올바른 값을 입력할 때까지 다시 받는다.")
        void givenWrongInput_whenMakingBridge_thenRepeatsAndReturnsBridgeOfInputSize() {
            //given
            BridgeController bridgeController = MockObjectMaker.makeMockBridgeController(List.of("2", "R", "S", "6"));

            //when
            Bridge bridge = bridgeController.makeBridge();

            //then
            assertThat(bridge.size()).isEqualTo(6);
        }
    }
}