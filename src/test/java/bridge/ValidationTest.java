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

    @DisplayName("U 혹은 D인지 확인한다.")
    @Test
    void upOrDown() {
        assertThat(ValidationUtil.isUpOrDown("U")).isTrue();
        assertThat(ValidationUtil.isUpOrDown("D")).isTrue();

        assertThat(ValidationUtil.isUpOrDown("A")).isFalse();
        assertThat(ValidationUtil.isUpOrDown("1")).isFalse();
        assertThat(ValidationUtil.isUpOrDown("*")).isFalse();
    }
}
