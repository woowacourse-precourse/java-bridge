package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import bridge.model.Diagram.Status;
import org.junit.jupiter.api.Test;

class DiagramTest {

    @Test
    void 잘_작동하나() {
        Diagram.printDiagrams();
        Diagram.updateDiagram("U", Status.SURVIVE);
    }
}