package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setOutputView() {
        outputView = new OutputView();
    }

    @ParameterizedTest
    @CsvSource({"true,성공", "false,실패"})
    void 성공_여부_테스트(boolean isSuccess, String SuccessPhrase) {
        String input = outputView.getSuccessPhrase(isSuccess);
        assertThat(input).isEqualTo(SuccessPhrase);
    }

    @Test
    void 이동_결과_만들기_테스트() {
        String input = outputView.makeIndex(Arrays.asList("O", " ", "O"));
        String expected = "[ O |   | O ]";
        String input2 = outputView.makeIndex(Arrays.asList("O", "O", " "));
        String expected2 = "[ O | O |   ]";
        assertThat(input).isEqualTo(expected);
        assertThat(input2).isEqualTo(expected2);
    }
}