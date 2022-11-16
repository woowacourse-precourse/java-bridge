package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @DisplayName("다리의 길이는 3이상 20 이하이다.")
    @Test
    void bridgeLength() {
        assertThat(ValidationUtil.isValidBridgeLength(3)).isTrue();
        assertThat(ValidationUtil.isValidBridgeLength(20)).isTrue();

        assertThat(ValidationUtil.isValidBridgeLength(2)).isFalse();
        assertThat(ValidationUtil.isValidBridgeLength(21)).isFalse();
    }
}
