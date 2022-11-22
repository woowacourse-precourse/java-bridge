package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.SuccessFail;
import bridge.domain.UserCharacters;
import bridge.dto.BridgeStatusDto;
import bridge.dto.CurrentStatusDto;
import bridge.dto.RetrySatutsDto;
import bridge.dto.SuccessOrFailureDto;
import bridge.reader.SuccessReader;

public class BridgeGameService implements Serivce {
    private SuccessReader successReader = new SuccessReader();
    private BridgeGame bridgeGame;
    private UserCharacters userCharacter;
    private BridgeMaker bridgeMaker;

    public BridgeGameService(BridgeGame bridgeGame,UserCharacters userCharacters,BridgeMaker bridgeMaker) {
        this.bridgeGame=bridgeGame;
        this.userCharacter = userCharacters;
        this.bridgeMaker = bridgeMaker;
    }

    @Override
    public void saveBridge(int size) {
        bridgeGame.addBridge(bridgeMaker.makeBridge(size));
    }

    @Override
    public CurrentStatusDto move(String direction) {
        userCharacter.move(direction);
        bridgeGame.move(userCharacter.getFootPrintLastIndex());
        if(isOverallSuccess()){
            return new CurrentStatusDto(makeSuccessBridgeStatusDto(), SuccessFail.OverallSuccess);
        }
        if (isUnitSuccess()) {
            return new CurrentStatusDto(makeSuccessBridgeStatusDto(), SuccessFail.UNIT_SUCCESS);
        }
        return new CurrentStatusDto(makeFailBridgeStatusDto(),SuccessFail.FAIL);
    }

    @Override
    public RetrySatutsDto isRetry(String restartCommand) {
        if (bridgeGame.retry(restartCommand)) {
            userCharacter.clearFootprints();
            return new RetrySatutsDto(new BridgeStatusDto(new SuccessOrFailureDto("",""),0),true);
        }
        return new RetrySatutsDto(makeFailBridgeStatusDto(),false);
    }

    private boolean isOverallSuccess() {
        return successReader.isOverallSuccess(userCharacter.getFootprints(), bridgeGame.getBridge());
    }

    private boolean isUnitSuccess() {
        return successReader.isSuccess(userCharacter.getLastItem(), bridgeGame.getLastItem());
    }

    private BridgeStatusDto makeSuccessBridgeStatusDto() {
        return BridgeStatusDto.makeBrideStatus(userCharacter.createSuccessDto(), bridgeGame.getCount());
    }

    private BridgeStatusDto makeFailBridgeStatusDto() {
        return BridgeStatusDto.makeBrideStatus(userCharacter.createFailDto(), bridgeGame.getCount());
    }
}
