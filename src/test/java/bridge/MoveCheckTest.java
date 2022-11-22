package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveCheckTest {

    @Test
    void 움직임_가능_확인_테스트() {
        MoveCheck testMoveCheck = new MoveCheck(List.of("U","D","U"));
        assertEquals(false,testMoveCheck.checkIfAvailableToMove(2,"D"));
        assertEquals(true,testMoveCheck.checkIfAvailableToMove(2,"U"));
    }
}