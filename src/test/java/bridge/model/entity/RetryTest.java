package bridge.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RetryTest {

    @DisplayName("정상 생성 테스트")
    @Test
    void of_normal() {
        //Given
        String[] move = new String[]{"R", "Q"};
        //When
        for(int i = 0; i < move.length; i++){
            Retry retry = Retry.of(move[i]);
            //Then
            assertThat(retry.getAnswer()).isEqualTo(move[i]);
        }
    }

    @DisplayName("[ERROR] Move 예외 테스트")
    @Test
    void of() {
        //Given
        String[] retry = new String[]{"1", "(", " "};

        //When
        assertThatThrownBy( () -> {
            for(int i = 0; i < retry.length; i++){
                Retry.of(retry[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);

        //Then
    }

}