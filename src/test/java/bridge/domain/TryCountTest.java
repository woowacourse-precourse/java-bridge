package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void create() {
        TryCount tryCount = new TryCount();

        assertThat(tryCount).isEqualTo(new TryCount(1));
    }

    @DisplayName("시도 횟수 최솟값 검증")
    @Test
    void validateTryCountStart() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new TryCount(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThat(new TryCount(1)).isEqualTo(new TryCount(1))
        );
    }
}
