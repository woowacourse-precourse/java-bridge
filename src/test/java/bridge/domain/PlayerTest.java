package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        List<String> map = new ArrayList<>();
        int gameAttempts = 1;
        player = new Player(map, gameAttempts);
    }

    @Test
    void 이동_테스트() {
        String movingResult = "O";
        player.move(movingResult);

        String lastMovedResult = player.getLastMovedResult();
        assertThat(lastMovedResult).isEqualTo(movingResult);
    }

    @Test
    void 재시작_연산_테스트() {
        player.move("O");
        player.move("X");

        player.retry();

        int gameAttempts = player.getGameAttempts();
        String lastMovedResult = player.getLastMovedResult();
        assertThat(gameAttempts).isEqualTo(2);
        assertThat(lastMovedResult).isEqualTo("O");
    }

    @Test
    void 이동할_다리의_위치_반환() {
        int movingPosition;

        movingPosition = player.getMovingPosition();
        assertThat(movingPosition).isEqualTo(0);

        player.move("O");
        movingPosition = player.getMovingPosition();
        assertThat(movingPosition).isEqualTo(1);
    }

    @Test
    void 다리의_위치를_받아_해당_위치에서_이동했던_기록_반환_테스트() {
        String movedShape;

        player.move("O");
        player.move("X");

        movedShape = player.getMovedResultByPosition(0);
        assertThat(movedShape).isEqualTo("O");

        movedShape = player.getMovedResultByPosition(1);
        assertThat(movedShape).isEqualTo("X");
    }
}