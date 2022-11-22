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

public class BridgeTest {

    @DisplayName("다리와 유저 움직임 비교 테스트")
    @Nested
    static class compareWithUserMovementTest {

        private static Stream<Arguments> generateDataForSuccess() {
            return Stream.of(
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "D", "D", "D", "U", "D")),
                            Arrays.asList("U", "D", "D", "D", "U", "D"),
                            Arrays.asList(true, true, true, true, true, true)
                    ),
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "D", "D", "U", "D")),
                            Arrays.asList("U", "D", "D", "D"),
                            Arrays.asList(true, true, true, false)
                    ),
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "D", "U", "U", "U")),
                            Arrays.asList(),
                            Arrays.asList()
                    )
            );
        }

        @DisplayName("성공 케이스")
        @ParameterizedTest
        @MethodSource("generateDataForSuccess")
        void successCase(Bridge bridge, List<String> userMovement, List<Boolean> compareResult) {
            assertThat(bridge.compareWithUserMovement(userMovement)).isEqualTo(compareResult);
        }
    }


    @DisplayName("유저가 다리 마지막에 위치하는지 테스트")
    @Nested
    static class whetherAtTheEndOfBridgeTest {

        private static Stream<Arguments> generateDataForSuccess() {
            return Stream.of(
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "U", "D", "D", "U")),
                            Arrays.asList("U", "U", "D", "D", "U"),
                            true
                    ),
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "U")),
                            Arrays.asList("U", "D"),
                            true
                    ),
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "U")),
                            Arrays.asList("U"),
                            false
                    )
            );
        }

        @DisplayName("성공 케이스")
        @ParameterizedTest
        @MethodSource("generateDataForSuccess")
        void successCase(Bridge bridge, List<String> userMovement, Boolean result) {
            assertThat(bridge.whetherAtTheEndOfBridge(userMovement)).isEqualTo(result);
        }
    }


    @DisplayName("")
    @Nested
    static class whetherMoveToExitingCellTest {

        private static Stream<Arguments> generateDataForSuccess() {
            return Stream.of(
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "U", "U", "D")),
                            Arrays.asList("U", "U"),
                            true
                    ),
                    Arguments.of(
                            new Bridge(Arrays.asList("U", "U", "U", "D")),
                            Arrays.asList("U", "U", "D"),
                            false
                    )
            );
        }

        @DisplayName("성공 케이스")
        @ParameterizedTest
        @MethodSource("generateDataForSuccess")
        void successCase(Bridge bridge, List<String> userMovement, Boolean result) {
            assertThat(bridge.whetherMoveToExitingCell(userMovement)).isEqualTo(result);
        }
    }
}
