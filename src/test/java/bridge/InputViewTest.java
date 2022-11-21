package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest{
    @Test
    void 이동할_칸_선택_에러_테스트() {
        InputView inputView = new InputView();
        List<String> command = List.of("U", "D");
        assertThatThrownBy(() -> inputView.checkInputInCommend("T", command))
                .isInstanceOf(IllegalStateException.class);
    }
}
