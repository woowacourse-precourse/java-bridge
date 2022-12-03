package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("다리가 랜덤으로 만들어지는지 확인")
    void makeBridgeTest() {
        List<String> answer= bridgeMaker.makeBridge(3);

        System.out.println(answer);

        assertThat(answer).containsAnyOf("U", "D");
    }
}
