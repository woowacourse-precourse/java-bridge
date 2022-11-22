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

    @DisplayName("입력받은 다리의 길이가 3보다 작으면 예외를 던진다.")
    @Test
    void readBridgeSize_smallThan_3_Failed() {
        // given
        InputView inputView = new InputView();
        String userInput = "2";

        // when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // then
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위를 벗어난 입력입니다. ");
    }

    @DisplayName("입력받은 다리의 길이가 20보다 크면 예외를 던진다.")
    @Test
    void readBridgeSize_biggerThan_20_Failed() {
        // given
        InputView inputView = new InputView();
        String userInput = "21";

        // when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // then
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위를 벗어난 입력입니다. ");
    }
}
