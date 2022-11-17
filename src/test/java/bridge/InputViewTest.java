package bridge;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    void 다리_길이_범위_밖의_숫자_입력 () {
        InputView input = new InputView();
        String bridgeSize = "2";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 다리_길이_숫자_외의_문자_입력 () {
        InputView input = new InputView();
        String bridgeSize = ";";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 이동할_칸_다른_문자_입력 () {
        InputView input = new InputView();
        String bridgeSize = "P";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 이동할_칸_공백_함께_입력 () {
        InputView input = new InputView();
        String bridgeSize = "U ";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 재시작_커맨드_다른_문자_입력 () {
        InputView input = new InputView();
        String bridgeSize = "U ";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readGameCommand)
                .isInstanceOf(NoSuchElementException.class);
    }
}
