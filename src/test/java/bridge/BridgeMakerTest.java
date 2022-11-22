package bridge;

import bridge.Domain.BridgeMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator numberGenerator =
                new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1, 0, 0));
        bridgeMaker = new BridgeMaker(numberGenerator);
    }

    @Test
    void makeBridgeTest() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "U", "U", "D", "D");
    }

//    @ParameterizedTest
//    @CsvSource({"1,U", "2,D", "0,D", "3,D"})
//    void mappingTest(int num, String output) {
//        assertThat(bridgeMaker.mapping(num)).isEqualTo(output);
//    }
}
