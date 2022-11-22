package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.Bridge;
import bridge.dto.BridgeMove.Request;
import bridge.dto.BridgeMove.Response;
import bridge.exception.ErrorCode;
import bridge.type.BridgeSpaceStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final BridgeGameInf bridgeGame = new BridgeGame();


    private Bridge bridge;

    @BeforeEach
    public void setUp() {
        final List<String> sequence = List.of("D", "D", "D", "D", "D", "D", "U", "U", "U", "U");
        bridge = new Bridge(sequence);
    }

    @Test
    public void moveIndexErrorFailure() {
        //given
        int index1 = -1;
        int index2 = 10;
        Request request1 = new Request(index1, 1, BridgeSpaceStatus.DOWN);
        Request request2 = new Request(index2, 1, BridgeSpaceStatus.DOWN);

        //when
        //then
        IllegalArgumentException exception1 = assertThrows(
            IllegalArgumentException.class,
            () -> bridgeGame.move(request1, bridge)
        );
        IllegalArgumentException exception2 = assertThrows(
            IllegalArgumentException.class,
            () -> bridgeGame.move(request2, bridge)
        );

        assertThat(exception1.getMessage()).isEqualTo(ErrorCode.INDEX_OUT_OF_BOUND.getMessage());
        assertThat(exception2.getMessage()).isEqualTo(ErrorCode.INDEX_OUT_OF_BOUND.getMessage());
    }

    @Test
    public void moveIsSuccess() {
        //given
        int index = 9;
        Request request = new Request(index, 1, BridgeSpaceStatus.UP);

        //when
        Response response = bridgeGame.move(request, bridge);

        //then
        assertThat(response.isSuccess()).isTrue();
        assertThat(response.isPossible()).isTrue();
        assertThat(response.getAttemptCount()).isEqualTo(request.getAttemptCount());
        assertThat(response.getIndex()).isEqualTo(request.getIndex());
    }

    @Test
    public void moveIsPossibleAndIsNotSuccess() {
        //given
        int index = 0;
        Request request = new Request(index, 1, BridgeSpaceStatus.DOWN);

        //when
        Response response = bridgeGame.move(request, bridge);

        //then
        assertThat(response.isSuccess()).isFalse();
        assertThat(response.isPossible()).isTrue();
        assertThat(response.getAttemptCount()).isEqualTo(request.getAttemptCount());
        assertThat(response.getIndex()).isEqualTo(request.getIndex() + 1);
    }

    @Test
    public void moveIsNotPossible() {
        //given
        int index = 1;
        Request request = new Request(index, 1, BridgeSpaceStatus.UP);

        //when
        Response response = bridgeGame.move(request, bridge);

        //then
        assertThat(response.isSuccess()).isFalse();
        assertThat(response.isPossible()).isFalse();
        assertThat(response.getAttemptCount()).isEqualTo(request.getAttemptCount());
        assertThat(response.getIndex()).isEqualTo(request.getIndex());
    }

    @Test
    public void retrySuccess() {
        //given
        int attemptCount = 1;
        Request request = new Request(0, attemptCount, BridgeSpaceStatus.UP);

        //when
        Response response = bridgeGame.retry(request);

        //then
        assertThat(response.getAttemptCount()).isEqualTo(attemptCount + 1);
    }
}