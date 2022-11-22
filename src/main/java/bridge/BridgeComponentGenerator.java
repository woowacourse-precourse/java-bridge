package bridge;

import java.util.HashMap;

public class BridgeComponentGenerator {
    private HashMap<Integer, String> BridgeComponentMap = new HashMap<>();
    private final Integer UpNumber = 1;
    private final Integer DownNumber = 0;
    private final String Up = "U";
    private final String Down = "D";

    public BridgeComponentGenerator() {
        this.BridgeComponentMap.put(UpNumber, Up);
        this.BridgeComponentMap.put(DownNumber, Down);
    }

    public String generate(int Number) {
        return this.BridgeComponentMap.get(Number);
    }
}
