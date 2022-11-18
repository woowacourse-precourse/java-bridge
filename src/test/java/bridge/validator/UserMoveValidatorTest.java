package bridge.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserMoveValidatorTest {

    @Test
    void 사용자_이동_U나_D가_아닌경우_테스트() {
        assertThatThrownBy(()->UserMoveValidator.runUserMoveValidator("A"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}