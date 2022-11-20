package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class FunctionTest {
    private static InputView inputView;
    @BeforeAll
    static void initAll() {
        InputView inputView = new InputView();
    }

    @DisplayName("다리 길이 String으로 입력하여 Integer로 반환 테스트")
    @Test
    void 다리_길이_입력_테스트() {
        List<String> strInput = List.of("3", "10");
        List<Integer> intInput = List.of(3,10);

        for (int i = 0; i < 2; i++) {
            InputStream in = new ByteArrayInputStream(strInput.get(i).getBytes());
            System.setIn(in);
            assertThat(inputView.readBridgeSize()).isEqualTo(intInput.get(i));
        }
    }
}
