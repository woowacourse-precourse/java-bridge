package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    private final static int START_INDEX = 1;

    @DisplayName("")
    @Test
    void 시도_횟수_증가_테스트() {
        Count count = new Count();
        count.increase();

        assertThat(count.getCount()).isEqualTo(2);
    }

    @DisplayName("최초 생성 시 시작 값은 1 입니다.")
    @Test
    void 초기화_테스트() {
        Count count = new Count();

        assertThat(count.getCount()).isEqualTo(START_INDEX);
    }

}