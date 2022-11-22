package bridge;

import java.util.List;

public interface BridgeChecker {

    List<String> checkBridgeMatching(List<String> bridge, List<String> userInput);
    List<String> checkUpperBlocks(List<String> matchingResult, List<String> bridge);
    List<String> checkLowerBlocks(List<String> matchingResult, List<String> bridge);
}
