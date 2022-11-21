package bridge.view;

import bridge.model.domain.SuccessOrFail;
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

    @Test
    void 게임결과_크기3_재시도1회_성공_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0);
        SuccessOrFail success = SuccessOrFail.SUCCESS;
        int retryCount = 1;

        outputView.printResult(bridgeMap, success, retryCount);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("최종 게임 결과\n" + "[ O |   |   ]\n" + "[   | O | O ]\n" + "\n" + "게임 성공 여부: 성공\n" + "총 시도한 횟수: 1");
    }

    @Test
    void 게임결과_크기4_재시도2회_성공_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0, 1);
        SuccessOrFail success = SuccessOrFail.SUCCESS;
        int retryCount = 2;

        outputView.printResult(bridgeMap, success, retryCount);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("최종 게임 결과\n" + "[ O |   |   | O ]\n" + "[   | O | O |   ]\n" + "\n" + "게임 성공 여부: 성공\n" + "총 시도한 횟수: 2");
    }

    @Test
    void 게임결과_크기5_재시도3회_실패_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0, 1, 0);
        SuccessOrFail success = SuccessOrFail.FAIL;
        int retryCount = 3;

        outputView.printResult(bridgeMap, success, retryCount);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("최종 게임 결과\n" + "[ O |   |   | O | X ]\n" + "[   | O | O |   |   ]\n" + "\n" + "게임 성공 여부: 실패\n" + "총 시도한 횟수: 3");
    }

    @Test
    void 게임결과_크기6_재시도4회_실패_출력결과() {
        List<Integer> bridgeMap = List.of(1, 0, 0, 1, 0, 0);
        SuccessOrFail success = SuccessOrFail.FAIL;
        int retryCount = 4;

        outputView.printResult(bridgeMap, success, retryCount);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("최종 게임 결과\n" + "[ O |   |   | O |   | X ]\n" + "[   | O | O |   | O |   ]\n" + "\n" + "게임 성공 여부: 실패\n" + "총 시도한 횟수: 4");
    }
}