package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Assertions;
import java.util.List;

class BridgeRandomNumberGeneratorTest {
    private BridgeNumberGenerator bridgeNumberGenerator;
    private List<Integer> zeroOrOne;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        zeroOrOne = List.of(0,1);
    }

    @AfterEach
    void tearDown() {
        bridgeNumberGenerator = null;
    }

    @DisplayName("0아니면 1인지 반복하며 확인.")
    @RepeatedTest(20)
    void generate() {
        int number = bridgeNumberGenerator.generate();
        Assertions.assertTrue(zeroOrOne.contains(number));
    }
}