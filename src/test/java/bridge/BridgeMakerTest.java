package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @DisplayName("size로 6이 주어지면 반환되는 list의 사이즈는 6이다.")
    @Test
    void makeBridgeBySizeSix() {
        TestNumberGenerator numberGenerator = new TestNumberGenerator(
                newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1)
        );
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        int size = 6;
        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result.size()).isEqualTo(size);
    }
}
