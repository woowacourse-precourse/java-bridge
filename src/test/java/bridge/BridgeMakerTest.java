package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    @DisplayName("size가 주어지면 반환되는 list의 사이즈는 size와 같다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 8, 9, 18, 19, 20})
    void makeBridgeBySizes(int size) {
        TestNumberGenerator numberGenerator = new TestNumberGenerator(
                newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1)
        );
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result.size()).isEqualTo(size);
    }
}
