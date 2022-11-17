package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @DisplayName("현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력")
    @Test
    void printMap() {
        StringJoiner upBridge = new StringJoiner(" | ","[ "," ]").add("O").add("X");
        StringJoiner downBridge = new StringJoiner(" | ","[ "," ]").add(" ").add(" ");
        StringJoiner result = new StringJoiner("\n").add(upBridge.toString()).add(downBridge.toString());
        assertThat(outputView.printMap()).isEqualTo(result.toString());
    }

}
