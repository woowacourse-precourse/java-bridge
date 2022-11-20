package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepetitionTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void makeRepetition() {
        assertThat(new Repetition()).isEqualTo(new Repetition());
    }

    @DisplayName("재시작 시 재시작 정보가 하나 늘어난다.")
    @Test
    void increaseRepetitionCount(){
        assertThat(new Repetition().increaseCount()).isEqualTo(new Repetition().increaseCount());
    }
}