package bridge.service;

import bridge.dto.CurrentStatusDto;
import bridge.dto.RetrySatutsDto;

public interface Serivce {
    void saveBridge(int size);

    CurrentStatusDto move(String direction);

    RetrySatutsDto isRetry(String restartCommand);
}
