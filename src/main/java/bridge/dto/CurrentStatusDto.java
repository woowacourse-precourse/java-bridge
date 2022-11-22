package bridge.dto;

import bridge.SuccessFail;

//성공여부와
public class CurrentStatusDto {
    private final BridgeStatusDto bridgeStatusDto;
    private final SuccessFail successFail;

    public CurrentStatusDto(BridgeStatusDto bridgeStatusDto, SuccessFail successFail) {
        this.bridgeStatusDto = bridgeStatusDto;
        this.successFail = successFail;
    }

    public BridgeStatusDto getBridgeStatusDto() {
        return bridgeStatusDto;
    }

    public SuccessFail getSuccessFail() {
        return successFail;
    }
}
