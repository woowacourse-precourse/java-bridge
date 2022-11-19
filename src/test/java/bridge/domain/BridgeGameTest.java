package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @DisplayName("사용자가 입력한 명령에 따라 이동정보를 잘 등록하는 지 테스트")
    @ValueSource(strings = { "U", "D", "U", "D", "U" })
    @ParameterizedTest
    void moving_command_test(String command) {
        gameManager.move(command);
        commandStorage.add(command);

        assertThat(gameManager.getMovingStatus())
                .hasSize(commandStorage.size())
                .isInstanceOf(ArrayList.class)
                .isEqualTo(commandStorage);
    }
}
