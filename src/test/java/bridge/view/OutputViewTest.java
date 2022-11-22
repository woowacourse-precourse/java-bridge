package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class OutputViewTest {

    private static final String GAME_START_MESSAGE_TEST = "다리 건너기 게임을 시작합니다.\n";

    @DisplayName("다리 건너기 게임 시작 문구 출력 테스트입니다.")
    @Test
    public void printGameStartMessageTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView.printGameStartMessage();

        Assertions.assertThat(out.toString()).isEqualTo(GAME_START_MESSAGE_TEST);
    }
}
