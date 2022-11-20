package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    @DisplayName("다리 길이를 빈 값을 입력시 에러 발생")
    void 다리길이_빈값_테스트(){
        assertThatThrownBy(() -> {
            command("");
            Application.main(new String[]{
                    String.valueOf(new InputView())
            });
        }).hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("다리 길이를 숫자가 아닌 값을 입력시 에러 발생")
    void 다리길이_숫자_테스트(){
        assertThatThrownBy(() -> {
            command("U");
            Application.main(new String[]{
                    String.valueOf(new InputView())
            });
        }).hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("게임 시 규칙에 맞지 않은 값을 입력시 에러 발생")
    void 게임_숫자_테스트(){
        assertThatThrownBy(() -> {
            command("0");
            Application.main(new String[]{
                    String.valueOf(new InputView())
            });
        }).hasMessageContaining(ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("게임 시 빈 값을 입력시 에러 발생")
    void 게임_빈값_테스트(){
        assertThatThrownBy(() -> {
            command("");
            Application.main(new String[]{
                    String.valueOf(new InputView())
            });
        }).hasMessageContaining(ERROR_MESSAGE);
    }


    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
