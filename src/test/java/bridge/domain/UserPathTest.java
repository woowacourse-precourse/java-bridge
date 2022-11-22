package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserPathTest {

    @DisplayName("유저 경로 테스트")
    @Nested
    static class userPathTest {

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(
                            new UserMovement(Arrays.asList("U", "U", "D", "D")),
                            new Bridge(Arrays.asList("U", "U", "D", "D")),
                            Arrays.asList(Arrays.asList("O", "O", " ", " "), Arrays.asList(" ", " ", "O", "O"))
                    ),
                    Arguments.of(
                            new UserMovement(Arrays.asList("D", "D", "U")),
                            new Bridge(Arrays.asList("D", "D", "D", "U", "U")),
                            Arrays.asList(Arrays.asList(" ", " ", "X"), Arrays.asList("O", "O", " "))
                    ),
                    Arguments.of(
                            new UserMovement(Arrays.asList("U")),
                            new Bridge(Arrays.asList("D")),
                            Arrays.asList(Arrays.asList("X"), Arrays.asList(" "))
                    ),
                    Arguments.of(
                            new UserMovement(Arrays.asList()),
                            new Bridge(Arrays.asList("U", "D", "D")),
                            Arrays.asList(Arrays.asList(), Arrays.asList())
                    )
            );
        }

        @DisplayName("성공 케이스")
        @ParameterizedTest
        @MethodSource("generateData")
        void success(UserMovement userMovement, Bridge bridge, List<List<String>> result) {
            assertThat(new UserPath(userMovement, bridge).getUpperPath()).isEqualTo(result.get(0));
            assertThat(new UserPath(userMovement, bridge).getLowerPath()).isEqualTo(result.get(1));
        }
    }
}
