package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    @Test
    void testInput(){
        InputStream stdin = System.in;

        String example = "U";
        InputStream stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        assertThat(input.readMoving()).isEqualTo("U");

        example = "D";
        stream = new ByteArrayInputStream(example.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);
        assertThat(input.readMoving()).isEqualTo("D");

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
