package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest extends NsTest {
    InputView inputView = new InputView();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력 받은 다리 길이가 정수가 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = {"K", " k ", "1K", "K1"})
    void createBridgeSizeIsChar(String command) {
        assertThatThrownBy(() -> inputView.validateIsNumeric(command))
                .isInstanceOf(IllegalArgumentException.class);

    }

    



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
