package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    OutputView outputView = new OutputView();
    List<String> bridge = List.of("U", "U", "D");

    @Test
    void addDelimiter() {
        String printed = outputView.addDelimiter(bridge);
        assertEquals(printed, "[U | U | D]");
    }

    @Test
    void convertUpperRow() {
        List<String> upperRow = outputView.convertUpperRow(bridge);
        String printed = outputView.addDelimiter(upperRow);
        assertEquals("[O | O | X]", printed);
    }

    @Test
    void convertLowerRow() {
        List<String> lowerRow = outputView.convertLowerRow(bridge);
        String printed = outputView.addDelimiter(lowerRow);
        assertEquals("[X | X | O]", printed);
    }
}