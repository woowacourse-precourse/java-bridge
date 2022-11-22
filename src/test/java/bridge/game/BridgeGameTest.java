package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import bridge.domain.Direction;
import bridge.exception.FailException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    static final String U = "U";
    static final String D = "D";
    static final int brideSize = 3;
    static final Direction UP = Direction.UP;
    static final Direction DOWN = Direction.DOWN;

    BridgeGame bridgeGame;
    List<String> mockBridge;
    GameStatus gameStatus;

    @BeforeEach
    void setUp() {
        mockBridge = mock(List.class);
        given(mockBridge.size()).willReturn(brideSize);

        gameStatus = mock(GameStatus.class);

        bridgeGame = spy(new BridgeGame(mockBridge, gameStatus));
    }

    @DisplayName("입력에 따른 다리 건너기")
    @Test
    void testMove() {
        given(mockBridge.get(anyInt())).willReturn(U);
        willDoNothing().given(gameStatus).move(any(Direction.class));

        bridgeGame.move(UP);

        assertThat(bridgeGame).extracting("bridge")
                              .extracting("location").isEqualTo(1);

        then(mockBridge).should(times(1)).get(anyInt());
        then(gameStatus).should(times(1)).move(UP);
    }

    @DisplayName("입력에 따른 다리 건너기 실패")
    @Test
    void testMoveFail() {
        given(mockBridge.get(anyInt())).willReturn(D);
        willDoNothing().given(gameStatus).move(any(Direction.class));

        assertThatThrownBy(() -> bridgeGame.move(UP))
            .isInstanceOf(FailException.class);

        then(mockBridge).should(times(1)).get(anyInt());
        then(gameStatus).should(times(1)).makeFail(UP);
    }

    @DisplayName("재시작")
    @Test
    void testRetry() {
        willDoNothing().given(gameStatus).move(any(Direction.class));

        bridgeGame.restart();

        assertThat(bridgeGame).extracting("bridge")
                              .extracting("location").isEqualTo(0);
        then(gameStatus).should(times(1)).restart();
    }

}
