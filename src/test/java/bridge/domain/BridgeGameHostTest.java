package bridge.domain;

import bridge.domain.BridgeGameHost;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameHostTest {

    private BridgeGameHost bridgeGameHost;
    private final List<String> testBridge = List.of("U", "D", "D", "U");

    @BeforeEach
    void beforeEach() {
        bridgeGameHost = new BridgeGameHost();
        Bridge.setBridge(testBridge);
        Player.set();
    }

    @DisplayName("Index 가 주어지면 해당 다리의 부분을 반환하는 기능")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void stepOfIndexInBridge(int index) {
        // then
        assertThat(Bridge.getStepInBridge(index)).isEqualTo(testBridge.get(index));
    }

    @Test
    @DisplayName("플레이어가 살아있는지 반환하는 기능")
    void isPlayerAlive() {
        // then
        assertThat(Player.getAlive()).isTrue();
    }

    @Test
    @DisplayName("플레이어의 Index 를 반환하는 기능")
    void getInitialPlayerIndex() {
        // then
        assertThat(Player.getIndex()).isEqualTo(-1);
    }

    @Test
    @DisplayName("플레이어의 총 시도 횟수를 반환하는 기능")
    void getRetry() {
        // then
        assertThat(Player.getNumberOfRetry()).isEqualTo(1);
    }

    @Test
    @DisplayName("플레이어가 게임에서 성공하는 경우")
    void getResult() {
        // then
        assertThat(bridgeGameHost.getResult()).isEqualTo("실패");
    }
}
