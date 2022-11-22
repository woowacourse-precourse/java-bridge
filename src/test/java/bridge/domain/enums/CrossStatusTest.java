package bridge.domain.enums;

import static bridge.domain.enums.CrossStatus.YET;
import static bridge.domain.enums.CrossStatus.createInitializationStatuses;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrossStatusTest {

    @DisplayName("다리의 각 블록의 건넌 상태를 파악하기 위한 리스트 생성 테스트")
    @Test
    void createInitializationStatuses_length_check_success() {
        // given
        List<CrossStatus> expected = List.of(YET, YET, YET, YET, YET);
        // when
        List<CrossStatus> actual = createInitializationStatuses(5);
        // then
        assertThat(actual).containsSequence(expected);
    }
}