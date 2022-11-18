package bridge;

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
            assertThat(inputView.readBridgeSize())
                    .isEqualTo(5);
        }
    }

    @Test
    @DisplayName("사용자가 이동할 칸을 입력받는지 테스트")
    void readMovingTest(){
        //비정상 동작
        {
            command("A");
            inputView.readMoving();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //비정상 동작
        {
            command("UU");
            inputView.readMoving();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //비정상 동작
        {
            command("DD");
            inputView.readMoving();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //정상 동작
        {
            command("U");
            assertThat(inputView.readMoving())
                    .isEqualTo("U");
        }

        //정상 동작
        {
            command("D");
            assertThat(inputView.readMoving())
                    .isEqualTo("D");
        }
    }

    @Test
    @DisplayName("사용자가 리트라이 여부를 입력받는지 테스트")
    void readGameCommand(){
        //비정상 동작
        {
            command("A");
            inputView.readGameCommand();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //비정상 동작
        {
            command("RR");
            inputView.readGameCommand();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //비정상 동작
        {
            command("QQ");
            inputView.readGameCommand();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //정상 동작
        {
            command("R");
            assertThat(inputView.readGameCommand())
                    .isEqualTo("R");
        }

        //정상 동작
        {
            command("Q");
            assertThat(inputView.readGameCommand())
                    .isEqualTo("Q");
        }
    }
}