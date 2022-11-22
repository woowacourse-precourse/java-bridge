package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    public List<String> bridge = List.of("D", "U", "U", "U");
    public List<String> moves = List.of("D", "U", "D");
    public OutputView outputView = new OutputView();


    @Test
    public void oneWrongAnswerTest() {
        List<String> moves = List.of("U");
        String upLine = outputView.lineMapper(bridge, moves, "U");
        String downLine = outputView.lineMapper(bridge, moves, "D");
        assertEquals(upLine,  "[ X ]" );
        assertEquals(downLine,"[   ]" );
    }
    @Test
    public void oneRightAnswerTest() {
        List<String> moves = List.of("D");
        String upLine = outputView.lineMapper(bridge, moves, "U");
        String downLine = outputView.lineMapper(bridge, moves, "D");
        assertEquals(upLine,  "[   ]" );
        assertEquals(downLine,"[ O ]" );
    }


        @Test
    public void lineMapFormatterTest() {
        String upLine = outputView.lineMapper(bridge, moves, "U");
        String downLine = outputView.lineMapper(bridge, moves, "D");

        assertEquals(upLine, "[   | O |   ]");
        assertEquals(downLine, "[ O |   | X ]");
    }

}