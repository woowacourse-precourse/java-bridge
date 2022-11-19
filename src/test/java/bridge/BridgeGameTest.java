package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest extends NsTest {
    private static BridgeGame bridgeGame;

    @BeforeAll
    static void initialize(){
        bridgeGame = new BridgeGame();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridge = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @Test
    void testMove() {
        List<String> testBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));
        String example = "U\nD\nU\n";
        InputStream stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));
        InputStream stdin = System.in;
        System.setIn(stream);
        assertThat(bridgeGame.move(testBridge)).isTrue();
        System.setIn(stdin);
    }

    @Test
    void testRetry(){
        String example = "R";
        InputStream stream;
        stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));
        InputStream stdin = System.in;

        System.setIn(stream);
        assertThat(bridgeGame.retry()).isTrue();

        String example2 = "Q";
        stream = new ByteArrayInputStream(example2.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        assertThat(bridgeGame.retry()).isFalse();

        System.setIn(stdin);
    }

    @Override
    protected void runMain() {

    }
}
