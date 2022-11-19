package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    @DisplayName("카운트 생성 확인")
    void createCount() {
        Count count = new Count();

        assertThat(count).isEqualTo(new Count(1));
    }

    @Test
    @DisplayName("카운트 증가 확인")
    void increaseCount() {
        Count count = new Count();

        assertThat(count.increase()).isEqualTo(new Count(2));
    }

    @Test
    @DisplayName("카운트 생성 시 1미만 일 때 예외")
    void validateCount() {
        assertThatThrownBy(() -> new Count(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
