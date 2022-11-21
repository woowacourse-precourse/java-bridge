package bridge.controller;

import bridge.dto.CorrectInfo;
import bridge.dto.GameOverStatus;
import bridge.global.BridgeMessage;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;
import bridge.global.ErrorMessage;
import bridge.service.BridgeService;

import java.util.ArrayList;
import java.util.List;

import static bridge.global.BridgeMessage.*;

public class BridgeController {

    private final BridgeService bridgeService;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        this.bridgeService = new BridgeService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playBridgeGame(){
        try{
            List<String> bridge = startGame();
            GameOverStatus gameOverStatus = playGame(bridge);
            endGame( gameOverStatus.getBridge(),
                    gameOverStatus.isSuccess(),gameOverStatus.getPlayCount());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void endGame(List<CorrectInfo> bridge, boolean success, int playCount) {
        System.out.println(GAME_END.getMessage());
        System.out.println(outputView.printResult(bridge, success, playCount));
    }

    private GameOverStatus playGame(List<String> bridge) {
        int playCount = 1;
        while(true){
            List<CorrectInfo> correctInfos = userGuess(bridge);
            if(isSuccess(bridge,correctInfos)){
                return new GameOverStatus(true, correctInfos,playCount);
            }else if(!isContinue()){
                return new GameOverStatus(false, correctInfos,playCount);
            }
            playCount++;
        }
    }

    private boolean isSuccess(List<String> bridge, List<CorrectInfo> correctInfos){
        if(bridge.size() != correctInfos.size()){
            return false;
        }
        CorrectInfo lastInfo = correctInfos.get(correctInfos.size() - 1);
        return lastInfo.isPass();
    }

    private boolean isContinue(){
        String playContinue = inputView.readGameCommand();
        return bridgeService.makeContinueMessage(playContinue);
    }

    private List<CorrectInfo> userGuess(List<String> bridge) {
        List<CorrectInfo> correctInfos = bridgeService.initUserInput();
        for (String block : bridge) {
            CorrectInfo correctInfo = getCorrectInfo(block);
            correctInfos.add(correctInfo);
            System.out.println(outputView.printMap(correctInfos));
            if(correctInfo.isFail()){
                break;
            }
        }
        return correctInfos;
    }

    private CorrectInfo getCorrectInfo(String block) {
        String userInput = inputView.readMoving();
        CorrectInfo correctInfo = bridgeService.makeCorrectInfo(block, userInput);
        return correctInfo;
    }

    private List<String> startGame(){
        System.out.println(GAME_START.getMessage()+"\n");
        return makeBridge();
    }

    private List<String> makeBridge(){
        String length = inputView.readBridgeSize();
        return bridgeService.makeBridge(length);
    }


}
