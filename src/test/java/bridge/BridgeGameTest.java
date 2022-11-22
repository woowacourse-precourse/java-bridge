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
}
