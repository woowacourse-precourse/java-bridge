package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.util.IllegalArgumentExceptionMessage;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/22
 */
public class InputViewTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void readBridgeSizeByCorrect() {
        InputView inputView = new InputView();
        InputStream in = generateUserInput("5");
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(5);
    }
}
