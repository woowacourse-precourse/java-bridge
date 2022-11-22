package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TileTest {

    @DisplayName("랜덤 넘버(0, 1)로 놓을 다리 Tile 찾는 테스트")
    @Test
    void randomTileTest() {
        Tile zeroTile = Tile.findByRandomNumber(0);
        Tile oneTile = Tile.findByRandomNumber(1);

        assertThat(zeroTile).isEqualTo(Tile.DOWN_TILE);
        assertThat(oneTile).isEqualTo(Tile.UP_TILE);
    }

    @DisplayName("입력한 U, D 통해서 Tile 찾는 테스트")
    @Test
    void inputTileTest() {
        Tile upTile = Tile.findBySymbol("U");
        Tile downTile = Tile.findBySymbol("D");

        assertThat(downTile).isEqualTo(Tile.DOWN_TILE);
        assertThat(upTile).isEqualTo(Tile.UP_TILE);
    }
}
