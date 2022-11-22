package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.type.GameStatusType;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private List<String> bridgeInfo;
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUP() {
        bridgeInfo = new Bridge(List.of("U","U","D","D","U")).getBridge();
        bridgeGame = new BridgeGame(bridgeInfo);
    }

    @DisplayName("방향을 맞추지 못했을때 게임 상태는 실패로 변경되야 한다.")
    @Test
    void bridgeGameMoveTest() {
        bridgeGame.move("D");

        assertThat(bridgeGame.getGameStatus())
                .isEqualTo(GameStatusType.FAIL);
    }
}
