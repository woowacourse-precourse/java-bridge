package bridge;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private List<Integer> zeroOrOne;

    @BeforeEach
    void setUp() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        zeroOrOne = List.of(0,1);
    }

    @AfterEach
    void tearDown() {
        bridgeRandomNumberGenerator = null;
    }

    @DisplayName("0아니면 1인지 반복하며 확인.")
    @RepeatedTest(20)
    void generate() {
        int generatedInt = bridgeRandomNumberGenerator.generate();
        Assertions.assertTrue(zeroOrOne.contains(generatedInt));
    }
}