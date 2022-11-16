package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameDataTest {

    private GameData gameData = new GameData();

    @DisplayName("게임 현황을 초기화하는 기능을 테스트한다.")
    @Test
    void refreshGameStatus() {
        gameData.clearStatus();
        assertThat(gameData.getTopStatus()).isEqualTo(List.of("[", "]"));
        assertThat(gameData.getBottomStatus()).isEqualTo(List.of("[", "]"));
    }
}
