package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void create() {
        TryCount tryCount = new TryCount();

        assertThat(tryCount).isEqualTo(new TryCount(1));
    }

    @DisplayName("시도 횟수 범위 검증")
    @Test
    void validateTryCountRange() {
        assertAll(
                () -> assertThatThrownBy(() -> new TryCount(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThat(new TryCount()).isEqualTo(new TryCount(1)),
                () -> assertThat(new TryCount(2_000_000_000)).isEqualTo(new TryCount(2_000_000_000)),
                () -> assertThatThrownBy(() -> new TryCount(2_000_000_001)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수 1 증가시킨다.")
    @Test
    void plusOne() {
        assertThat(new TryCount(3).plusOne()).isEqualTo(new TryCount(4));
    }

    @DisplayName("시도 횟수 값을 반환한다.")
    @Test
    void count() {
        assertAll(
                () -> assertThat(new TryCount().count()).isEqualTo(1),
                () -> assertThat(new TryCount(4).count()).isEqualTo(4)
        );
    }
}
