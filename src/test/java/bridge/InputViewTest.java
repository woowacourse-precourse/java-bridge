package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest extends NsTest {
    private static InputView input;
    @BeforeAll
    static void initialize(){
        input = new InputView();
    }
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void testInput(String example){
        InputStream stdin = System.in;

        InputStream stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        assertThat(input.readMoving()).isEqualTo(example);

        System.setIn(stdin);
    }
    @Test
    void testInputNull(){
        String example = "";
        InputStream stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));

        System.setIn(stream);
        assertThatThrownBy(()-> input.readMoving()).isInstanceOf(RuntimeException.class);

        InputStream stdin = System.in;
        System.setIn(stdin);
    }

    @Test
    void testWrongMove(){
        String example = "a";
        InputStream stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));

        System.setIn(stream);
        assertThatThrownBy(()-> input.readMoving()).isInstanceOf(RuntimeException.class);

        InputStream stdin = System.in;
        System.setIn(stdin);
    }
    @Override
    protected void runMain() {

    }
}
