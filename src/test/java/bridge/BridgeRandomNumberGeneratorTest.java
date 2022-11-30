package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {

    @Test
    @DisplayName("0, 1 두가지 값만 생성되는지 확인하는 테스트")
    void generateTest() {

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        int testCaseNumber = 10000;
        int generateNumber;
        boolean result = true;

        for (int testNumber = 0; testNumber < testCaseNumber; testNumber++) {
            generateNumber = bridgeNumberGenerator.generate();
            if (generateNumber != 0 && generateNumber != 1) {
                result = false;
            }
        }
        assertThat(result).isTrue();
    }
}