package bridge.gameComponent;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class BridgeGameTest {
    @Test
    void 브릿지게임_생성_Null입력_테스트() {
        //given
        Bridge bridge = null;
        //when
        Throwable throwable = catchThrowable(() -> {
            new BridgeGame(bridge);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 브릿지게임_정상_생성() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D"));
        //when
        BridgeGame bridgeGame = new BridgeGame(bridge);
        //then
        assertThat(bridgeGame.getEndIndex())
                .isEqualTo(1);
    }
    @Test
    void move테스트_다리길이를_초과한_경우() {
        //given
        Bridge bridge = Bridge.of(List.of("U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        //when
        Throwable throwable = catchThrowable(() -> {
            bridgeGame.move();
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    void 정상_move테스트() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        //when
        bridgeGame.move();
        //then
        assertThat(bridgeGame.getIndex())
                .isEqualTo(1);
    }
}
