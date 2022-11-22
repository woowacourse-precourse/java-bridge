package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private CurrentBridgeState currentBridgeState;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
        currentBridgeState = new CurrentBridgeState();
    }

    @ParameterizedTest
    @DisplayName("플레이어가 다리 이동이 가능한지 확인하는 기능 테스트")
    @CsvSource(value = {"D , true", "U , false"})
    void isPossibleMove(String moveCommand, boolean expected) {

        List<String> bridge = List.of("U", "D", "U");
        int turn = 1;

        boolean result = bridgeGame.isPossibleMove(bridge, moveCommand, turn);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("판단한 결과값으로 이동 결과를 리턴하는 메서드 테스트")
    @CsvSource(value = {"U, true", "U, false", "D, true", "D, false"})
    void moveTest(String moveCommand, boolean isPossibleMove) {

        currentBridgeState.recordBridgeMove(moveCommand, isPossibleMove);

        CurrentBridgeState expectedCurrentBridgeState = new CurrentBridgeState();

        List<String> expectedUpBridgeResult = null;
        List<String> expectedDownBridgeResult = null;
        if (moveCommand.equals("U")) {
            if (isPossibleMove == true) {
                expectedUpBridgeResult = List.of("O");
                expectedDownBridgeResult = List.of(" ");
            } else if (isPossibleMove == false) {
                expectedUpBridgeResult = List.of("X");
                expectedDownBridgeResult = List.of(" ");
            }
        } else if (moveCommand.equals("D")) {
            if (isPossibleMove == true) {
                expectedUpBridgeResult = List.of(" ");
                expectedDownBridgeResult = List.of("O");
            } else if (isPossibleMove == false) {
                expectedUpBridgeResult = List.of(" ");
                expectedDownBridgeResult = List.of("X");
            }
        }

        assertThat(currentBridgeState.getUpBridgeState()).isEqualTo(expectedUpBridgeResult);
        assertThat(currentBridgeState.getDownBridgeState()).isEqualTo(expectedDownBridgeResult);
    }
}