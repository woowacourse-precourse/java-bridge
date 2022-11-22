package bridge.controller;

import bridge.dto.CorrectInfo;
import bridge.dto.GameOverStatus;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;
import bridge.service.BridgeService;

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
        List<String> bridge = startGame();
        GameOverStatus gameOverStatus = playGame(bridge);
        endGame( gameOverStatus.getBridge(),
                gameOverStatus.isSuccess(),gameOverStatus.getPlayCount());
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
        while(true) {
            try {
                String playContinue = inputView.readGameCommand();
                return bridgeService.makeContinueMessage(playContinue);
            } catch(IllegalArgumentException e){
                System.out.println(e);
            }
        }
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
        while(true) {
            try {
                String userInput = inputView.readMoving();
                return bridgeService.makeCorrectInfo(block, userInput);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> startGame(){
        while(true) {
            try {
                System.out.println(GAME_START.getMessage() + "\n");
                return makeBridge();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> makeBridge(){
        String length = inputView.readBridgeSize();
        return bridgeService.makeBridge(length);
    }
}
