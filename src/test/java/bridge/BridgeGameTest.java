package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    public void restoreStreams()
    {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("다리 생성시 5를 input할 경우 다리의 사이즈가 5가 나오는지")
    @Test
    void makeBridge()
    {
        String bridgeSize = "5";
        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        try {
        Method method = bridgeGame.getClass().getDeclaredMethod("makeBridge");
        method.setAccessible(true);
            List<String> bridge = (List<String>) method.invoke(bridgeGame);
            assertThat(bridge.size()).isEqualTo(5);
        } catch (Exception e) {}
    }

    @DisplayName("게임 진행시 결과가 제대로 나오는지")
    @Test
    void crossBridge()
    {
        String inputValue = "U\nD\nD\nD\nR\nU\nD\nQ";
        InputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);

        List<String> answerBridge = Arrays.asList(new String[]{"U","D","D","U","U"});
        try{
            Method method = bridgeGame.getClass().getDeclaredMethod("crossBridge", List.class);
            method.setAccessible(true);

            method.invoke(bridgeGame, answerBridge);

            assertThat(output.toString()).contains(
                    "[ O |   |   ]",
                    "[   | O | O ]",

                    "최종 게임 결과",
                    "[ O |   |   |   ]",
                    "[   | O | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

        }catch(Exception e) {}
    }

    @DisplayName("다리 사이즈 input시, 3이상 20이하의 길이를 넣지 않은 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeWrong() {
            String input = "21";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            assertThatThrownBy(() ->
                inputView.readBridgeSize()
            ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 칸 input시, U, D 이외의 문자를 넣은 경우.")
    @Test
    void inputMovingWrong() {
        String input = "M";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() ->
                inputView.readMoving()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 input시, R, Q 이외의 문자를 넣은 경우.")
    @Test
    void input() {
        String input = "S";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() ->
                inputView.readGameCommand()
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
