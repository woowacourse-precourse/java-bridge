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

    @Test
    void 성공적으로_위로_이동후_아래_없는_경로로_이동하면_지도의_위에_O_아래에_X가_그려져야한다() {
        GameMap gameMap = new GameMap();
        gameMap.draw(new MoveResult(DrawType.SUCCESS, Direction.U));
        gameMap.draw(new MoveResult(DrawType.FAIL, Direction.D));
        assertThat(gameMap.toString()).isEqualTo("[ O |   ]\n[   | X ]");
    }

    @Test
    void 재시작하면_지도가_초기화되어야_한다() {
        GameMap gameMap = new GameMap();
        gameMap.draw(new MoveResult(DrawType.SUCCESS, Direction.U));
        gameMap.draw(new MoveResult(DrawType.FAIL, Direction.D));
        gameMap.initialize();
        assertThat(gameMap.toString()).isEqualTo("[  ]\n[  ]");
    }
}