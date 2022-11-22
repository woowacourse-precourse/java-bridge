package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameCommandEnumTest {

    @DisplayName("R 입력 시 올바른 게임 커맨드를 반환하는지 테스트")
    @Test
    void getGameCommandRTest() {
        // given
        String command = "R";

        // when
        GameCommand gameCommand = GameCommand.getGameCommand(command);

        // then
        assertEquals(GameCommand.RESTART, gameCommand);
    }

    @DisplayName("Q 입력 시 올바른 게임 커맨드를 반환하는지 테스트")
    @Test
    void getGameCommandQTest() {
        // given
        String command = "Q";
        
        // when
        GameCommand gameCommand = GameCommand.getGameCommand(command);

        // then
        assertEquals(GameCommand.QUIT, gameCommand);
    }

    @DisplayName("잘못된 커맨드 입력 시 null 반환 테스트")
    @Test
    void getGameCommandWrongTest() {
        // given
        String command = "a";

        // when
        GameCommand gameCommand = GameCommand.getGameCommand(command);

        // then
        assertNull(gameCommand);
    }

    @DisplayName("올바른 command 에 대한 GameCommand 가 있는지 여부를 확인하는 테스트")
    @Test
    void gameCommandContainsTest() {
        // given
        String commandR = "R";
        String commandQ = "Q";
        
        // when
        boolean isContainsR = GameCommand.contains(commandR);
        boolean isContainsQ = GameCommand.contains(commandQ);

        // then
        assertTrue(isContainsR);
        assertTrue(isContainsQ);
    }

    @DisplayName("잘못된 command 에 대한 GameCommand 가 있는지 여부를 확인하는 테스트")
    @Test
    void gameCommandContainsWrongTest() {
        // given
        String commandR = "r";
        String commandQ = "q";

        // when
        boolean isContainsR = GameCommand.contains(commandR);
        boolean isContainsQ = GameCommand.contains(commandQ);

        // then
        assertFalse(isContainsR);
        assertFalse(isContainsQ);
    }
}
