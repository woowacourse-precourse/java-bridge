package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMovementTest {

    @DisplayName("유저 움직임 추가 로직 테스트")
    @Nested
    static class addMovementTest {

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(
                            new UserMovement(),
                            "U",
                            Arrays.asList("U")
                    ),
                    Arguments.of(
                            new UserMovement(new ArrayList(Arrays.asList("U", "D", "D"))),
                            "D",
                            Arrays.asList("U", "D", "D", "D")
                    ),
                    Arguments.of(
                            new UserMovement(new ArrayList(Arrays.asList("U"))),
                            "U",
                            Arrays.asList("U", "U")
                    )
            );
        }

        @DisplayName("성공 케이스")
        @ParameterizedTest
        @MethodSource("generateData")
        void success(UserMovement userMovement, String direction, List<String> result) {
            userMovement.addMovement(direction);
            assertThat(userMovement.getUserMovement()).isEqualTo(result);
        }
    }


    @DisplayName("유저 직전 움직임 되돌리기 테스트")
    @Nested
    static class undoMoveTest {

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(
                            new UserMovement(new ArrayList(Arrays.asList("U", "D", "D"))),
                            Arrays.asList("U", "D")
                    ),
                    Arguments.of(
                            new UserMovement(),
                            Arrays.asList()
                    ),
                    Arguments.of(
                            new UserMovement(new ArrayList(Arrays.asList("U"))),
                            Arrays.asList()
                    )
            );
        }

        @DisplayName("성공 케이스")
        @ParameterizedTest
        @MethodSource("generateData")
        void success(UserMovement userMovement, List<String> result) {
            userMovement.undoMove();
            assertThat(userMovement.getUserMovement()).isEqualTo(result);
        }
    }
}
