package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("3에서 20 사이의 숫자 외에 공백, 한글 등 조건에 맞지 않는 값이 입력되면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "22222222222222222222222222", "-1", "기", "aa", "2", "\n"})
    public void 잘못된_다리_길이_입력에_대한_예외_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("U 또는 D의 입력 방향을 입력했을 때, 정상적으로 값을 읽어들여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    public void 이동_방향_입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        String direct = inputView.readMoving();

        assertThat(direct).isEqualTo(input);
    }

    @DisplayName("U, D 이외의 값이 이동 방향으로 입력되면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "UU", "DD", "UD", "u", "d", "111111111111111111", "\n"})
    public void 잘못된_이동_방향_입력에_대한_예외_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] U 또는 D만 입력 가능합니다.");
    }

    @DisplayName("게임 재시작 여부에 대한 입력 값이 R 또는 Q일 때, 정상적으로 값을 읽어들여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    public void 게임_재시작_여부_입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        String restartOrNotInput = inputView.readGameCommand();

        assertThat(restartOrNotInput).isEqualTo(input);
    }
}
