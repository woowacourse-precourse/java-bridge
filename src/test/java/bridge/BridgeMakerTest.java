package bridge;

import static bridge.constant.ErrorConstant.INPUT_NUMBER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    private ArchitecturalDesignOffice architecturalDesignOffice;
    private BridgeConverter bridgeConverter;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = mock(BridgeNumberGenerator.class);
        bridgeConverter = mock(BridgeConverter.class);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        architecturalDesignOffice = mock(ArchitecturalDesignOffice.class);
    }

    @DisplayName("정상 시나리오 | 다리를 만든다")
    @Test
    void makeBridge() {
        assertThat(bridgeMaker.makeBridge(3)).hasSize(3);
    }

    @DisplayName("에러 시나리오 | 다리 사이즈가 0에서 20의 수가 아닌 수 요청 시 예외 처리")
    @ParameterizedTest
    @CsvSource({"-1", "0", "21"})
    void makeBridgeValidateBridgeSizeError(String bridgeSize) {
        int testBridgeSize = Integer.parseInt(bridgeSize);

        assertThatThrownBy(() -> bridgeMaker.makeBridge(testBridgeSize)).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessageContaining(
                                                                                INPUT_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("정상 시나리오 | 만들어진 다리를 저장 함.")
    @Test
    void save() {
        assertThat(bridgeMaker.save(List.of())).isInstanceOf(ArchitecturalDesignOffice.class);
    }

    @DisplayName("정상 시나리오 | 만들어진 다리를 불러옴.")
    @Test
    void reload() {
        when(architecturalDesignOffice.sendStoredBridgeBlueprint()).thenReturn(List.of("U", "D", "D"));

        assertThat(bridgeMaker.reload(architecturalDesignOffice)).hasSize(3);
    }

}