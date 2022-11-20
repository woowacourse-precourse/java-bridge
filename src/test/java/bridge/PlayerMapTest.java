package bridge;

import bridge.data.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.data.GameMark.BLANK;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerMapTest {
    private final int bridgeSize = 6;
    private PlayerMap playerMap;
    Direction direction;
    int position;
    String mark;

    @BeforeEach
    void setUp() {
        playerMap = new PlayerMap(bridgeSize);
        direction = Direction.UP_DIRECTION;
        position = 0;
        mark = "O";
    }

    @DisplayName("특정 위치로 이동한다.")
    @Test
    void moveTest() {
        playerMap.move(direction, position, mark);
        assertTrue(playerMap.getMark(direction.getDirection(), position).equals(mark));
    }

    @DisplayName("현재 위치 이동을 초기화하면 빈 칸이 된다.")
    @Test
    void resetPrevTest() {
        playerMap.move(direction, position, mark);
        playerMap.resetPrev(position);
        assertTrue(playerMap.getMark(direction.getDirection(), position).equals(BLANK.getMark()));
    }
}
