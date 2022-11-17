package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView = new InputView();


    @Test
    void 다리_크기_사용자_입력_검증() {
        assertThat(inputView.readBridgeSize("5")).isEqualTo(5);
    }

    @Test
    void 다리_크기_숫자가_아닌_사용자_입력() {
        assertThatThrownBy(() -> inputView.readBridgeSize("s"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 '숫자'여야 합니다.");
    }

    @Test
    void 다리_크기_범위_밖_숫자_사용자_입력() {
        assertThatThrownBy(() -> inputView.readBridgeSize("22"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

}