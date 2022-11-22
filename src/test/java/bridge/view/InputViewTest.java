package bridge.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void 다리길이_입력받기_유요한_데이터_입력(String readSize) {
        // given
        InputStream in = generateConsoleInput(readSize);
        System.setIn(in);

        int expectedSize = 3;

        // when
        int result = InputView.readBridgeSize();

        // then
        assertThat(result).isEqualTo(expectedSize);
        afterSetting();
    }

    @ParameterizedTest
    @ValueSource(strings = "D")
    void 이동_위치_입력_받기(String readMove) {
        // given
        InputStream in = generateConsoleInput(readMove);
        System.setIn(in);

        String expectedPosition = "D";

        // when
        String result = InputView.readMoving();

        // then
        assertThat(result).isEqualTo(expectedPosition);
        afterSetting();
    }

    @ParameterizedTest
    @ValueSource(strings = "R")
    void 재시작_종료_입력_받기(String readMove) {
        // given
        InputStream in = generateConsoleInput(readMove);
        System.setIn(in);

        String expectedPosition = "R";

        // when
        String result = InputView.readGameCommand();

        // then
        assertThat(result).isEqualTo(expectedPosition);
        afterSetting();
    }

    private InputStream generateConsoleInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
    private static void afterSetting() {
        System.setIn(System.in);
    }
}