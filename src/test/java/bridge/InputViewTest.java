package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class InputViewTest {

    @DisplayName("입력받은 다리의 길이가 3 이상 20이하이면 정상적으로 입력된다.")
    @Test
    void readBridgeSize_Success() {

        // given
        List<String> userInputList = new ArrayList<>();
        for (int input = 3; input <= 20; input++) {
            userInputList.add(String.valueOf(input));
        }

        InputView inputView = new InputView();

        // when
        List<Integer> resultList = new ArrayList<>();
        for (String userInput : userInputList) {
            InputStream in = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(in);

            int bridgeSize = inputView.readBridgeSize();
            resultList.add(bridgeSize);
        }

        // then
        assertThat(resultList)
                .containsExactly(
                        3, 4, 5, 6, 7, 8,
                        9, 10, 11, 12, 13, 14,
                        15, 16, 17, 18, 19, 20
                );
    }

    @DisplayName("입력받은 다리의 길이가 3보다 작으면 null을 반환한다.")
    @Test
    void readBridgeSize_smallThan_3_Failed() {
        // given
        InputView inputView = new InputView();
        String userInput = "2";

        // when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // then
        assertThat(inputView.readBridgeSize()).isNull();

    }

    @DisplayName("입력받은 다리의 길이가 20보다 크면 null을 반환한다.")
    @Test
    void readBridgeSize_biggerThan_20_Failed() {
        // given
        InputView inputView = new InputView();
        String userInput = "21";

        // when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // then
        assertThat(inputView.readBridgeSize()).isNull();
    }

    @DisplayName("입력받은 문자가 R이면 정상적으로 입력된다.")
    @Test
    void readCommandLine_R_Success() {

        // given
        InputView inputView = new InputView();
        String userInput = "R";

        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        String gameCommand = inputView.readGameCommand();

        // then
        assertThat(gameCommand).isEqualTo("R");
    }

    @DisplayName("입력받은 문자가 Q이면 정상적으로 입력된다.")
    @Test
    void readCommandLine_Q_Success() {

        // given
        InputView inputView = new InputView();
        String userInput = "Q";

        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        String gameCommand = inputView.readGameCommand();

        // then
        assertThat(gameCommand).isEqualTo("Q");
    }

    @DisplayName("입력받은 명령어 문자열의 크기가 1보다 크면 null을 반환한다.")
    @Test
    void readGameCommand_biggerThan_1_Failed() {
        // given
        InputView inputView = new InputView();
        String userInput = "RQ";

        // when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // then
        assertThat(inputView.readGameCommand()).isNull();
    }
}
