package bridge;

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
        List<UpDown> collectUpDown = move.getGradingBoard()
                .stream()
                .map(v -> v.entrySet()
                        .stream()
                        .map(e -> e.getKey())
                        .collect(Collectors.toList())
                        .get(0))
                .collect(Collectors.toList());

        List<Boolean> collectIsCorrect = move.getGradingBoard()
                .stream()
                .map(v -> v.entrySet()
                        .stream()
                        .map(e -> e.getValue())
                        .collect(Collectors.toList())
                        .get(0))
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
        List<UpDown> collectUpDown = move.getGradingBoard()
                .stream()
                .map(v -> v.entrySet()
                        .stream()
                        .map(e -> e.getKey())
                        .collect(Collectors.toList())
                        .get(0))
                .collect(Collectors.toList());

        List<Boolean> collectIsCorrect = move.getGradingBoard()
                .stream()
                .map(v -> v.entrySet()
                        .stream()
                        .map(e -> e.getValue())
                        .collect(Collectors.toList())
                        .get(0))
                .collect(Collectors.toList());

        // then
        assertThat(collectUpDown).containsExactly(UpDown.DOWN);
        assertThat(collectIsCorrect).containsExactly(false);

    }
}
