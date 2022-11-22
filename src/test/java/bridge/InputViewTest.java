package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
            String input = "3wq\n3";
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            test.readBridgeSize();
        });
    }
    @Test
    void invalidRange() {
        assertSimpleTest(() -> {
            InputView test = new InputView();
            String input = "253\n2\n5";
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            test.readBridgeSize();
        });
    }
    @Test
    void isValidMove() {
        assertSimpleTest(() -> {
            InputView test = new InputView();
            String input = "3wq\nUD\nD";
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            test.readMoving();
        });
    }

    @ParameterizedTest
    @ValueSource (strings = {"3wq\nU\nR","Q"})
    void isValidCommand(String input) {
        assertSimpleTest(() -> {
            InputView test = new InputView();
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            test.readGameCommand();
        });
    }
}
