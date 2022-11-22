package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = createBridgeGame(List.of("U", "D", "U", "D"));
    }

    @DisplayName("게임 상태가 진행 중일 때 - PROGRESSION 반환")
    @Test
    void givenBridgeGame_whenMove_thenReturnProgressProgression() {
        //Given

        //When
        Progress progress = bridgeGame.move("U");


        //Then
        assertThat(progress).isEqualTo(Progress.PROGRESSION);
    }

    @DisplayName("게임 상태가 진행 중 마지막 정답을 맞췄을 때 - SUCCESS 반환")
    @Test
    void givenBridgeGame_whenMove_thenReturnProgressSuccess() {
        //Given
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        //When
        Progress progress = bridgeGame.move("D");

        //Then
        assertThat(progress).isEqualTo(Progress.SUCCESS);
    }

    @DisplayName("게임 상태가 진행 중일 때 잘못된 길 선택 - FAILURE 반환")
    @Test
    void givenBridgeGame_whenMove_thenReturnProgressFailure() {
        //Given

        //When
        Progress progress = bridgeGame.move("D");

        //Then
        assertThat(progress).isEqualTo(Progress.FAILURE);
    }

    private BridgeGame createBridgeGame(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initBridge(bridge);
        return bridgeGame;
    }

}
