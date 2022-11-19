package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    @DisplayName("3에서 20 사이의 다리 길이가 입력되었을 때, 정상적으로 값을 읽어들여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "10", "15", "20"})
    public void 다리_길이_입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        int length = inputView.readBridgeSize();

        assertThat(length).isEqualTo(Integer.parseInt(input));
    }
}
