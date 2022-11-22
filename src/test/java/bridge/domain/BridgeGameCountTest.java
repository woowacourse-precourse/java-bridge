package bridge.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameCountTest {
    private static BridgeGameCount bridgeGameCount;

    @BeforeEach
    void setUp(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            bridgeGameCount = new BridgeGameCount(0);
        }
    }

    @DisplayName("게임 시도 횟수를 증가한다")
    @RepeatedTest(name = "{displayName} ({currentRepetition} / {totalRepetitions})", value = 5)
    void increaseBridgeGameCount5(RepetitionInfo repetitionInfo) {
        bridgeGameCount.increaseCount();
        assertThat(bridgeGameCount.getCount()).isEqualTo(repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("게임 시도 횟수를 증가한다")
    @RepeatedTest(name = "{displayName} ({currentRepetition} / {totalRepetitions})", value = 10)
    void increaseBridgeGameCount10(RepetitionInfo repetitionInfo) {
        bridgeGameCount.increaseCount();
        assertThat(bridgeGameCount.getCount()).isEqualTo(repetitionInfo.getCurrentRepetition());
    }
}
