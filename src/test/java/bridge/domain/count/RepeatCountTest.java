package bridge.domain.count;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RepeatCountTest {

    @Test
    void 반복횟수를_추가할_수_있습니다() {
        var actual = RepeatCount.initializeRepeatCount()
                .increment(1)
                .result();

        assertThat(actual).isEqualTo("총 시도한 횟수: 2");
    }

    @Test
    void 반복횟수가_최대일_경우_에러가_발생합니다() {
        assertThatIllegalStateException().isThrownBy(
                () -> RepeatCount.initializeRepeatCount()
                        .increment(Integer.MAX_VALUE)
        );

    }

}