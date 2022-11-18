package bridge;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest  {
    InputView inputView = new InputView();

    @DisplayName("사용자의 입력을 성공적으로 받아들이는 테스트 케이스")
    @Test
    void inputValueSuccess() {
        command("테스트");
        assertThatCode(() -> inputView.readValue()).doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력을 하지 않고 다음 단계로 넘어갈 시 실패하는 테스트 케이스")
    @Test
    void inputValueFail() {
        assertThatThrownBy(() -> inputView.readValue()).isInstanceOf(NoSuchElementException.class);
    }

    // 입력에 대한 테스트를 수행하기 위해 사전에 정의된 NsTest 클래스에서 command 메서드 가져옴
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
