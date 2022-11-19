package bridge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @Nested
    @DisplayName("입력한 이동할 칸의 문자의 길이가 1이 아니면 예외를 던짐")
    class notMoveCommendLengthOneTest {
        @ParameterizedTest
        @CsvSource({
                "DD", "UDD", "DDUU"
        })
        void test(String moveCommend) {
            Assertions.assertThatThrownBy(() -> bridgeGame.move(moveCommend))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("입력한 이동할 칸의 문자가 \"D\" 또는 \"U\"가 아님")
    class moveCommendNotEqual_DorE {
        @ParameterizedTest
        @CsvSource({
                "Q", "0", "!"
        })
        void test(String moveCommend) {
            Assertions.assertThatThrownBy(() -> bridgeGame.move(moveCommend))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("입력한 이동할 칸의 문자가 \"D\" 또는 \"U\"인 경우")
    class moveCommendEqual_DorE {
        @ParameterizedTest
        @CsvSource({
                "D", "U"
        })
        void test(String moveCommend) {
            Assertions.assertThatCode(() -> bridgeGame.move(moveCommend))
                    .doesNotThrowAnyException();
        }
    }
}
