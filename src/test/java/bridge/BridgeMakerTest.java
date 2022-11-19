package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.enums.BlockStatus;
import bridge.repository.BridgeGameRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

    @DisplayName("임의의 숫자 길이 만큼의 다리 생성 테스트")
    @ParameterizedTest
    @CsvSource({"3,3", "4,4", "5,5", "6,6", "7,7"})
    void makeBridge_success(int size, int expectedSize) {
        // given
        // when
        List<String> symbolBlocks = bridgeMaker.makeBridge(size);

        // then
        assertThat(symbolBlocks.size()).isEqualTo(expectedSize);
    }

    @DisplayName("임의의 숫자 길이 만큼의 다리 생성 및 저장소에 다리 저장 테스트")
    @ParameterizedTest
    @CsvSource({"3", "4", "5", "6"})
    void makeBridge_and_storeInRepository_success(int size) {
        // given
        // when
        List<String> symbolBlocks = bridgeMaker.makeBridge(size);
        List<BlockStatus> storedBlocks = bridgeGameRepository.storeBridge(symbolBlocks);
        int count = 0;
        for (int index = 0; index < size; index++) {
            BlockStatus block = storedBlocks.get(index);
            if (block.hasCrossableSymbol(symbolBlocks.get(index))) {
                count++;
            }
        }

        // then
        assertThat(count).isEqualTo(size);
    }
}