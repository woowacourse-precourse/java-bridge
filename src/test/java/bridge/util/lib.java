package bridge.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.BridgeNumberGenerator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;

public class lib {

    public static void setInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    } // Scanner에 input을 미리 입력해둔다

    public static void thrownBy(String input, StringFunction sf){
        Assertions.assertThatThrownBy(() -> sf.valid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

}
