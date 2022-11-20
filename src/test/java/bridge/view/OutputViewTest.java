package bridge.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private final OutputView outputView = new OutputView();
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void 크기3_성공_다리의_상태_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0);
        boolean isRightLastBridgePick = true;

        outputView.printMap(bridgeMap, isRightLastBridgePick);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("[ O |   |   ]\n" + "[   | O | O ]\n" + "\n");
    }

    @Test
    void 크기4_성공_다리의_상태_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0, 1);
        boolean isRightLastBridgePick = true;

        outputView.printMap(bridgeMap, isRightLastBridgePick);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("[ O |   |   | O ]\n" + "[   | O | O |   ]\n" + "\n");
    }

    @Test
    void 크기5_실패_다리의_상태_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0, 1, 0);
        boolean isRightLastBridgePick = false;

        outputView.printMap(bridgeMap, isRightLastBridgePick);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("[ O |   |   | O | X ]\n" + "[   | O | O |   |   ]\n" + "\n");
    }

    @Test
    void 크기6_실패_다리의_상태_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0, 1, 0, 0);
        boolean isRightLastBridgePick = false;

        outputView.printMap(bridgeMap, isRightLastBridgePick);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("[ O |   |   | O |   | X ]\n" + "[   | O | O |   | O |   ]\n" + "\n");
    }
}