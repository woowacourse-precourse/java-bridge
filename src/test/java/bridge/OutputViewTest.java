package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @DisplayName("시작문구를 출력합니다.")
    @Test
    void printStartPhrases() {
        OutputView outputView = new OutputView();

        outputView.printStartPhrases();

        assertThat(output()).isEqualTo("다리 건너기 게임을 시작합니다.");
    }

    @Override
    protected void runMain() {
    }
}