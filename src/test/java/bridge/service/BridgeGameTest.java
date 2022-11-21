package bridge.service;

import static bridge.messages.ErrorMessage.NON_NUMERIC_BRIDGE_SIZE_ERROR;
import static bridge.messages.ErrorMessage.OUTBOUND_BRIDGE_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import bridge.repository.BridgeGameRepository;
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

    @DisplayName("다리 생성시 잘못된 다리 길이 입력되면 예외 발생 테스트")
    @ParameterizedTest
    @CsvSource({"2," + OUTBOUND_BRIDGE_SIZE_ERROR, "21," + OUTBOUND_BRIDGE_SIZE_ERROR,
            "-1," + OUTBOUND_BRIDGE_SIZE_ERROR, "e2," + NON_NUMERIC_BRIDGE_SIZE_ERROR})
    void generateRandomBridge_fail(String inputBridgeSize, String errorMessage) {
        // given
        // when
        // then
        assertThatThrownBy(() -> bridgeGame.generateRandomBridge(inputBridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}