package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends NsTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("게임의 진행 상항을 확인")
    void 게임의_진행_상항을_확인(){
        List<String> map = List.of("O"," ","X");
        outputView.printMap(map);
        assertThat(output()).isEqualTo("[ O |   | X ]");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
