package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest extends NsTest{
    @Test
    void 이동할_칸_선택_에러_테스트() {
        InputView inputView = new InputView();
        List<String> command = List.of("U", "D");
        assertThatThrownBy(() -> inputView.checkInputInCommend("T", command))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 입력_에러_후_다시_입력_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run("T", "45", "3", "U", "D", "U");
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
