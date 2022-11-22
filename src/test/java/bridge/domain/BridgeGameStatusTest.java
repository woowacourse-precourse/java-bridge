package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameStatusTest {

    @DisplayName("현재 게임을 성공적으로 종료할 수 있는지 확인한다")
    @Test
    void isGameSuccessfulEndTest() {
        // given
        List<String> playerMove = List.of("U", "U", "D", "U"); 
        List<String> gameBridge = List.of("U", "U", "D", "U");
        int runCount = 3;

        // when
        BridgeGameStatus bridgeGameStatus = new BridgeGameStatus(playerMove, gameBridge, runCount);
        boolean isSuccessfulEnd = bridgeGameStatus.isGameSuccessfulEnd();
        
        // then
        assertTrue(isSuccessfulEnd);
    }

    @DisplayName("현재 게임을 종료하려면 유저의 올바른 입력이 더 필요하다")
    @Test
    void isNotGameEndTest1() {
        // given
        List<String> playerMove = List.of("U", "U");
        List<String> gameBridge = List.of("U", "U", "D", "U");
        int runCount = 2;

        // when
        BridgeGameStatus bridgeGameStatus = new BridgeGameStatus(playerMove, gameBridge, runCount);
        boolean isSuccessfulEnd = bridgeGameStatus.isGameSuccessfulEnd();

        // then
        assertFalse(isSuccessfulEnd);
    }

    @DisplayName("입력은 완료되었지만 입력이 틀린 경우")
    @Test
    void isNotGameEndTest2() {
        // given
        List<String> playerMove = List.of("U", "U", "D", "D");
        List<String> gameBridge = List.of("U", "U", "D", "U");
        int runCount = 1;

        // when
        BridgeGameStatus bridgeGameStatus = new BridgeGameStatus(playerMove, gameBridge, runCount);
        boolean isSuccessfulEnd = bridgeGameStatus.isGameSuccessfulEnd();

        // then
        assertFalse(isSuccessfulEnd);
    }

    @DisplayName("현재 게임 상태가 올바르게 출력되는지 테스트")
    @Test
    void bridgeGameStatusToStringTest1() {
        // given
        List<String> playerMove = List.of("U", "U");
        List<String> gameBridge = List.of("U", "U", "D", "U");
        int runCount = 1;

        // when
        BridgeGameStatus bridgeGameStatus = new BridgeGameStatus(playerMove, gameBridge, runCount);
        String status = bridgeGameStatus.toString();

        // then
        boolean contains = status.contains("[ O | O ]\n[   |   ]");
        assertTrue(contains);
    }

    @DisplayName("현재 게임 상태가 올바르게 출력되는지 테스트 (마지막 입력이 틀린 경우 X 표시)")
    @Test
    void bridgeGameStatusToStringTest2() {
        // given
        List<String> playerMove = List.of("U", "U", "U");
        List<String> gameBridge = List.of("U", "U", "D", "U");
        int runCount = 1;

        // when
        BridgeGameStatus bridgeGameStatus = new BridgeGameStatus(playerMove, gameBridge, runCount);
        String status = bridgeGameStatus.toString();

        // then
        boolean contains = status.contains("[ O | O | X ]\n[   |   |   ]");
        assertTrue(contains);
    }
}
