package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame testGame = new BridgeGame(List.of("U","D","U"));
    @Test
    void 움직이는_방향_테스트() {
        MoveCheck moveCheck = new MoveCheck(List.of("U","D","U"));
        MoveStatus moveStatus = new MoveStatus();
        assertEquals(true,moveCheck.checkIfAvailableToMove(0,"U"));
        assertEquals(List.of(List.of(" O "),List.of("   ")), moveStatus.printMoves("U",moveCheck.checkIfAvailableToMove(0,"U")));
        assertEquals(false,moveCheck.checkIfAvailableToMove(1,"U"));
        assertEquals(List.of(List.of(" O "," X "),List.of("   ","   ")), moveStatus.printMoves("U",moveCheck.checkIfAvailableToMove(1,"U")));
    }

}