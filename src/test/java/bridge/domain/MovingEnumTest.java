package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovingEnumTest {
    @DisplayName("U 입력 시 올바른 무빙값을 반환하는지 테스트")
    @Test
    void getMovingUTest() {
        // given
        String direction = "U";

        // when
        Moving movingDirection = Moving.getMoveDirection(direction);

        // then
        assertEquals(Moving.UP, movingDirection);
    }

    @DisplayName("D 입력 시 올바른 무빙값을 반환하는지 테스트")
    @Test
    void getMovingQTest() {
        // given
        String direction = "D";

        // when
        Moving movingDirection = Moving.getMoveDirection(direction);

        // then
        assertEquals(Moving.DOWN, movingDirection);
    }

    @DisplayName("잘못된 방향 입력 시 null 반환 테스트")
    @Test
    void getMovingWrongTest() {
        // given
        String direction = "a";

        // when
        Moving movingDirection = Moving.getMoveDirection(direction);

        // then
        assertNull(movingDirection);
    }

    @DisplayName("올바른 방향에 대한 Moving 이 있는지 여부를 확인하는 테스트")
    @Test
    void gameCommandContainsTest() {
        // given
        String commandU = "U";
        String commandD = "D";

        // when
        boolean isContainsU = Moving.contains(commandU);
        boolean isContainsD = Moving.contains(commandD);

        // then
        assertTrue(isContainsU);
        assertTrue(isContainsD);
    }

    @DisplayName("잘못된 방향에 대한 Moving 이 있는지 여부를 확인하는 테스트")
    @Test
    void gameCommandContainsWrongTest() {
        // given
        String commandU = "u";
        String commandD = "d";

        // when
        boolean isContainsU = Moving.contains(commandU);
        boolean isContainsD = Moving.contains(commandD);

        // then
        assertFalse(isContainsU);
        assertFalse(isContainsD);
    }
}
