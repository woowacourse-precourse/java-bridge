package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    private final BridgeGame bridgeGame = ClassContext.getInstance().getBridgeGame();

    @DisplayName("move시 무브트레이스에 이동방향추가")
    @Test
    void move(){
        Bridge bridge = new Bridge(List.of());
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "D");
        assertThat(bridge.getMoveTrace().get(0)).isEqualTo("U");
        assertThat(bridge.getMoveTrace().get(1)).isEqualTo("D");
    }

    @DisplayName("무브트레이스와 브릿지쉐이프의sub가 equal이면true")
    @Test
    void isSurvive1(){
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.getMoveTrace().addAll(List.of("U", "D"));
        assertThat(bridgeGame.isSurvive(bridge)).isTrue();
    }

    @DisplayName("무브트레이스와 브릿지쉐이프의sub가 unequal이면false")
    @Test
    void isSurvive2(){
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.getMoveTrace().addAll(List.of("U", "U"));
        assertThat(bridgeGame.isSurvive(bridge)).isFalse();
    }

    @DisplayName("무브트레이스와 브릿지쉐이프가 사이즈도같고 equal이면true")
    @Test
    void isClearGame(){
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.getMoveTrace().addAll(List.of("U", "D", "U"));
        assertThat(bridgeGame.isClearGame(bridge)).isTrue();
    }

    @DisplayName("retry시 무브트레이스클리어 및 시도횟수1증가")
    @Test
    void retry() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridgeGame.move(bridge, "U");
        assertThat(bridge.getMoveTrace()).contains("U");
        assertThat(bridge.getAttemptNumber()).isEqualTo(0);
        bridgeGame.retry(bridge);

        assertThat(bridge.getMoveTrace()).isEmpty();
        assertThat(bridge.getAttemptNumber()).isEqualTo(1);
    }
}