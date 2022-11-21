package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameRetry;

import java.util.*;
public class BridgeService {

    static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static final BridgeGame bridgeGame = new BridgeGame(0,0);
    static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    static final InputValidation inputValidation = new InputValidation();
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();
    
    public boolean isValidBridgeLengthInput(String bridgeLength){
        if(!inputValidation.isNumber(bridgeLength)){
            outputView.printNotNumberBridgeLengthInputErrorMessage();
            return false;
        }
        if(!inputValidation.isValidRange(Integer.parseInt(bridgeLength))){
            outputView.printInValidRangeBridgeLengthErrorMessage();
            return false;
        }
        return true;
    }




}
