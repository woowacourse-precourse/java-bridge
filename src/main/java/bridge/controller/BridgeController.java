package bridge.controller;

import bridge.service.BridgeGame;

public class BridgeController {

    private final BridgeGame game;

    public BridgeController(BridgeGame game) {
        this.game = game;
    }

    public void inputBridgeSize(int size){
        game.setBridge(size);
    }

    public void movePlayer(String moveSquare){
        game.move(moveSquare);
    }

    public boolean reOrStopGame(String gameCommand){
        if(gameCommand.equals("R")) {
            game.retry();
            return true;
        }
        game.stop();
        return false;
    }

    public boolean checkGame(){
        return game.isRight();
    }

    public boolean isSame(){
        return game.isSame();
    }

    public String outputPlayerBridge(){
        return game.showPlayerBridgeToString(checkGame());
    }

    public String outputResult(){
        if(game.isSame()) return "성공";
        return "실패";
    }

    public int outputGameCount(){
        return game.getGameCount();
    }
}
