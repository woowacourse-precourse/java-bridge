package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeMakerTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    @DisplayName("3~20까지 범위가 아닌 다리 길이를 입력 시 에러 발생 ")
    void 다리길이_테스트(){
        assertThatThrownBy(() -> {

        }).hasMessageContaining(ERROR_MESSAGE);
    }

}
