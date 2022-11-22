package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {
    private Result result;
    private List<List<String>> expected;

    @BeforeEach
    public void setup() {
        List<String> answer = List.of("U", "D", "U");
        result = new Result(answer);

        expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
    }

    @DisplayName("사용자가 선택한 이동할 칸 반영")
    @ParameterizedTest(name = "{displayName} => {0}, {1}, {2}")
    @CsvSource({"U,O,' '", "D,' ',X"})
    public void addResult(String place, String upSide, String downSide) {
        result.add(place);

        expected.get(0).add(upSide);
        expected.get(1).add(downSide);

        assertThat(result.getResults()).isEqualTo(expected);
    }

    @DisplayName("사용자 입력값 초기화")
    @ParameterizedTest(name = "{displayName} => {0}")
    @CsvSource({"U", "D"})
    public void resultClear(String place) {
        result.add(place);

        result.clear();

        assertThat(result.getResults()).isEqualTo(expected);
    }

    @DisplayName("현재까지 이동 못하는 경우가 있는지 확인")
    @ParameterizedTest(name = "{displayName} => {0}, {1}")
    @CsvSource({"U,false", "D,true"})
    public void checkResultHasFail(String place, boolean expected) {
        result.add(place);

        assertThat(result.hasFail()).isEqualTo(expected);
    }

    @DisplayName("정답과 지금까지 입력한 이동할 칸의 개수가 같은지 확인")
    @Test
    public void checkLengthIsSame() {
        String place = "U";
        result.add(place);

        assertThat(result.isSameLength()).isFalse();
    }
}