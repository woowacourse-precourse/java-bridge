package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class userStageTest {
    userStages userStages = new userStages();

    @BeforeEach
    void setUp() {
        userStages.savePosition(Stage.judge("U", "U"));
        userStages.savePosition(Stage.judge("D", "D"));
    }

    @DisplayName("맞히기만 경우 canNotCross()가 false 반환 테스트")
    @Test
    void success() {
        assertThat(userStages.isNotCross()).isFalse();
        assertThat(userStages.nextIndex()).isEqualTo(2);
    }

    @DisplayName("틀린 경우 canNotCross()가 True 반환 테스트")
    @Test
    void fail() {
        userStages.savePosition(Stage.judge("U", "D"));

        assertThat(userStages.isNotCross()).isTrue();
        assertThat(userStages.nextIndex()).isEqualTo(3);
        assertThat(userStages.getOutcome()).isEqualTo("실패");
    }

    @DisplayName("틀려서 초기화한 경우 사이즈와 시도 횟수를 확인하는 테스트")
    @Test
    void retry() {
        userStages.savePosition(Stage.judge("U", "D"));
        userStages.init();

        assertThat(userStages.nextIndex()).isEqualTo(0);
        assertThat(userStages.getNumberOfAttempts()).isEqualTo(2);

    }
}
