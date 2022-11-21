package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecordTest {

    @DisplayName("같은 방향일 경우 true를 반환한다.")
    @Test
    void sameDirection() {
        // given
        BridgeCell cell = BridgeCell.UP;
        Record record = new Record(cell, true);

        // when
        boolean isSame = record.sameDirection(cell);

        assertThat(isSame).isTrue();
    }
}
