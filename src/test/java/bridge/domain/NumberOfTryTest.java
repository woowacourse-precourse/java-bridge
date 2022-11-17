package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class NumberOfTryTest {
    
    @Test
    @DisplayName("시도 횟수 증가 확인")
    void increase() {
        NumberOfTry numberOfTry = new NumberOfTry();
        
        assertAll(
                () -> assertThat(numberOfTry.numberOfTry()).isEqualTo(1),
                () -> assertThat(numberOfTry.increase().numberOfTry()).isEqualTo(2)
        );
    }
}