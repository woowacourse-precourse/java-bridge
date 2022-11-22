package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {
    private final InputValidate inputValidate = new InputValidate();

    @DisplayName("다리 개수 입력에 3~20이 아닐 시 에러")
    @ParameterizedTest
    @ValueSource(ints = {1,2,21})
    public void inputSizeError(int number){
        assertThatThrownBy(()->inputValidate.validateBridgeSize(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U/D가 아닌 문자가 들어올 시 에러")
    @Test
    public void inputUDError(){
        assertThatThrownBy(()-> inputValidate.validateMove("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R/Q가 아닌 문자가 들어올 시 에러")
    @Test
    public void inputRQError(){
        assertThatThrownBy(()->inputValidate.validateRetry("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
