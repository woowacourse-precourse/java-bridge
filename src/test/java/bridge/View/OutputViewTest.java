package bridge.View;

import bridge.domain.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private ArrayList<Field> userBridge = new ArrayList<>();
    private ByteArrayOutputStream byteArrayOutputStream;

//    @BeforeEach
    void setupStreams() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

//    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("맵 출력 테스트")
    @Test
    void printMapTest(){
        userBridge.add(new Field("U",true));
        userBridge.add(new Field("D",true));
        userBridge.add(new Field("U",true));
        userBridge.add(new Field("U",false));
        new OutputView().printMap(userBridge);
    }
}
