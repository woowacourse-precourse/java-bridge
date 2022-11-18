package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends CustomNsTest{

    public static final InputView inputView = new InputView();
    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리의 사이즈를 입력받는지 테스트")
    void readBridegeSizeTest() {

        //잘못된 동작
        {
            command("21");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //잘못된 동작
        {
            command("0");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //잘못된 동작
        {
            command("+1");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //잘못된 동작
        {
            command("-1");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //잘못된 동작
        {
            command("05");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //정상 동작
        {
            command("5");
            inputView.readBridgeSize();
            assertThat(output().contains(ERROR_MESSAGE));
        }
    }

}