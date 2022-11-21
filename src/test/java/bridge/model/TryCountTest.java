package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {
    private TryCount tryCount;

    @BeforeEach
    void init_Test() {
        tryCount = new TryCount();
    }

    @Test
    @DisplayName("tryCount의 초기값은 1이다.")
    void constructor_InitializeTryCount_TryCountIs1() {
        assertThat(tryCount.toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("add함수는 tryCount를 1 증가시킨다.")
    void add_CallAddMethod_Add1ToTryCount() {
        tryCount.add();
        assertThat(tryCount.toString()).isEqualTo("2");
    }
}