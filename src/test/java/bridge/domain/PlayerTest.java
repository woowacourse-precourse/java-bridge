package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.TestNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class PlayerTest {
    private Bridge bridge;

    @BeforeEach
    public final void initBridgeMaker() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(3));
    }

    @DisplayName("플레이어가 다리 건너기를 성공한다.")
    @ValueSource(strings = {"U", "UD", "UDD"})
    @ParameterizedTest
    void userCrossBridgeSuccess(String command) {
        Player player = new Player();
        for (int i = 0; i < command.length(); i++){
            boolean isSuccess = player.move(bridge, String.valueOf(command.charAt(i)));
            Assertions.assertTrue(isSuccess);
        }
    }

    @DisplayName("플레이어가 다리 건너기를 실패한다.")
    @ValueSource(strings = {"D", "UU", "UDU"})
    @ParameterizedTest
    void userCrossBridgeFail(String command) {
        Player player = new Player();

        List<Boolean> result = newArrayList();
        for (int i = 0; i < command.length(); i++) {
            result.add(player.move(bridge, String.valueOf(command.charAt(i))));
        }
        assertThat(result).contains(false);
    }

    @DisplayName("플레이어가 재시도한다.")
    @ValueSource(strings = {"D", "UU", "UDU"})
    @ParameterizedTest
    void userRetry(String command) {
        Player player = new Player();
        for (int i = 0; i < command.length(); i++) {
            player.move(bridge, String.valueOf(command.charAt(i)));
        }

        player.retry();

        Assertions.assertEquals(0, player.getPosition());
        Assertions.assertEquals(2, player.getTryCount());
    }
}