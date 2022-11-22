package bridge.domain.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeBlockTest {

    @ParameterizedTest
    @DisplayName("다리 블록 타입 변경 검증")
    @ValueSource(ints = {2, 3, -1, 10})
    void 다리_명령어_입력은_U_와_D만_가능합니다(final int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeBlock.convertTypeString(input))
                .withMessageContaining(BridgeBlock.ERROR_NOT_FOUND);
    }

    @ParameterizedTest
    @DisplayName("다리 명령어 입력 검증")
    @ValueSource(strings = {"u", "d", "asdasd", "123", " "})
    void 다리_명령어_입력은_U_와_D만_가능합니다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeBlock.convertTypeBlock(input))
                .withMessageContaining(BridgeBlock.ERROR_NOT_FOUND_BLOCK_VALUE);
    }


    @ParameterizedTest
    @DisplayName("다리 구조 검증")
    @MethodSource("generateData")
    void 다리의_구조가_잘못되었습니다(final List<String> one) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeBlock.convertTypeList(one))
                .withMessageContaining(BridgeBlock.ERROR_BRIDGE_STRUCTURE);
    }

    static Stream<List<String>> generateData() {
        return Stream.of(
                List.of("1", "0", "-1", "1"),
                List.of("1", "0", "abc", "1"));
    }


}