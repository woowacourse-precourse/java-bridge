package bridge;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    private BridgeNumberGenerator numberGenerator;
    private BridgeMaker bridgeMaker;

    @DisplayName("올바른 길이의 다리를 생성하는지 테스트")
    @ParameterizedTest
    @CsvSource("3, 3, 10, 10, 20, 20")
    void 다리_길이_테스트(int size, int expected) {
        numberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        int actual = bridge.size();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("1은 U, 0은 D로 다리를 올바르게 생성하는지 테스트")
    @ParameterizedTest
    @CsvSource("1, 0, 0, 3, U, D, D, 1, 1, 1, 3, U, U, U")
    void 다리_생성_테스트(int element1, int element2, int element3, int size, String moving1, String moving2, String moving3) {
        numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(element1, element2, element3));
        bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> actual = bridgeMaker.makeBridge(size);
        List<String> expected = Arrays.asList(moving1, moving2, moving3);
        assertThat(actual).isEqualTo(expected);
    }
}
