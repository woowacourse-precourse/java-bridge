package bridge.model;

import org.junit.jupiter.api.Test;

class DiagramTest {

    @Test
    void 잘_작동하나() {
        Diagram.printDiagrams();
        Diagram.paintDiagrams("U", Status.SURVIVE);
    }
}