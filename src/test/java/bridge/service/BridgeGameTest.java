package bridge.service;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import bridge.repository.BridgeGameRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("생성한 다리와 저장소에 저장한 다리가 동일한지 검증 테스트")
    @ParameterizedTest
    @CsvSource({"5", "6", "7", "10"})
    void generateRandomBridge_success(String inputBridgeSize) {
        // given
        BridgeGameRepository bridgeGameRepository = BridgeGameRepository.getInstance();

        // when
        Bridge storedBridge = bridgeGame.generateRandomBridge(inputBridgeSize);
        Bridge findBridge = bridgeGameRepository.findBridge();

        // then
        assertThat(storedBridge).isEqualTo(findBridge);

    }
}