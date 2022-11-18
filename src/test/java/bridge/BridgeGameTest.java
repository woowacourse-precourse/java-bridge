package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.UserRoadMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private UserRoadMap userRoadMap;
    private BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame(){
        userRoadMap = new UserRoadMap(List.of("U"));
        bridgeGame = new BridgeGame(userRoadMap);
    }

    @DisplayName("사용자가 칸을 이동한다.")
    @Test
    void testMove(){
        String direction = "U";
        assertSimpleTest(() -> {
            int originBridgeSize = userRoadMap.getSize();
           bridgeGame.move(direction);
           assertThat(userRoadMap.getSize())
                   .isEqualTo(originBridgeSize + 1);
        });
    }

    @DisplayName("사용자가 게임을 다시 시도한다.")
    @Test
    void testRetry(){
        assertSimpleTest(() -> {
            bridgeGame.retry();
            assertThat(userRoadMap.getSize())
                    .isEqualTo(0 );
        });
    }
}
