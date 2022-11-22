package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


class RefereeTest {

    Referee referee = new Referee();


    @Test
    void makeResult_두_리스트가_같음() {
        List<String> path1 = Arrays.asList("U", "U", "D");
        List<String> path2 = Arrays.asList("U", "U", "D");
        boolean result = referee.makeResult(path1, path2);

        assertThat(result).isTrue();
    }

    @Test
    void makeResult_두_리스트가_다름() {
        List<String> path1 = Arrays.asList("U", "U", "D");
        List<String> path2 = Arrays.asList("U", "D", "D");
        boolean result = referee.makeResult(path1, path2);

        assertThat(result).isFalse();
    }

    @Test
    void convertResult_성공_결과_반환() {
        List<String> path1 = Arrays.asList("U", "U", "D");
        List<String> path2 = Arrays.asList("U", "U", "D");
        String result = referee.convertResult(path1, path2);

        assertThat(result).isEqualTo("성공");
    }
    @Test
    void convertResult_실패_결과_반환() {
        List<String> path1 = Arrays.asList("U", "U", "D");
        List<String> path2 = Arrays.asList("U", "D", "D");
        String result = referee.convertResult(path1, path2);

        assertThat(result).isEqualTo("실패");
    }
    @Test
    void makeComparePath_결과_리스트_반환() {
        List<String> path1 = Arrays.asList("U", "U", "D");
        List<String> path2 = Arrays.asList("U", "U", "U");
        String[][] resultList = referee.makeComparePath(path1, path2);

        assertThat(resultList[0]).containsExactly("O","O"," ");
        assertThat(resultList[1]).containsExactly(" "," ","X");
    }
}