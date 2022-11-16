package bridge.view;

import bridge.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {

    public static InputStream generateUserInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }
    @Test
    @DisplayName("다리의 길이를 입력받는다.")
    void 다리의_길이를_입력받는다(){
        //given
        InputView inputView = new InputView();
        InputStream in = generateUserInput("3");
        System.setIn(in);

        //when
        int bridgeLength = inputView.readBridgeSize();

        //then
        assertThat(bridgeLength).isEqualTo(3);
    }
}
