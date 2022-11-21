package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BridgeGameTest {
    private static BridgeGame gameManager;

    @DisplayName("BridgeGame 클래스의 인스턴스 생성")
    @BeforeAll
    static void get_bridge_game_instance() {
        gameManager = BridgeGame.getInstance();
    }

    @DisplayName("현재의 이동명령이 이동가능한 경우 True를 반환하는지 테스트")
    @Test
    @Order(1)
    void isMovalble_test() {
        List<String> bridgeStatus = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        gameManager.setBridgeStatus(bridgeStatus);

        assertThat(gameManager.move("U"))
                .isTrue();
    }

    @DisplayName("현재의 이동명령이 불가한 경우 False를 반환하는 지 테스트")
    @Test
    @Order(2)
    @Disabled
    void isNotMovable_test() {
        List<String> bridgeStatus = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        gameManager.setBridgeStatus(bridgeStatus);

        assertThat(gameManager.move("U"))
                .isFalse();
    }

    @DisplayName("게임을 다시 시도하는 기능에 대한 테스트")
    @Test
    @Order(3)
    void retry_test() {
        int beforeCount = gameManager.getAttemptsCount();
        gameManager.retry();

        assertThat(gameManager.getAttemptsCount())
                .isEqualTo(beforeCount+1);
        assertThat(gameManager.getMovingStatus())
                .hasSize(0);
    }

    @DisplayName("게임을 성공한 경우 제대로 판정하는 지 테스트")
    @Test
    @Order(4)
    void game_success_judgement_test() {
        gameManager.retry();
        List<String> bridgeStatus = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        gameManager.setBridgeStatus(bridgeStatus);
        List<String> commands = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        for(String command : commands) {
            gameManager.move(command);
        }

        assertThat(gameManager.isGameSuccess())
                .isTrue();
        gameManager.retry();
    }

    @DisplayName("게임을 실패한 경우 제대로 판정하는 지 테스트")
    @Test
    @Order(5)
    void game_failed_judgement_test() {
        gameManager.retry();
        List<String> bridgeStatus = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        gameManager.setBridgeStatus(bridgeStatus);
        List<String> commands = new ArrayList<>(List.of("U", "D", "U", "U", "U"));
        for(String command : commands) {
            gameManager.move(command);
        }

        assertThat(gameManager.isGameSuccess())
                .isFalse();
        gameManager.retry();
    }
}
