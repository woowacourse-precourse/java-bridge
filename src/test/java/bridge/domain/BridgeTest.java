package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    private Bridge bridge;
    private UserPosition userPosition;
    @BeforeEach
    public void setUp() {
        bridge = Bridge.of(List.of("U","D"));
        userPosition = UserPosition.newInstance();
    }
    @Test
    public void bridgeKeepTest() {
        userPosition.move("U");
        assertThat(bridge.play(userPosition)).isEqualTo(Result.KEEP);
    }
    @Test
    public void bridgeLoseTest() {
        userPosition.move("D");
        assertThat(bridge.play(userPosition)).isEqualTo(Result.LOSE);
    }
    @Test
    public void bridgeWinTest() {
        userPosition.move("U");
        userPosition.move("D");
        assertThat(bridge.play(userPosition)).isEqualTo(Result.WIN);
    }
}
