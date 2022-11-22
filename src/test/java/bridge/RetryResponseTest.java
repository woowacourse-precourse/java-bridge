package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryResponseTest {
    @DisplayName("RetryResponse 생성 테스트")
    @Test
    public void generateRetryResponse(){
        assertThrows(IllegalArgumentException.class, ()->{
            RetryResponse.valueOf("qwe");
        });
        RetryResponse response = RetryResponse.valueOf("Q");
        assertSame(RetryResponse.Q, response);
    }
}