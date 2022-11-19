package bridge;


import bridge.domain.Bridge;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    Bridge bridge;
    Player success;
    Player fail;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("D", "U", "D", "U"));
        success = new Player(4);
        fail = new Player(4);
        List.of("D", "U").forEach(e -> success.inputDirection(e));
        List.of("D", "U", "D", "D").forEach(e -> fail.inputDirection(e));
    }
}
