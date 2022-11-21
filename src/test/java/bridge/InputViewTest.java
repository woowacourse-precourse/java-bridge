package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @DisplayName("숫자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1a 11", "122 3", "aaa 10"})
    public void 숫자_입력_테스트(String input) {
        String inputError  = input.split(" ")[0];
        String inputNormal = input.split(" ")[1];
        run(inputError, inputNormal);
        assertThat(output()).contains("[ERROR] 다리 길이는");
    }

    @DisplayName("움직임 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"5 a U", "5 a D", "5 5 U"})
    public void move_입력_테스트(String input) {
        String[] inputs = input.split(" ");
        run(inputs[0], inputs[1], inputs[2]);
        assertThat(output()).contains("[ERROR]");
        assertThat(output()).contains("하나의");
    }

    public void runMain() { Application.main(new String[]{}); }
}
