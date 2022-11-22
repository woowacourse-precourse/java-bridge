package bridge.controller;

import bridge.SuccessFail;
import bridge.dto.CurrentStatusDto;
import bridge.dto.RetrySatutsDto;
import bridge.mediator.ControllerMediator;
import bridge.dto.BridgeStatusDto;
import bridge.service.Serivce;

import java.util.HashMap;

public class NatureController implements Controller {

    private ControllerMediator mediator;

    private Serivce service;

    public NatureController(ControllerMediator mediator,Serivce service) {
        this.mediator=mediator;
        this.service=service;
    }
    @Override
    public Runnable generateBridge(int size) {
        service.saveBridge(size);
        return () -> mediator.moveBridge();
    }

    @Override
    public Runnable moveBridge(String direction, HashMap<String, String> map) {
        CurrentStatusDto currentStatusDto = service.move(direction);
        BridgeStatusDto bridgeStatusDto = currentStatusDto.getBridgeStatusDto();
        map.put("bridge", bridgeStatusDto.getBridge());

        if (currentStatusDto.getSuccessFail().equals(SuccessFail.OverallSuccess)) {
            return () -> mediator.end(bridgeStatusDto);
        }
        if (currentStatusDto.getSuccessFail().equals(SuccessFail.UNIT_SUCCESS)) return () -> mediator.moveBridge();
        return () -> mediator.replay();
    }

    @Override
    public Runnable replay(String restartCommand) {
        RetrySatutsDto retry = service.isRetry(restartCommand);
        if (retry.isRetryFlag()) {
            return () -> mediator.moveBridge();
        }

        return () -> mediator.end(retry.getBridgeStatusDto());
    }
}
