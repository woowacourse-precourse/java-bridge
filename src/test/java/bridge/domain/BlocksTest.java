package bridge.domain;

import static bridge.domain.enums.BlockStatus.DOWN;
import static bridge.domain.enums.BlockStatus.UP;
import static bridge.domain.enums.CrossStatus.FAIL;
import static bridge.domain.enums.CrossStatus.SUCCESS;

import bridge.domain.enums.CrossStatus;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BlocksTest {
    private final Blocks blocks = new Blocks(List.of(UP, DOWN, UP, DOWN));
    private final CrossStatuses crossStatuses = new CrossStatuses(CrossStatus.createInitializationStatuses(4));

    private static Stream<Arguments> generateInputBlocks() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "U", "U"), List.of(SUCCESS, FAIL, SUCCESS, FAIL)),
                Arguments.of(List.of("U", "D", "U", "D"), List.of(SUCCESS, SUCCESS, SUCCESS, SUCCESS)),
                Arguments.of(List.of("D", "D", "D", "D"), List.of(FAIL, SUCCESS, FAIL, SUCCESS)),
                Arguments.of(List.of("D", "U", "D", "U"), List.of(FAIL, FAIL, FAIL, FAIL))
        );
    }

    @DisplayName("임의의 생성된 칸 이동시 성공, 실패 여부 판단 테스트")
    @ParameterizedTest
    @MethodSource("generateInputBlocks")
    void moveNextBlock_success(List<String> inputBlocks, List<CrossStatus> expectedResult) {
        // given
        // when
        List<CrossStatus> actualResult = Stream.generate(() -> inputBlocks.stream()
                        .map(input -> blocks.moveNextBlock(input, crossStatuses))
                        .collect(Collectors.toList()))
                .findAny()
                .get();
        // then
        Assertions.assertThat(actualResult).containsSequence(expectedResult);
    }
}