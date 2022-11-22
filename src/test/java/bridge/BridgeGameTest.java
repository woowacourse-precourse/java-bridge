package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class BridgeGameTest {

    @Test
    void move() {
        BridgeGame bg = new BridgeGame();
        List<String> answer = new ArrayList<>();
        answer.add("U");
        answer.add("U");
        boolean b = bg.move("UDD",1,answer);
        assertThat(b).isEqualTo(false);
    }
}