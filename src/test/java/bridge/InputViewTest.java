package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends CustomNsTest {

    public static final InputView inputView = new InputView();
    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리의 사이즈를 입력받는지 테스트")
    void readBridegeSizeTest() {

        //1 ~ 20범위를 넘었을 경우(에러)
        {
            command("21");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //1 ~ 20범위가 넘어갔을 경우(에러)
        {
            command("0");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //앞에 기호가 들어갔을 경우(에러)
        {
            command("+1");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //앞에 기호가 들어갔고 음수일 경우(에러)
        {
            command("-1");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //맨 앞에 0이 있을 경우(에러)
        {
            command("05");
            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //정상된 값을 넣을 경우
        {
            command("5");
            assertThat(inputView.readBridgeSize())
                    .isEqualTo(5);
        }
    }

    @Test
    @DisplayName("사용자가 이동할 칸을 입력받는지 테스트")
    void readMovingTest() {
        //잘못된 값을 넣을 경우(에러)
        {
            command("A");
            inputView.readMoving();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //U를 두번 넣을 경우(에러)
        {
            command("UU");
            inputView.readMoving();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //D를 두번 넣을 경우(에러)
        {
            command("DD");
            inputView.readMoving();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //정상 값을 넣을 경우
        {
            command("U");
            assertThat(inputView.readMoving())
                    .isEqualTo("U");
        }

        //정상 값을 넣을 경우
        {
            command("D");
            assertThat(inputView.readMoving())
                    .isEqualTo("D");
        }
    }

    @Test
    @DisplayName("사용자가 리트라이 여부를 입력받는지 테스트")
    void readGameCommand() {
        //잘못된 값을 넣을 경우(에러)
        {
            command("A");
            inputView.readGameCommand();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //R을 두번 넣을 경우(에러)
        {
            command("RR");
            inputView.readGameCommand();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //Q를 두번 넣을 경우(에러)
        {
            command("QQ");
            inputView.readGameCommand();
            assertThat(output()).contains(ERROR_MESSAGE);
        }

        //정상 값을 넣을 경우
        {
            command("R");
            assertThat(inputView.readGameCommand())
                    .isEqualTo("R");
        }

        //정상 값을 넣을 경우
        {
            command("Q");
            assertThat(inputView.readGameCommand())
                    .isEqualTo("Q");
        }
    }
}