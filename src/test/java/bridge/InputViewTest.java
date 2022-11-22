package bridge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("3~20 사이의 bridgeSize 를 입력받아 int 값으로 리턴한다.")
    @Test
    void readBridgeSize() {
        //given
        InputView inputView = new InputView();
        int bridgeSize = 0;

        //when

        for (int i = 3; i < 21; i++) {
            String input = i+"";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            bridgeSize = inputView.readBridgeSize();

        //then
            Assertions.assertThat(bridgeSize).isEqualTo(i);
        }



    }

    @DisplayName("U 를 입력받아 검증후 리턴한다.")
    @Test
    void readMovingIsU() {
        //given
        InputView inputView = new InputView();

        String input = "U";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String readMoving = inputView.readMoving();

        //then
        Assertions.assertThat(readMoving).isEqualTo(input);
    }

    @DisplayName("D 를 입력받아 검증후 리턴한다.")
    @Test
    void readMovingIsD() {
        //given
        InputView inputView = new InputView();

        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String readMoving = inputView.readMoving();

        //then
        Assertions.assertThat(readMoving).isEqualTo(input);
    }

    @DisplayName("R 을 입력받아 검증후 이를 리턴한다.")
    @Test
    void readGameCommandIsR() {
        //given
        InputView inputView = new InputView();

        String input = "R";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String gameCommand = inputView.readGameCommand();

        //then
        Assertions.assertThat(gameCommand).isEqualTo(input);
    }

    @DisplayName("Q 를 입력받아 검증후 이를 리턴한다.")
    @Test
    void readGameCommandIsQ() {
        //given
        InputView inputView = new InputView();

        String input = "Q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String gameCommand = inputView.readGameCommand();

        //then
        Assertions.assertThat(gameCommand).isEqualTo(input);
    }
}