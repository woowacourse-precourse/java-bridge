package bridge;

import bridge.valid.ValidateBridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BridgeGameTest extends NsTest {
    @Override
    protected void runMain() {
    }


    @DisplayName("입력받은 다리가 정상값으로 들어올 경우")
    @ParameterizedTest
    @MethodSource("inputSuccessBridge")
    public void success(List<String> value) {
        assertThat(new ValidateBridgeGame().validate(value))
                .isEqualTo(value);
    }

    static Stream<Arguments> inputSuccessBridge() {
        return Stream.of(
                Arguments.arguments(Arrays.asList("U", "D", "U", "D")),
                Arguments.arguments(Arrays.asList("D", "D", "D", "D")),
                Arguments.arguments(Arrays.asList("U", "D", "D")),
                Arguments.arguments(Arrays.asList("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"))
        );
    }


    @DisplayName("입력받은 다리가 비정상값으로 들어올 경우")
    @ParameterizedTest
    @MethodSource("inputWrongBridge")
    public void fail(List<String> value) {
        assertThatThrownBy(() -> new ValidateBridgeGame().validate(value))
                .isInstanceOf(IllegalStateException.class);
    }

    static Stream<Arguments> inputWrongBridge() {
        return Stream.of(
                Arguments.arguments(Arrays.asList("U", "d", "U", "d")),
                Arguments.arguments(Arrays.asList("u", "D", "U", "D")),
                Arguments.arguments(Arrays.asList("U", "D", "d")),
                Arguments.arguments(Arrays.asList("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "u")),
                Arguments.arguments(Arrays.asList("D", "D", "A", "D"))
        );
    }

    @Nested
    @DisplayName("사용자 이동의 정상 동작을 확인함.")
    class ValidateMove {
        BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U","D","U"));

        @DisplayName("칸 건너기를 성공한 경우. 1번 케이스")
        @Test
        public void successOneMove() {
            bridgeGame.move("U");
            assertThat(bridgeGame.isSuccess())
                    .isTrue();
        }

        @DisplayName("칸 건너기를 성공한 경우. 2번 케이스")
        @Test
        public void successTwoMove() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.isSuccess())
                    .isTrue();
        }

        @DisplayName("칸 건너기를 실패한 경우. 1번케이스")
        @Test
        public void failOneMove() {
            bridgeGame.move("D");
            assertThat(bridgeGame.isSuccess())
                    .isFalse();
        }

        @DisplayName("칸 건너기를 실패한 경우. 2번케이스")
        @Test
        public void failTwoMove() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.isSuccess())
                    .isFalse();
        }

        @DisplayName("다리 전체를 다 건넌 경우.")
        @Test
        public void successAllMove(){
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            assertThat(bridgeGame.checkNotGoal())
                    .isFalse();
        }

    }
}
