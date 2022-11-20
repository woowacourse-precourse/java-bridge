package bridge.domain;

import static bridge.domain.vo.BridgeSize.MAX_SIZE;
import static bridge.domain.vo.BridgeSize.MIN_SIZE;
import static bridge.domain.vo.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.vo.MoveCommand.MOVE_TO_UPPER_BLOCK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @DisplayName("Bridge를 생성할때")
    @Nested
    class Validate {

        @DisplayName("길이가 " + MIN_SIZE + " 미만," + MAX_SIZE + " 초과일시 예외를 반환한다.")
        @ValueSource(ints = {MIN_SIZE - 1, MAX_SIZE + 1})
        @ParameterizedTest
        void wrong_range_value_is_exception(int wrongSize) {
            assertThatThrownBy(() -> new Bridge(createBlocks(wrongSize)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("잘못된 값을 가지고 있을 경우 예외를 반환한다.")
        @ValueSource(ints = {MIN_SIZE})
        @ParameterizedTest
        void if_blocks_contain_wrong_value_is_exception(int rightSize) {
            List<String> blocks = createBlocks(rightSize);
            blocks.add("wrongValue");
            assertThatThrownBy(() -> new Bridge(blocks))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("값이 문제없으면 정상적으로 생성한다")
        @ValueSource(ints = {MIN_SIZE})
        @ParameterizedTest
        void pass_logic(int rightSize) {
            assertThatNoException().isThrownBy(() -> new Bridge(createBlocks(rightSize)));
        }

    }

    @DisplayName("특정한 라운드의 값과")
    @Nested
    class IsMoveSuccessMethod {

        @DisplayName("일치하면 true를 반환한다")
        @ValueSource(ints = {MIN_SIZE})
        @ParameterizedTest
        void match_specific_round_value_is_true(int rightSize) {
            List<String> blocks = createBlocks(rightSize);
            Bridge bridge = new Bridge(blocks);

            assertThat(bridge.isMoveSuccess(1, blocks.get(0))).isTrue();
        }

        @DisplayName("일치하지않으면 false를 반환한다")
        @ValueSource(ints = {MIN_SIZE})
        @ParameterizedTest
        void not_match_specific_round_value_is_false(int rightSize) {
            List<String> blocks = createBlocks(rightSize);
            Bridge bridge = new Bridge(blocks);
            String falseValue = getFalseValue(blocks.get(0));

            assertThat(bridge.isMoveSuccess(1, falseValue)).isFalse();
        }

        private String getFalseValue(String rightValue) {
            if (rightValue.equals(MOVE_TO_UPPER_BLOCK)) {
                return MOVE_TO_LOWER_BLOCK;
            }
            return MOVE_TO_UPPER_BLOCK;
        }
    }

    private List<String> createBlocks(int size) {
        return IntStream.range(0, size)
                .mapToObj(idx -> getRandomBlock())
                .collect(Collectors.toList());
    }

    private String getRandomBlock() {
        Random random = new Random();
        List<String> correctValues = List.of(MOVE_TO_UPPER_BLOCK, MOVE_TO_LOWER_BLOCK);
        return correctValues.get(random.nextInt(correctValues.size()));
    }
}