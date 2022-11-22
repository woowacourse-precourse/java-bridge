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
            bridgeGame.start(); // 게임 데이터 생성
            bridgeGame.resetGameData(); // 변수 설정
            Assertions.assertThatCode(() -> bridgeGame.move(moveCommend))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력한 재시작/종료 문자가 \"R\" 또는 \"Q\"가 아닌 경우")
    class gameCommendEqualNot_RorQ {
        @ParameterizedTest
        @CsvSource({
                "1", "!", "D", "U"
        })
        void test(String gameCommend) {
            Assertions.assertThatThrownBy(() -> bridgeGame.retry(gameCommend))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("입력한 재시작/종료 문자의 길이가 1이 아닌 경우")
    class notGameCommendLengthOne {
        @ParameterizedTest
        @CsvSource({
                "QQ", "QQQ", "RRRR"
        })
        void test(String gameCommend) {
            Assertions.assertThatThrownBy(() -> bridgeGame.retry(gameCommend))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("입력한 재시작/종료 문자가 \"Q\" 또는 \"R\"인 경우")
    class gameCommendEqual_QorR {
        @ParameterizedTest
        @CsvSource({
                "Q", "R"
        })
        void test(String gameCommend) {
            Assertions.assertThatCode(() -> bridgeGame.retry(gameCommend))
                    .doesNotThrowAnyException();
        }
    }
}
