package bridge.domain.enums;

import static bridge.domain.enums.BlockStatus.DOWN;
import static bridge.domain.enums.BlockStatus.UP;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlockStatusTest {
    @DisplayName("문자열 형식의 다리 블록 구성을 알맞은 enum 타입 리스트로 변경하는 테스트")
    @Test
    void convertToBlockStatues_success() {
        // given
        List<String> inputBlock = List.of("U", "U", "D", "D");
        List<BlockStatus> expected = List.of(UP, UP, DOWN, DOWN);

        // when
        List<BlockStatus> actual = BlockStatus.convertToBlockStatues(inputBlock);

        // then
        assertThat(actual).containsSequence(expected);
    }

    @DisplayName("숫자 형식의 다리 블록 구성을 알맞은 문자열 타입 리스트로 변경하는 테스트")
    @Test
    void createSymbolBlocks_success() {
        // given
        List<Integer> inputBlock = List.of(1, 0, 1, 0);
        List<String> expected = List.of("U", "D", "U", "D");

        // when
        List<String> actual = BlockStatus.createSymbolBlocks(inputBlock);

        // then
        assertThat(actual).containsSequence(expected);
    }
}