package bridge.system.util;

import bridge.vo.Step;
import bridge.vo.StepResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMessageMakerTest {
    private final BridgeMessageMaker bridgeMessageMaker = new BridgeMessageMaker();

    @Nested
    @DisplayName("주어진 이동 결과를 바탕으로 실행 결과 메시지를 만드는 makeBridgeMessage 메서드 테스트")
    class makeBridgeMessageTest {
        @Test
        @DisplayName("주어진 이동 결과를 바탕으로 실행 결과 메시지를 출력할 수 있다.")
        void givenStepResults_whenMakingBridgeMessage_thenReturnsMessage() {
            //given && when
            String resultMessage = makeBridgeMessage(List.of(
                    new StepResult(Step.D, true),
                    new StepResult(Step.U, true),
                    new StepResult(Step.U, false)
            ));

            //then
            Assertions.assertThat(resultMessage)
                    .isEqualTo("[   | O | X ]" + System.lineSeparator() + "[ O |   |   ]");
        }

        @Test
        @DisplayName("한 쪽에만 치우친 이동 결과가 나올 수 있다,")
        void givenStepResultsOnlyU_whenMakingBridgeMessage_thenReturnsMessage() {
            //given && when
            String resultMessage = makeBridgeMessage(List.of(
                    new StepResult(Step.U, true),
                    new StepResult(Step.U, true),
                    new StepResult(Step.U, false)
            ));

            //then
            Assertions.assertThat(resultMessage)
                    .isEqualTo("[ O | O | X ]" + System.lineSeparator() + "[   |   |   ]");
        }

        @Test
        @DisplayName("중간에 X가 나올 수 있다. 해당 클래스에서는 이동 실패한 결과가 있어도 중간에 중단하지 않는다.")
        void givenStepResultsFailingInMiddle_whenMakingBridgeMessage_thenReturnsMessage() {
            //given && when
            String resultMessage = makeBridgeMessage(List.of(
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, false),
                    new StepResult(Step.D, true)
            ));

            //then
            Assertions.assertThat(resultMessage)
                    .isEqualTo("[ O |   |   ]" + System.lineSeparator() + "[   | X | O ]");
        }
    }

    private String makeBridgeMessage(List<StepResult> stepResults) {
        return bridgeMessageMaker.makeBridgeMessage(stepResults);
    }
}