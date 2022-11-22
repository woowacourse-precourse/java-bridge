package domain;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(3);
        this.bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("게임 최초 시작 및 재시작 시 실행 횟수가 올바르게 카운트되는지 확인한다.")
    @Test
    void 실행횟수_테스트() {
        List<Integer> testAttemptCounts = new ArrayList<>();
        List<Integer> correctAttemptCounts = new ArrayList<>(Arrays.asList(0, 1, 2, 3) );

        testAttemptCounts.add(bridgeGame.attemptCount); // 최초 실행 시 실행 횟수 저장
        for (int i=0; i<3; i++) { // 재시작 3회 시행
            bridgeGame.retry();
            testAttemptCounts.add(bridgeGame.attemptCount);
        }

        assertThat(testAttemptCounts.equals(correctAttemptCounts));
    }
}
