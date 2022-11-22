package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeTest {

    @DisplayName("예상치 못한 오류로 크기가 3미만, 20초과인 List가 만들어 Bridge를 만들려고 할떄 예외발생")
    @Test
    void 메이커를_통해_만들어진_크기가_유효하지_않을떄_예외발생(){
        Assertions.assertThatThrownBy(()->new Bridge(List.of("1", "1")))
                .isInstanceOf(IllegalStateException.class);

    }

}