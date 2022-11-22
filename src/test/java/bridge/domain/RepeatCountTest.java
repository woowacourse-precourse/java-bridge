package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RepeatCountTest {

    @Test
    void initRepeatCount() {
        RepeatCount repeatCount = RepeatCount.initRepeatCount();
        int result = 1;

        assertThat(repeatCount.getCount()).isEqualTo(result);
    }

    @Test
    void increment() {
        RepeatCount repeatCount = RepeatCount.initRepeatCount();
        repeatCount.increment();
        int result = 2;

        assertThat(repeatCount.getCount()).isEqualTo(result);
    }

    @Test
    void getResult() {
        RepeatCount repeatCount = RepeatCount.initRepeatCount();
        repeatCount.increment();
        String result = "총 시도한 횟수: 2";

        assertThat(repeatCount.getResult()).isEqualTo(result);
    }
}