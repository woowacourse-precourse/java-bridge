package bridge.bridgeDomain.operator;


import java.util.List;

public class BridgeException {

    public boolean checkFail(List<String> bridgeResult) {
        for (int i = 0; i < bridgeResult.size(); i++) {
            if (bridgeResult.get(i).contains("X")) {
                return true;
            }
        }
        return false;
    }

    public int checkSuccess(List<String> bridgeResult) {
        int successCount = 0;
        for (int i = 0; i < bridgeResult.size(); i++) {
            successCount += bridgeResult.get(i).chars()
                    .filter(c -> c == 'O')
                    .count();
        }
        return successCount;
    }

}
