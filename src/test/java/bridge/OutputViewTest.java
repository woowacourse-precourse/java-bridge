package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void printMap() {

    }

    @Test
    void checkIndex() {

        List<List<String>> result = outputView.checkIndex(BirdgeMoveType.upGoMovement);

        assertThat(outputView.printMapBorder(result).get(0)).contains("[ O ]");

        //List[0] Up했을때 리스트 | [1] down리스트
    }

    @Test
    void printMapBorder() {
    }
}