package bridge.domain;

import bridge.domain.user.MoveType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveTypeTest {

    @Test
    @DisplayName("MoveType String과 비교 메서드 테스트")
    public void moveTypeCompareToTest() {
        boolean result = MoveType.UP_TYPE.compareTo("UP");
        Assertions.assertThat(result).isFalse();
    }
}
