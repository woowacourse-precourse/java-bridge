package bridge.view;

import bridge.domain.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    InputView inputView;


    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 이동할_칸_입력_옳은_경우(String input) {
        inputView = new InputView();

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(input, inputView.readMoving());
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 재시도_여부_입력_옳은_경우(String input) {
        inputView = new InputView();

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(input, inputView.readGameCommand());
    }

}