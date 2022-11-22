package bridge.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerPathTest {

    static PlayerPath playerPath;

    @BeforeAll
    static void beforeAll() {
        playerPath = new PlayerPath();
        playerPath.nextStep(Tile.UP_TILE);
        playerPath.nextStep(Tile.DOWN_TILE);
        playerPath.nextStep(Tile.UP_TILE);
    }

    @DisplayName("다음칸으로 넘어가는 테스트")
    @Test
    void nextStepTest() {
        List<Tile> playerTiles = playerPath.getPlayerPath();
        assertThat(playerTiles)
                .containsExactly(Tile.UP_TILE, Tile.DOWN_TILE, Tile.UP_TILE);
    }

    @DisplayName("경로에서 현재 위치와 발판을 가져오는 테스트")
    @Test
    void currentPositionAndTileTest() {
        Tile currentTile = playerPath.currentTile();
        int currentPosition = playerPath.currentPosition();

        assertThat(currentTile).isEqualTo(Tile.UP_TILE);
        assertThat(currentPosition).isEqualTo(2);
    }
}
