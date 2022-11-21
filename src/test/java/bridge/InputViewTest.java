package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView=new InputView();

    @DisplayName("다리 길이 숫자 아니면 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"abc","a12","1a2b","123a","!!@"})
    public void checkDigitTest(String input) {
        assertThatThrownBy(()->inputView.checkDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 3~20 사이 숫자 아니면 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"123","2","-3","50","21"})
    void checkRangeTest(int input) {
        assertThatThrownBy(()->inputView.checkRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"123","!!","rdx","ㄱㄴㄷ","UD","DD","UU","DU"," "})
    void checkMovingTest(String input) {
        assertThatThrownBy(()->inputView.checkMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 다시 시도 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"123","!!","rdx","ㄱㄴㄷ","RQ","RR","QQ","QR"," "})
    void checkGameCommandTest(String input) {
        assertThatThrownBy(()->inputView.checkGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}