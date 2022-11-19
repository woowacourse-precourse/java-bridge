package bridge.repository;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.enums.BlockStatus;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameRepositoryTest {
    private final BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

    static Stream<Arguments> generateSymbolBlocks() {
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

    @DisplayName("저장소에 다리 저장 성공 테스트")
    @ParameterizedTest
    @MethodSource("generateSymbolBlocks")
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
}