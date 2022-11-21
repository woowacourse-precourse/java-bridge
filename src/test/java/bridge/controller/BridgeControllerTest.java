package bridge.controller;

import bridge.mock.MockInputView;
import bridge.service.BridgeGame;
import bridge.system.util.BridgeMessageMaker;
import bridge.view.outputview.OutputView;
import bridge.vo.Bridge;
import bridge.vo.GameResult;
import bridge.vo.enums.Step;
import bridge.vo.StepResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeControllerTest {
    public static final String UP = Step.U.toString();
    public static final String DOWN = Step.D.toString();

    private final BridgeController bridgeController = new BridgeController(
            new OutputView(new BridgeMessageMaker()),
            new MockInputView(List.of(UP, DOWN, UP, UP)),
            new BridgeGame()
    );

    @Nested
    @DisplayName("주어진 다리를 이용해 다리 건너기 게임을 진행하는 doGame 메서드")
    class DoGameTest {
        @Test
        @DisplayName("주어진 다리를 이용해 다리 건너기 게임을 진행한 후 게임 결과를 반환한다.")
        void givenBridge_whenDoingGame_thenReturnsGameResult() {
            //given
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
    }
}