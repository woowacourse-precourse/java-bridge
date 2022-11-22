package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveStatusTest {

    @Test
    void 움직임_출력_테스트() {
        assertEquals(List.of(List.of(" X "),List.of("   ")),new MoveStatus().printMoves("U",false));
    }
}