package bridge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    void isDigit() {
        assertSimpleTest(() -> {
            InputView test = new InputView();
            String input = "3wq\n1";
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            test.readBridgeSize();
        });
    }

}
