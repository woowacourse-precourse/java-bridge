package bridge.domain.bridge;

import static bridge.domain.bridge.MoveType.DOWN;
import static bridge.domain.bridge.MoveType.UP;
import static bridge.domain.result.ResultType.FAIL;
import static bridge.domain.result.ResultType.FINISHED;
import static bridge.domain.result.ResultType.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.result.ResultType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    Bridge bridge;

    @DisplayName("moveType 에 대한 resultType 결과테스트")
    @ParameterizedTest(name = "{index}=> {0} 로 생성된 다리에 {1} 순으로 입력하면 {2}가 반환되어야한다.")
    @MethodSource("providerMoveTypeForResultType")
    void move(List<Integer> numbers, List<MoveType> moveTypes, List<ResultType> expected) {

        //given
        bridge = new Bridge(getTestBridgeMaker(numbers));
        bridge.create(numbers.size());

        //when
        List<ResultType> actual = moveTypes.stream()
                .map(moveType -> bridge.move(moveType))
                .collect(Collectors.toList());

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void retry() {
    }


    private static Stream<Arguments> providerMoveTypeForResultType() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 1, 0, 0), List.of(UP, UP, DOWN, DOWN),
                        List.of(SUCCESS, SUCCESS, SUCCESS, FINISHED)),
                Arguments.arguments(Lists.newArrayList(1, 0, 1), List.of(UP, DOWN, DOWN),
                        List.of(SUCCESS, SUCCESS, FAIL))
        );
    }

    private static BridgeMaker getTestBridgeMaker(List<Integer> numbers) {
        return new BridgeMaker(new TestNumberGenerator(numbers));
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}