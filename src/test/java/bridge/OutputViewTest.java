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
    @DisplayName("다리의 길이를 요구하는 문구를 출력한다.")
    @Test
    void printAskLength() {
        OutputView outputView = new OutputView();

        outputView.printAskLengthPhrases();

        assertThat(output()).isEqualTo("다리의 길이를 입력해주세요.");
    }
    @DisplayName("칸 선택시 표시할 문구를 출력한다.")
    @Test
    void printChoice() {
        OutputView outputView = new OutputView();

        outputView.printChoicePhrases();

        assertThat(output()).isEqualTo("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    @Override
    protected void runMain() {
    }
}