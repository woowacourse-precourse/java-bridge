package bridge.service.itf;

import java.util.List;

public interface ResultService {
    String makeMatchResult(List<String> bridgeInf);
    String getMatchResult(List<String> bridgeInfo);
    String getBlankResult(List<String> bridgeInfo);

}
