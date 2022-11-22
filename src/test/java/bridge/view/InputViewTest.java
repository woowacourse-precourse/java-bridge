package bridge.view;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void readBridgeSize_기능테스트() {
        InputStream in = generateUserInput("3");
        System.setIn(in);
        int size = InputView.readBridgeSize();
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bm.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(3);
        System.out.println(bridge.toString());
    }

    @DisplayName("입력 범위를 넘었을 때 에러 확인")
    @Test
    void readBridgeSize_범위넘은_입력() {
        InputStream in = generateUserInput("31");
        System.setIn(in);
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
            assertThatThrownBy(
                    () -> BridgeMaker.makeBridge())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 최소 3이상의 숫자를 적어주세요.");
    }

    @Test
    void readBridgeSize_숫자아닐때() {
        InputStream in = generateUserInput("3!");
        System.setIn(in);
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(
                () -> BridgeMaker.makeBridge())
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR] 최소 3이상의 숫자를 적어주세요.");
    }

    @Test
    void readMoving_기능테스트() {
        InputStream in = generateUserInput("U");
        System.setIn(in);
        assertThat(InputView.readMoving()).isEqualTo("U");
    }

    @Test
    void readMoving_예외테스트() {
        InputStream in = generateUserInput("U");
        System.setIn(in);
        assertThatThrownBy(()->InputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }
}