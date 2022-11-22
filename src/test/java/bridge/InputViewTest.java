package bridge;

import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends NsTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("게임의 진행 상항을 확인")
    void 게임의_진행_상항을_확인(){
        outputView.printMap("[ O |   | X ]\n[   | O |   ]");
        assertThat(output()).isEqualTo("[ O |   | X ]\n[   | O |   ]");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
