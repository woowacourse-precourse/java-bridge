package bridge;

public class BridgeCharacterGenerator {
    public String generate(int generateNumber) {
        if (generateNumber == 0) {
            return "D";
        }
        return "U";
    }
}
