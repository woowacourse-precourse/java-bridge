package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("다리 길이 입력이 3~20을 벗어나면 오류가 발생한다.")
    @Test
    void 다리_길이_사이즈_테스트(){
        assertThatThrownBy(()-> new InputView().validateOverSize(222))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력에 숫자가 아닌 입력이 들어오면 오류가 발생한다.")
    @Test
    void 다리_길이_숫자여부_테스트(){
        assertThatThrownBy(() -> new InputView().validateisDigit("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
