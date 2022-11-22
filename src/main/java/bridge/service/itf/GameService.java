package bridge.service.itf;

import bridge.type.ResultType;

import java.util.List;

public interface GameService {
    boolean passThisRound(List<String> bridgeInfo);
    boolean askOption();
    boolean checkIsGameFinished(List<String> bridgeInfo, List<String> userDirection);
    ResultType getEndType();
}
