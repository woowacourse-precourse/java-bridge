package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
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
        List<String> expected = null;
        if (moveCommand.equals("U")) {
            if (isPossibleMove == true) {
                expected = List.of("O", " ");
            } else if (isPossibleMove == false) {
                expected = List.of("X", " ");
            }
        } else if (moveCommand.equals("D")) {
            if (isPossibleMove == true) {
                expected = List.of(" ", "O");
            } else if (isPossibleMove == false) {
                expected = List.of(" ", "X");
            }
        }

        List<String> result = bridgeGame.move(moveCommand, isPossibleMove);

        assertThat(result).isEqualTo(expected);
    }
}