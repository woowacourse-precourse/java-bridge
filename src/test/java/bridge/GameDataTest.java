package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameDataTest {

    private GameData gameData = new GameData();

    @DisplayName("게임 현황을 초기화하는 기능을 테스트한다.")
    @Test
    void refreshGameStatus() {
        gameData.clearStatus();
        assertThat(gameData.getTopStatus().size()).isEqualTo(0);
        assertThat(gameData.getBottomStatus().size()).isEqualTo(0);
    }

    @DisplayName("게임 재시작 횟수를 카운트한다.")
    @Test
    void checkRetryCount() {
        int retryCount = 10;
        for (int i = 1; i < retryCount; i++) {
            gameData.increaseTotalTry();
        }
        assertThat(gameData.getTotalTry()).isEqualTo(retryCount);
    }

    @DisplayName("이동 위치에 따라 게임 현황을 업데이트한다.")
    @ValueSource(strings = {"U"})
    @ParameterizedTest
    void updateGameStatus(String moving) {
        gameData.updateStatus(moving, "O");
        assertThat(gameData.getTopStatus()).isEqualTo(Arrays.asList("O"));
    }
}
