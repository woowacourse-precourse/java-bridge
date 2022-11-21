package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BlockPositionTest {
    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    @ParameterizedTest
    void U또는_D를_입력하면_BlockPosition을_반환한다(String input, BlockPosition position) {
        assertThat(BlockPosition.from(input))
                .isEqualTo(position);
    }

    @ValueSource(strings = {"A", "123", "!@#", "가나다"})
    @ParameterizedTest
    void U또는_D이외의_값을_입력하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> BlockPosition.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    @ParameterizedTest
    void _0또는_1을_입력하면_BlockPosition을_반환한다(int input, BlockPosition position) {
        assertThat(BlockPosition.from(input))
                .isEqualTo(position);
    }

    @ValueSource(ints = {-1, 2, 3})
    @ParameterizedTest
    void _0또는_1이외의_값을_입력하면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> BlockPosition.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
