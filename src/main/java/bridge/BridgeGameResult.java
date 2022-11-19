package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {

    private final List<String> bridgeGameResult = new ArrayList<>();
    private String List1 = "";
    private String List2 = "";

    public BridgeGameResult(List<String> bridge, List<String> playerInput) {
        checkTop(bridge, playerInput);
    }

    public void checkTop(List<String> bridge, List<String> playerInput) {
        for (int i = 0; i < playerInput.size(); i++) {
            if (i != 0) {
                List1 += "|";
            }
            List1 += makeTopResult(bridge.get(i), playerInput.get(i));
        }
    }

    public String makeTopResult(String bridge, String playInput) {
        if (bridge.equals("U") && playInput.equals("U")) {
            return " O ";
        }
        if (bridge.equals("U") && playInput.equals("D")) {
            return " X ";
        }
        return "   ";
    }

}
