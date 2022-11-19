package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("다리의 초기화가 정상적으로 이루어지는지 확인")
    @Test
    void checkSettingBridgeSuccess() {
        int bridgeSize = 10;
        assertThatCode(() -> bridgeGame.setBridge(bridgeSize))
                .doesNotThrowAnyException();
    }

    @DisplayName("칸 위치의 초기화가 정상적으로 이루어지는지 확인")
    @Test
    void checkSettingLocationSuccess() {
        assertThatCode(() -> bridgeGame.setLocation())
                .doesNotThrowAnyException();
    }
}
