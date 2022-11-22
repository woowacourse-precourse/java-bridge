package bridge.controller;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest extends NsTest {

    private GameController gameController = new GameController();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("R과 Q를 입력하면 테스트가 통과한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 재시작_입력_통과_테스트(String input){
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);
        assertSimpleTest(() -> {
            gameController.retryCommand();
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @DisplayName("U와 D를 입력하면 통과한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 다리_선택_입력_통과_테스트(String input){
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);
        assertSimpleTest(() -> {
            gameController.moveCommand();
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    protected void runMain() {
        Application.main(new String[]{});
    }

}