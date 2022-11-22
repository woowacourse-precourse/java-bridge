package bridge.service.itf;

import java.util.List;

public interface CheckService {
    String isMatch(List<String> bridgeInfo, int idx, List<String> userDirection);
    String isBetween(List<String> bridgeInfo);
    boolean isSucceed(List<String> bridgeInfo);
    boolean checkCrossable(List<String> bridgeInfo, String direction);
    boolean compare(List<String> bridgeInfo, int idx, String direction);

}
