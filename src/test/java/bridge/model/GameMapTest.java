package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameMapTest {
    @Test
    void 위로_두번_성공적으로_이동했을_경우_지도의_위에_O가_두개_그려져야한다() {
        GameMap gameMap = new GameMap();
        for (int move = 0; move < 2; move++) {
            gameMap.draw(new MoveResult(DrawType.SUCCESS, Direction.U));
        }
        assertThat(gameMap.toString()).isEqualTo("[ O | O ]\n[   |   ]");
    }
}