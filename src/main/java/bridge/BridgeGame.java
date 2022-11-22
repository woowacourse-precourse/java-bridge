package bridge;

import java.util.List;


public class BridgeGame {
    private static List<String> bridge;
    private boolean win;
    private int nowIdx;
    private int tryTimes;
    private String recentInput;

    BridgeGame(){
        this.nowIdx = 0;
        this.tryTimes = 1;
    }

    public void setSize(int size){
        if(size<3||size>20)
            OutputView.errorHandling("3~20 사이의 숫자를 입력해주세요.");
        this.makeBridge(size);
    }

    private void makeBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker (new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean move(String userInput) {
        this.recentInput = userInput;
        if(userInput.equals(bridge.get(nowIdx))){
            if(nowIdx == bridge.size()-1){
                return endGame(userInput);
            }
            nowIdx++;
            return true;
        }
        return false;
    }

    private boolean endGame(String userInput){
        if(userInput.equals(bridge.get(nowIdx))){
            this.win = true;
            return false;
        }
        this.win = false;
        return false;
    }

    public void resetGame(){
        this.nowIdx = 0;
    }

    public boolean retry(String userInput) {
        if(userInput.equals("R")){
            tryTimes++;
            resetGame();
            return true;
        }
        return false;
    }

    public static List<String> getBridge(){
        return bridge;
    }

    public int getTryTimes(){
        return tryTimes;
    }

    public int getNowIdx(){return nowIdx;}

    public boolean getWin(){return win;}

    public String getRecentInput(){return recentInput;}
}
