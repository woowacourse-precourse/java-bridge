package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static bridge.view.OutputView.*;

class OutputViewTest {
    private final String MAP = String.join(System.lineSeparator(),
            "[ O |   | X |   ]", "[   | O |   | X ]\n");
    private final String RESULT = String.join(System.lineSeparator(),
            "최종 게임 결과", "[ O |   | X |   ]", "[   | O |   | X ]", "", "게임 성공 여부: 성공", "총 시도한 횟수: 1\n");
    private final List<String> bridgeCorrect1 = List.of("U", "O");
    private final List<String> bridgeCorrect2 = List.of("D", "O");
    private final List<String> bridgeCorrect3 = List.of("U", "X");
    private final List<String> bridgeCorrect4 = List.of("D", "X");
    private final List<List<String>> bridgeCorrects = List.of(bridgeCorrect1, bridgeCorrect2, bridgeCorrect3, bridgeCorrect4);


    @DisplayName("현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력하는지 테스트")
    @Test
    void 현재까지_이동한_다리의_상태를_정해진_형식에_맞춰_출력하는지_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        printMap(bridgeCorrects);

        assertThat(MAP).isEqualTo(out.toString());
    }

    @DisplayName("게임의 최종 결과를 정해진 형식에 맞춰 출력하는지 테스트")
    @Test
    void 게임의_최종_결과를_정해진_형식에_맞춰_출력하는지_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        printResult(bridgeCorrects, "성공", 1);

        assertThat(RESULT).isEqualTo(out.toString());
    }
}