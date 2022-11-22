package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void makeBridgeTest() {
        List<String> answer= bridgeMaker.makeBridge(3);

        System.out.println(answer);

        assertThat(answer).containsAnyOf("U", "D");
    }
}
