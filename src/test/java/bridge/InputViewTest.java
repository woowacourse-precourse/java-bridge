package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private Validation validation;
    @Test
    @DisplayName("다리 길이에 대한 입력 Integer 변환 - 성공")
    public void Convert_Success() throws Exception{
        validation = new Validation();
        String bridgeSize = "4";
        validation.bridgeLen(bridgeSize);
        Integer len = Integer.parseInt(bridgeSize);
        Assertions.assertThat(len).isEqualTo(4);
    }

    @Test
    @DisplayName("다리 길이에 대한 입력 Integer 변환 - 숫자가 아닌 겨우 변환 실패")
    public void Convert_fail_NotNumber() throws Exception{
        validation = new Validation();
        String bridgeSize = "hi";
        Assertions.assertThatThrownBy(()->
            validation.bridgeLen(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("다리 길이에 대한 입력 Integer 변환 - 3미만 20초과인 경우 변환 실패")
    public void Convert_fail_Range() throws Exception{
        validation = new Validation();
        String bridgeSizeThan = "21";
        Assertions.assertThatThrownBy(()->
            validation.bridgeLen(bridgeSizeThan))
                .isInstanceOf(IllegalArgumentException.class);

        String bridgeSizeLess = "2";
        Assertions.assertThatThrownBy(()->
                        validation.bridgeLen(bridgeSizeLess))
                .isInstanceOf(IllegalArgumentException.class);

    }



}