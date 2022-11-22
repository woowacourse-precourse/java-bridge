package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 카운트_객체_초기화시_초깃값_1() {
        TryCount tryCount = TryCount.initCount();
        assertThat(tryCount.getCount()).isEqualTo(1);
    }

    @Test
    void 카운트_증가_메소드실행_카운트값_추가된_새카운트() {
        TryCount tryCount = TryCount.initCount();
        TryCount newTryCount = tryCount.addCount();
        assertThat(newTryCount.getCount()).isEqualTo(2);
    }

    @Test
    void 시도회수는_최소_1이상() {
        assertThatThrownBy(
            () -> new TryCount(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
