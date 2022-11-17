package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrentBridgeTest {
    userStage userStage = new userStage();

    @BeforeEach
    void setUp() {
        userStage.savePosition(Stage.judge("U", "U"));
        userStage.savePosition(Stage.judge("D", "D"));
    }

    @DisplayName("맞히기만 경우 canNotCross()가 false 반환 테스트")
    @Test
    void success() {
        assertThat(userStage.isNotCross()).isFalse();
        assertThat(userStage.getSize()).isEqualTo(2);
    }

    @DisplayName("틀린 경우 canNotCross()가 True 반환 테스트")
    @Test
    void fail() {
        userStage.savePosition(Stage.judge("U", "D"));

        assertThat(userStage.isNotCross()).isTrue();
        assertThat(userStage.getSize()).isEqualTo(3);
        assertThat(userStage.getOutcome()).isEqualTo("실패");
    }

    @DisplayName("틀려서 초기화한 경우 사이즈와 시도 횟수를 확인하는 테스트")
    @Test
    void retry() {
        userStage.savePosition(Stage.judge("U", "D"));
        userStage.init();

        assertThat(userStage.getSize()).isEqualTo(0);
        assertThat(userStage.getNumberOfAttempts()).isEqualTo(2);

    }
}
