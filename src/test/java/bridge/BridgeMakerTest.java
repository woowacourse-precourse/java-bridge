package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator numberGenerator;

    @TestFactory
    @DisplayName("makeBridgeTest")
    Stream<DynamicTest> makeBridgeTest() {
        List<Integer> valueSource = List.of(1, 2, 3, 4, 5, 6);
        numberGenerator = new TestNumberGenerator();
        bridgeMaker = new BridgeMaker(numberGenerator);

        return valueSource.stream()
                .map(size -> DynamicTest.dynamicTest("입력된 size 크기의 리스트를 반환한다.", () -> {
                    List<String> result = bridgeMaker.makeBridge(size);
                    assertThat(result.size()).isEqualTo(size);
                }
        ));
    }


    static class TestNumberGenerator implements BridgeNumberGenerator {
        @Override
        public int generate() {
            return 0;
        }
    }
}
