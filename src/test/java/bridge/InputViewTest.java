package bridge;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class InputViewTest {

    private static final InputView inputView = new InputView();

    @DisplayName("다리 사이즈를 입력받아서 반환")
    @Test
    void inputBridgeSize() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

}
