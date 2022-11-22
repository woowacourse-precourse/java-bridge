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

    @DisplayName("[ O | O | X ] 가 출력된다")
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

    @Test
    void printLowerMap() {
    }

    @Test
    void printResult() {
    }
}