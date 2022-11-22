package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameProgressTest {

    private GameProgress gameProgress;

    @BeforeEach
    void setUp() {
        gameProgress = new GameProgress();
    }

    @DisplayName("게임 진행 초기 세팅 값이 정상적인지 확인")
    @Test
    void checkInitialValueOfGameProgress() {
        assertThat(gameProgress.isGameSuccess()).isFalse();
        assertThat(gameProgress.getTrialCount()).isEqualTo(1);
    }

    @DisplayName("게임 시도 횟수 증가 기능이 제대로 실행되는지 확인")
    @Test
    void checkUpdatingTrialCountWorksProperly() {
        gameProgress.updateTrialCount();
        gameProgress.updateTrialCount();

        assertThat(gameProgress.getTrialCount()).isEqualTo(3);
    }

    @DisplayName("게임 성공이 제대로 실행되는지 확인")
    @Test
    void checkGameVictoryWorksProperly() {
        gameProgress.victoryGame();

        assertThat(gameProgress.isGameSuccess()).isTrue();
    }
}
