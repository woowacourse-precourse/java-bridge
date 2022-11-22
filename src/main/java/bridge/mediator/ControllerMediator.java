package bridge.mediator;

import bridge.dto.BridgeStatusDto;

public interface ControllerMediator {

    void moveBridge();

    void replay();

    void end(BridgeStatusDto bridgeStatusDto);
}
