package bridge.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.enums.BlockStatus;
import bridge.messages.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameRepositoryTest {
    private final BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

    static Stream<Arguments> generateLegalSymbolBlocks() {
        return Stream.of(
                Arguments.of(
                        List.of("U", "D", "U", "D"),
                        List.of(BlockStatus.UP, BlockStatus.DOWN, BlockStatus.UP, BlockStatus.DOWN)
                ),
                Arguments.of(
                        List.of("U", "U", "U", "U"),
                        List.of(BlockStatus.UP, BlockStatus.UP, BlockStatus.UP, BlockStatus.UP)
                ),
                Arguments.of(
                        List.of("D", "D", "D", "D"),
                        List.of(BlockStatus.DOWN, BlockStatus.DOWN, BlockStatus.DOWN, BlockStatus.DOWN)
                )
        );
    }

    static Stream<Arguments> generateIllegalSymbolTest() {
        return Stream.of(
                Arguments.of(List.of("u", "d", "u", "d")),
                Arguments.of(List.of("U", "D", "U", "d")),
                Arguments.of(List.of("1", "D", "U", "D")),
                Arguments.of(List.of("U", "D", "U", "T"))
        );
    }

    @DisplayName("저장소에 다리 저장 성공 테스트")
    @ParameterizedTest
    @MethodSource("generateLegalSymbolBlocks")
    void storeBridge_success(List<String> blocks, List<BlockStatus> expectedBridge) {
        // given
        // when
        List<BlockStatus> actualBridge = bridgeGameRepository.storeBridge(blocks);

        // then
        assertThat(actualBridge).contains(
                expectedBridge.get(0),
                expectedBridge.get(1),
                expectedBridge.get(2),
                expectedBridge.get(3)
        );
    }

    @DisplayName("저장소에 다리 저장 실패 테스트")
    @ParameterizedTest
    @MethodSource("generateIllegalSymbolTest")
    void storeBridge_fail(List<String> blocks) {
        // given
        // when
        // then
        assertThatThrownBy(() -> bridgeGameRepository.storeBridge(blocks))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLOCK_SYMBOL_ERROR);
    }
}