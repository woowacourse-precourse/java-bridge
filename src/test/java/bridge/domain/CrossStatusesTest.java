package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.enums.CrossStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrossStatusesTest {
    private final CrossStatuses crossStatuses = new CrossStatuses(CrossStatus.createInitializationStatuses(4));

    @DisplayName("다리 건너기에서 가장 최근에 이동한 칸의 인덱스 반환 테스트")
    @Test
    void findUncrossedIndex_success() {
        // given
        // when
        int uncrossedIndex1 = crossStatuses.findUncrossedIndex();
        crossStatuses.updateStatus(CrossStatus.SUCCESS, uncrossedIndex1);
        int uncrossedIndex2 = crossStatuses.findUncrossedIndex();

        // then
        Assertions.assertAll(() -> {
            assertThat(uncrossedIndex1).isEqualTo(0);
            assertThat(uncrossedIndex2).isEqualTo(1);
        });
    }

    @Test
    void updateStatus() {
    }
}