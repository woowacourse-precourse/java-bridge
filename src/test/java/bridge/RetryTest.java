package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

class RetryTest {

    @DisplayName("재시작에 정상적인 데이터를 넣은 경우 true를 반환하는가 체크")
    @ParameterizedTest
    @EnumSource(Retry.class)
    void aaa(Retry retry){
        assertThat(Retry.validRetry(retry.name())).isEqualTo(true);
    }

    @DisplayName("재시작에 비정상적인 데이터를 넣은 경우 false를 반환하는가 체크")
    @Test
    void aaa3(){
        assertThat(Retry.validRetry("U")).isEqualTo(false);
    }
}