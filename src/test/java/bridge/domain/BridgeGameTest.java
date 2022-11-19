package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameTest {
    private static BridgeGame gameManager;
    private static List<String> commandStorage;

    @DisplayName("BridgeGame 클래스의 인스턴스와 명렁어 저장 리스트 생성")
    @BeforeAll
    static void get_bridge_game_instance() {
        gameManager = BridgeGame.getInstance();
        commandStorage = new ArrayList<>();
    }

    @DisplayName("현재의 이동명령이 이동가능한 경우 True를 반환하는지 테스트")
    @Test
    void isMovalble_test() {
        List<String> bridgeStatus = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        gameManager.setBridgeStatus(bridgeStatus);

        assertThat(gameManager.move("U"))
                .isTrue();
    }

    @DisplayName("현재의 이동명령이 불가한 경우 False를 반환하는 지 테스트")
    @Test
    void isNotMovable_test() {
        List<String> bridgeStatus = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        gameManager.setBridgeStatus(bridgeStatus);

        assertThat(gameManager.move("U"))
                .isFalse();
    }
}
