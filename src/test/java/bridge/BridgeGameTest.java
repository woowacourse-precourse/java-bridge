package bridge;

import bridge.bridgeGame.BridgeGame;
import bridge.bridgeGame.BridgeGameResultDto;
import bridge.bridgeGame.StepStatus;
import bridge.enums.UpDown;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    @DisplayName("사용자가 칸을 이동할 때 정확하게 점수가 집계됐는지 확인")
    @Test
    void 칸_이동_테스트_성공() {
        // given
        BridgeGame bridgeGame = new BridgeGame(newArrayList("U","D","U","U","D"));

        // when
        String nextStep = "U";
        BridgeGameResultDto move = bridgeGame.move(nextStep);
        List<UpDown> collectUpDown = move.getGradingBoard().stream()
                .map(v -> v.getUpDown())
                .collect(Collectors.toList());

        List<Boolean> collectIsCorrect = move.getGradingBoard().stream()
                .map(v -> v.isCorrect())
                .collect(Collectors.toList());


        // then
        assertThat(collectUpDown).containsExactly(UpDown.UP);
        assertThat(collectIsCorrect).containsExactly(true);
    }

    @DisplayName("사용자가 칸을 이동할 때 잘못 디뎠을 경우 확인")
    @Test
    void 칸_이동_테스트_실패() {
        // given
        BridgeGame bridgeGame = new BridgeGame(newArrayList("U","D","U","U","D"));

        // when
        String nextStep = "D";
        BridgeGameResultDto move = bridgeGame.move(nextStep);
        List<UpDown> collectUpDown = move.getGradingBoard().stream()
                .map(v -> v.getUpDown())
                .collect(Collectors.toList());

        List<Boolean> collectIsCorrect = move.getGradingBoard().stream()
                .map(v -> v.isCorrect())
                .collect(Collectors.toList());

        // then
        assertThat(collectUpDown).containsExactly(UpDown.DOWN);
        assertThat(collectIsCorrect).containsExactly(false);
    }

    @DisplayName("재시작 했을 경우 시도횟수가 리셋되는지 확인")
    @Test
    void 재시작_시도횟수_테스트() {
        // given
        BridgeGame bridgeGame = new BridgeGame(newArrayList("U","D","U","U","D"));

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");
        BridgeGameResultDto beforeRetry = bridgeGame.move("U");

        bridgeGame.retry();
        BridgeGameResultDto afterRetry = bridgeGame.move("U");

        // then
        assertThat(beforeRetry.getTotalAttemptNum()).isEqualTo(1);
        assertThat(afterRetry.getTotalAttemptNum()).isEqualTo(2);
    }

    @DisplayName("재시작 했을 경우 점수판(gradingBoard) 리셋되는지 확인")
    @Test
    void 재시작_점수판_테스트() {
        // given
        BridgeGame bridgeGame = new BridgeGame(newArrayList("U","D","U","U","D"));

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");

        bridgeGame.retry();
        BridgeGameResultDto afterRetry = bridgeGame.move("U");

        List<UpDown> collectUpDown = afterRetry.getGradingBoard().stream()
                .map(v -> v.getUpDown())
                .collect(Collectors.toList());

        List<Boolean> collectIsCorrect = afterRetry.getGradingBoard().stream()
                .map(v -> v.isCorrect())
                .collect(Collectors.toList());

        // then
        assertThat(collectUpDown).containsExactly(UpDown.UP);
        assertThat(collectIsCorrect).containsExactly(true);
    }


}
