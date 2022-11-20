package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeRandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자가 0아니면 1인지 확인")
    public void generateTest() {
        BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
        int check = random.generate();
        assertThat(check).isEqualTo(0).isEqualTo(1);
    }
}
