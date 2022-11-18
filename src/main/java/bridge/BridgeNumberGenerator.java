package bridge;

@FunctionalInterface
public interface BridgeNumberGenerator {
    int generate();
    static String numTostring(){
        return "a";
    }
}
