package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

class RetryTest {

    @DisplayName("재시작시 정상적인 데이터를 넣은 경우")
    @ParameterizedTest
    @EnumSource(Retry.class)
    void check_Retry_True(Retry retry){
        assertThat(Retry.validRetry(retry.name())).isEqualTo(true);
    }

    @DisplayName("재시작시 비정상적인 데이터를 넣은 경우")
    @Test
    void check_Retry_False(){
        assertThat(Retry.validRetry("U")).isEqualTo(false);
    }
}