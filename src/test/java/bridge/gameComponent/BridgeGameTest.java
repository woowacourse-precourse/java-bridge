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
}
