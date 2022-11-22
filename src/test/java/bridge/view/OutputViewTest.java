package bridge.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void toStringWithPath_출력_형식에_맞는_반환값() {
        String[] testPath = {"U", "D", "D", "U"};

        String result = outputView.toStringWithPath(testPath);
        assertThat(result).isEqualTo("[ U | D | D | U ]");
    }
}