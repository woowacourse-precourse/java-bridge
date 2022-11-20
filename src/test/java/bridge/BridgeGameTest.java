package bridge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class BridgeGameTest {
    @Test
    void simpleTest() {
        assertSimpleTest(() -> {
            String testStr = "6\nU\nD";
            InputStream is = new ByteArrayInputStream(testStr.getBytes());
            System.setIn(is);
            BridgeGame gameClient = new BridgeGame();
            gameClient.startGame();

        });

    }
}
