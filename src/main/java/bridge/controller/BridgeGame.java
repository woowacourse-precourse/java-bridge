package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Result;
import bridge.util.Constants;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private OutputView outputView;
    private InputView inputView;
    private Bridge bridge;
    private Result result;
    private int tryCount;

    public BridgeGame(){
        this.outputView=new OutputView();
        this.inputView=new InputView();
        this.result=new Result();
        tryCount=0;
    }
    public void gameStart(){
        outputView.printStartGame();
        int bridgeSize=setBridgeSize();
        System.out.println(bridge.getBridge());
        move(bridgeSize);
    }
    public int setBridgeSize(){
        String bridgeSize=inputView.readBridgeSize();
        if(Validator.isDigit(bridgeSize) && Validator.checkRange(bridgeSize)){
            makeBridge(Integer.parseInt(bridgeSize));
        }
        return Integer.parseInt(bridgeSize);
    }
    public void makeBridge(int bridgeSize){
        BridgeMaker bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge=new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int bridgeSize) {
        tryCount++;
        boolean success=true;
        for(int i=0; i<bridgeSize; i++) {
            if (moveOne(i).equals(Constants.WRONG)) {
                success=false;
                break;
            }
        }
        finalResult(success, tryCount);
    }
    public void finalResult(boolean success, int tryCount){
        boolean quit=true;
        if(!success) quit=isQuit();
        if(quit || success)
            outputView.printResult(result.getPlayResult(),success, tryCount);
        if(!quit) retry();
    }
    public String moveOne(int index){
        String moving=inputView.readMoving();
        Validator.checkMoving(moving);
        String movingResult=bridge.getMoveResult(moving, index);
        result.addResult(moving, movingResult);
        outputView.printMap(result.getPlayResult());
        return movingResult;
    }
    public boolean isQuit(){
        String retry=inputView.readGameCommand();
        Validator.checkRetryOrQuit(retry);
        if(retry.equals(Constants.QUIT)) return true;
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result=new Result();
        move(bridge.getBridgeSize());
    }
}
