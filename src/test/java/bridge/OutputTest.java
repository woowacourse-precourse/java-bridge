package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    @DisplayName("예제의 다리 상태 테스트")
    @Test
    void 예제_출력_테스트1() {
        final String output = "[ O |   |   ]\n[   | O | O ]\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> bridgeState = Arrays.asList("U", "D", "D");
        List<String> moveState = Arrays.asList("U", "D", "D");
        Output.printMap(bridgeState, moveState);
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("게임이 성공한 경우 출력 테스트")
    @Test
    void 성공한_경우_테스트() {
        final List<String> bridge = Arrays.asList("U", "U", "D");
        final List<String> move = Arrays.asList("U", "U", "D");
        final int count = 3;
        String result = "게임 성공 여부: 성공\n총 시도한 횟수: " + count + "\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Output.printGameResult(bridge, move, count);
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @DisplayName("게임 시작 메시지 출력 테스트")
    @Test
    void 게임_시작_메시지_출력_테스트() {
        final String result = "다리 건너기 게임을 시작합니다.\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Output.printGameStart();
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @DisplayName("다리 길이 입력 메시지 출력 테스트")
    @Test
    void 다리_길이_입력_메시지_출력_테스트() {
        final String result = "다리의 길이를 입력해주세요.\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Output.printReadBridgeSize();
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @DisplayName("이동 위치 입력 메시지 출력 테스트")
    @Test
    void 이동_위치_입력_메시지_출력_테스트() {
        final String result = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Output.printReadMove();
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @DisplayName("새 줄 출력 테스트")
    @Test
    void 새_줄_출력_테스트() {
        final String result = "\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Output.printNewLine();
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @DisplayName("게임 재시작 메시지 출력 테스트")
    @Test
    void 게임_재시작_메시지_출력_테스트() {
        final String result = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Output.printGameReStart();
        assertThat(outputStream.toString()).isEqualTo(result);
    }
}