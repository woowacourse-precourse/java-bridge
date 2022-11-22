package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class BridgeGameTest {
    @Test
    @DisplayName("이동할 수 있는 칸으로 이동할 경우 검증")
    void validatePossibleMove() {
        // Given
        BridgeGame bridgeGame = new BridgeGame(3, Arrays.asList("U", "D", "U"));

        // When
        boolean firstStep = bridgeGame.move("U", 0);
        boolean secondStep = bridgeGame.move("D", 1);
        boolean thirdStep = bridgeGame.move("U", 2);

        // Then
        assertThat(Arrays.asList(firstStep, secondStep, thirdStep))
                .isEqualTo(Arrays.asList(true, true, true));
    }

    @Test
    @DisplayName("이동할 수 없는 칸으로 이동할 경우 검증")
    void validateImpossibleMove() {
        // Given
        BridgeGame bridgeGame = new BridgeGame(3, Arrays.asList("U", "D", "U"));

        // When
        boolean firstStep = bridgeGame.move("D", 0);
        boolean secondStep = bridgeGame.move("U", 1);
        boolean thirdStep = bridgeGame.move("D", 2);

        // Then
        assertThat(Arrays.asList(firstStep, secondStep, thirdStep))
                .isEqualTo(Arrays.asList(false, false, false));
    }

    @Test
    @DisplayName("다리를 처음부터 끝까지 정확히 건넌 경우 결과 성공 검증")
    void isSuccessIfCrossedCorrectlyFromBeginningToEnd() {
        // Given
        BridgeGame bridgeGame = new BridgeGame(3, Arrays.asList("U", "D", "U"));

        // When
        boolean firstStep = bridgeGame.move("U", 0);
        boolean secondStep = bridgeGame.move("D", 1);
        boolean thirdStep = bridgeGame.move("U", 2);

        // Then
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
    }

    @Test
    @DisplayName("다리를 일부만 건넌 경우 결과 실패 검증")
    void isSuccess_NotEqualsStepCount_ReturnFalse() {
        // Given
        BridgeGame bridgeGame = new BridgeGame(3, Arrays.asList("U", "D", "U"));

        // When
        boolean firstStep = bridgeGame.move("U", 0);
        boolean secondStep = bridgeGame.move("D", 1);
        boolean thirdStep = bridgeGame.move("D", 2);

        // Then
        assertThat(bridgeGame.isSuccess()).isEqualTo(false);
    }

    @Test
    @DisplayName("게임 재시도할 경우 재시도 횟수 확인")
    void checkNumberOfTries() {
        // Given
        BridgeGame bridgeGame = new BridgeGame(3, Arrays.asList("U", "D", "D"));

        // When
        boolean firstStep = bridgeGame.move("U", 0);
        boolean secondStep = bridgeGame.move("D", 1);
        bridgeGame.retry();

        // Then
        assertThat(bridgeGame.getNumberOfTries()).isEqualTo(2);
    }
}
