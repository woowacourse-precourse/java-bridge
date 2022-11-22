package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("PlayerBoard 멤버 메서드 테스트")
@TestMethodOrder(OrderAnnotation.class)
class PlayerBoardTest {
    private static final int BRIDGE_SIZE = 3;
    private PlayerBoard playerBoard;

    @BeforeEach
    void setUp() {
        playerBoard = new PlayerBoard(BRIDGE_SIZE);
    }

    @Order(3)
    @DisplayName("isOver 메서드 통과 테스트")
    @Test
    void isPass() {
        for (int i = 0; i < BRIDGE_SIZE - 1; i++) {
            playerBoard.addResultOfBridge("U", "O");
            assertThat(playerBoard.isOver()).isFalse();
        }
        playerBoard.addResultOfBridge("U", "O");
        assertThat(playerBoard.isOver()).isTrue();
    }

    @Order(2)
    @DisplayName("getGameRound 메서드 값 반환 테스트")
    @Test
    void getGameRound() {
        playerBoard.addResultOfBridge("U", "O");
        playerBoard.addResultOfBridge("D", "O");
        assertThat(playerBoard.getGameRound()).isEqualTo(2);
    }

    @Order(1)
    @DisplayName("addResultOfBridge 예외 미발생 여부 테스트")
    @Test
    void addResultOfBridge() {
        assertThatCode(() -> playerBoard.addResultOfBridge("U", "O")).doesNotThrowAnyException();
    }

    @Order(4)
    @DisplayName("getBridgeStatus 메서드 값 반환 테스트")
    @Test
    void testToString() {
        playerBoard.addResultOfBridge("U", "O");
        playerBoard.addResultOfBridge("D", "O");
        String correctUpBridge = "[ O |   ]\n";
        String correctDownBridge = "[   | O ]\n";
        assertThat(playerBoard.getBridgeStatus("U")).isEqualTo(correctUpBridge);
        assertThat(playerBoard.getBridgeStatus("D")).isEqualTo(correctDownBridge);
    }
}