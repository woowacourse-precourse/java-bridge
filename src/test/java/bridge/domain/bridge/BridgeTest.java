package bridge.domain.bridge;

import static bridge.domain.bridge.MoveType.DOWN;
import static bridge.domain.bridge.MoveType.UP;
import static bridge.domain.result.ResultType.FAIL;
import static bridge.domain.result.ResultType.FINISHED;
import static bridge.domain.result.ResultType.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.result.ResultType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    Bridge bridge;

    @DisplayName("moveType 에 대한 resultType 결과테스트")
    @ParameterizedTest(name = "{index}=> {0} 로 생성된 다리에 {1} 순으로 입력하면 {2}가 반환되어야한다.")
    @MethodSource("providerMoveTypeForResultType")
    void move(List<Integer> numbers, List<MoveType> moveTypes, List<ResultType> expected) {

        //given
        bridge = new Bridge(getTestBridgeMaker(numbers));
        bridge.create(String.valueOf(numbers.size()));

        //when
        List<ResultType> actual = moveTypes.stream()
                .map(moveType -> bridge.move(moveType))
                .collect(Collectors.toList());

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("index 가 초기화되어 반환되는 resultType 이 moveType 이 같으면 같아야한다")
    void retry() {
        //given
        bridge = new Bridge(getTestBridgeMaker(Lists.newArrayList(1, 0, 1, 0, 1)));
        bridge.create("5");

        ResultType expected = bridge.move(DOWN);

        //when
        bridge.retry();
        ResultType actual1 = bridge.move(DOWN); //X
        bridge.retry();
        ResultType actual2 = bridge.move(UP); //O
        //then
        assertThat(expected).isEqualTo(actual1);
        assertThat(expected).isNotEqualTo(actual2);

    }

    @Test
    @DisplayName("정수가 아닌값이 인자로 들어왔을때 예외발생")
    public void 예외테스트_1() {
        //given
        bridge = new Bridge(getTestBridgeMaker(Lists.newArrayList(1, 0, 1, 0, 1)));
        String input = "3d";
        //when
        //then
        Assertions.assertThatThrownBy(() -> bridge.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21"})
    @DisplayName("다리 사이즈 범위 밖을 벋어나는 값을 인자로 받을 시 예외발생")
    public void 예외테스트_2(String input) {
        //given
        bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        //when
        //then
        System.out.println(input);
        Assertions.assertThatThrownBy(() -> bridge.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
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