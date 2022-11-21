package bridge.controller;

import bridge.domain.Bridge;

public class GameController {
    RoundController roundController;
    int roundCnt;
    boolean isCorrect;

    public boolean start(Bridge bridge){
        roundCnt = 0;
        roundController = new RoundController();

        do{
            isCorrect = roundController.start(roundCnt, bridge);
            roundCnt++;
        } while(isCorrect && roundCnt < bridge.getSize() ); // 정답이면

        return isCorrect;
    }
}
