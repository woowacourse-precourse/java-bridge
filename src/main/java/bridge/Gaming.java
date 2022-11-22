package bridge;

import bridge.constants.BridgeConstants;
import bridge.constants.Message;

import java.util.List;

public class Gaming {
    private static List<String> bridge;
    private String upBridgeMap;
    private String DownBridgeMap;
    private int gameTryCount;

    Gaming(List<String> bridge, int turn){
        this.bridge = bridge;
        this.upBridgeMap = Message.EMPTY;
        this.DownBridgeMap = Message.EMPTY;
        this.gameTryCount = turn;
    }
    /** 게임을 시작하는 기능 */
    public int startGame(){
        if (gameLoop(BridgeConstants.LOOP_START_COUNT)){
            new OutputView().printResult(true, this.upBridgeMap, this.DownBridgeMap, this.gameTryCount); return BridgeConstants.ESCAPE_LOOP_NUM;
        }
        /** 건널 수 없는 칸으로 이동했을 시, 게임을 다시 시도할지 여부를 입력받는 기능 */
        if(!new BridgeGame().retry(new InputView().readGameCommand())){
            new OutputView().printResult(false, this.upBridgeMap, this.DownBridgeMap, this.gameTryCount); return BridgeConstants.ESCAPE_LOOP_NUM;
        }
        gameTryCountUp();
        return gameTryCount;
    }
    public boolean gameLoop(int count){
        /** 건널 수 있는 칸으로 이동했을 시, 다리를 끝까지 건넜는지 확인하는 기능 */
        while (count < this.bridge.size()){
            new OutputView().printGetMoving();
            boolean moveResult = new BridgeGame().move(bridge, count, new InputView().readMoving()); // 잘 움직였는지 결과 가져오고
            fillBridgeMap(count, moveResult); // 지도저장
            new OutputView().printMap(upBridgeMap, DownBridgeMap); count++; // 지도 출력
            if (!moveResult) { new OutputView().printGetGameCommand(); return false;}
        }
        return true;
    }
    /** 매 턴마다 결과에 따른 다리 형태를 두 문자열로 저장하는 기능 */
    private boolean fillBridgeMap(int count, boolean moveResult){
        if (count != BridgeConstants.LOOP_START_COUNT) {this.upBridgeMap += BridgeConstants.Dividing_Line; this.DownBridgeMap += BridgeConstants.Dividing_Line;}
        if (moveResult) {fillUpBridgeMapCorrect(count); return true;}
        fillUpBridgeMapIncorrect(count); return true;
    }
    /** 이동할 수 있는 칸을 선택한 경우 O, 이동할 수 없는 칸을 선택한 경우 X 표시하는 기능 */
    private boolean fillUpBridgeMapCorrect(int count){
        if (this.bridge.get(count).equals(BridgeConstants.UP_DIRECTION)){
            this.upBridgeMap += BridgeConstants.RIGHT_ANSWER_IN_MAP; this.DownBridgeMap += BridgeConstants.EMPTY_MAP; return true;
        }
        this.upBridgeMap += BridgeConstants.EMPTY_MAP; this.DownBridgeMap += BridgeConstants.RIGHT_ANSWER_IN_MAP; return true;
    }
    private boolean fillUpBridgeMapIncorrect(int count){
        if (this.bridge.get(count).equals(BridgeConstants.UP_DIRECTION)){
            this.upBridgeMap += BridgeConstants.EMPTY_MAP; this.DownBridgeMap += BridgeConstants.WRONG_ANSWER_IN_MAP; return true;
        }
        this.upBridgeMap += BridgeConstants.WRONG_ANSWER_IN_MAP; this.DownBridgeMap += BridgeConstants.EMPTY_MAP; return true;
    }
    /** 게임을 다시 시작할 시, 총 도전 카운트를 +1 하는 기능 */
    private void gameTryCountUp(){
        this.gameTryCount++;
    }

}
