package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    @DisplayName("사용자가 현재 건넌 다리 출력 함수 테스트")
    @Test
    void printMap() {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(List.of(" "));
        userMap.add(List.of("O"));
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        //when
        System.setOut(new PrintStream(out));
        outputView.printMap(userMap);
        //then
        assertThat(out.toString()).isEqualTo("[   ]\n[ O ]\n\n");
    }
    @DisplayName("위 아래 다리 출력 함수 테스트")
    @Test
    void printUpDown() {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(List.of(" "));
        userMap.add(List.of("O"));
        int upDown = 1;
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        //when
        System.setOut(new PrintStream(out));
        outputView.printUpDown(upDown, userMap);
        //then
        assertThat(out.toString()).isEqualTo("[ O ]\n");
    }
    @DisplayName("최종 게임 결과 출력 함수 테스트")
    @Test
    void printResult() {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(List.of(" "));
        userMap.add(List.of("O"));
        int cnt = 1;
        boolean exitCode = false;
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        //when
        System.setOut(new PrintStream(out));
        outputView.printResult(userMap, cnt, exitCode);
        //then
        assertThat(out.toString().contains("최종 게임 결과") &&
                out.toString().contains("[   ]") &&
                out.toString().contains("[ O ]") &&
                out.toString().contains("게임 성공 여부: 성공") &&
                out.toString().contains("총 시도한 횟수: 1")
        ).isTrue();
    }
}
