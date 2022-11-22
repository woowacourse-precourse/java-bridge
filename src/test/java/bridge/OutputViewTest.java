package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : bridge
 * fileName : OutputViewTest
 * author : gim-yeong-geun
 * date : 2022/11/22
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/22         gim-yeong-geun          최초 생성
 */
class OutputViewTest {

    @DisplayName("[ O | O | X ] 가 출력된다.")
    @Test
    void printUpperMap() {
        List<String> bridge = List.of("U", "U", "D");
        List<String> moveMapList = List.of("O", "O" , "X");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new OutputView().printUpperMap(bridge, moveMapList);
        assertThat(out.toString()).contains(
                "[ O | O | X ]"
        );
    }

    @DisplayName("[ O | O |   ] 가 출력된다.")
    @Test
    void printLowerMap() {
        List<String> bridge = List.of("D", "D", "D");
        List<String> moveMapList = List.of("O", "O" , "X");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new OutputView().printLowerMap(bridge, moveMapList);
        assertThat(out.toString()).contains(
                "[ O | O |   ]"
        );
    }

    @DisplayName("게임 시도가 성공하고 시도한 횟수가 1회 출력된다.")
    @Test
    void printResult() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new OutputView().printResult();
        assertThat(out.toString()).contains(
                "게임 성공 여부: ", "성공",
                "총 시도한 횟수: ", "1"
        );
    }
}