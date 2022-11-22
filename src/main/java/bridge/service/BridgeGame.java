package bridge.service;

import bridge.dto.BridgeMapDto;
import bridge.dto.PrintResultDto;
import bridge.dto.RetryCountDto;
import bridge.model.entity.*;
import bridge.model.entity.Bridge;
import bridge.model.entity.Move;
import bridge.model.value.BridgeIngredient;
import bridge.model.value.PlayerMessage;

import java.util.List;

import static bridge.model.value.BridgeIngredient.*;
import static bridge.model.value.MatchMessage.*;
import static bridge.model.value.PlayerMessage.*;
import static bridge.model.value.PlayerMessage.BLANK;

public class BridgeGame { // TODO: 다시 시도한 횟수를 저장해야 한다.

    private Player player;
    private BridgeMap bridgeMap;
    private Bridge bridge;
    private RetryCount retryCount;

    public Player getPlayer() {
        return player;
    }
    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }
    public Bridge getBridge() {
        return bridge;
    }
    public RetryCount getRetryCount() {
        return retryCount;
    }
    public PrintResultDto getPrintResultDto() {
        return PrintResultDto.of(success(), BridgeMapDto.of(bridgeMap), RetryCountDto.of(retryCount));
    }


    public void createBridge(List<String> answer) {
        this.bridge = Bridge.of(answer);
    }
    public void createBridgeMap() {
        this.bridgeMap = BridgeMap.of();
    }
    public void createPlayer() {
        this.player = Player.of();
    }
    public void createCount() {
        this.retryCount = RetryCount.of();
    }


    public void move(String readMove) {
        //문자가 U, D를 입력 받고 일치하는지 확인
        Move move = Move.of(readMove);
        checkMove(bridgeMap.getIndex(), move.getMove());
    }
    public void checkMove(int index, String move) { //정답과 일치하는지 확인
        updateIndex(index);
        if(bridge.getAnswer().get(index).equals(move)){
            addMatchMap(move);
            return;
        }
        addNotMatchMap(move);
    }

    private void updateIndex(int index) {
        bridgeMap.setIndex(index +1);
    }

    public void addMatchMap(String move){
        if(move.equals(UP)){ // TODO: Refactoring else 없애고 간결하게 적성할것
            bridgeMap.add(Match, BLANK);
            return;
        }
        bridgeMap.add(BLANK, Match);
    }

    public void addNotMatchMap(String move){
        if(move.equals(UP)){
            bridgeMap.add(NotMatch, BLANK);
            return;
        }
        bridgeMap.add(BLANK,  NotMatch);
    }
    public Boolean checkResult() { //둘다 X가 없을 때 true 반환
        return !bridgeMap.getUpMap().contains(NotMatch) && !bridgeMap.getDownMap().contains(NotMatch);
    }

    public Boolean isEnd(){
        return bridgeMap.getUpMap().size() == bridge.getAnswer().size();
    }

    public Boolean keepGoingGame() {

        return player.getAnswer().equals(RETRY);
    }

    public String success(){
        if(bridgeMap.getUpMap().size() == bridge.getAnswer().size() && checkResult()){
            player.setAnswer(QUIT);
            return Sucees;
        }
        return Fail;
    }

    public void retry(String retry) {
        if (isQuit(retry)) {
            return;
        }
        isRetry(retry);
    }

    private void isRetry(String retry) {
        player.setAnswer(retry);
        createBridgeMap();
        this.retryCount.upCount();
    }

    private boolean isQuit(String retry) {
        if(QUIT.equals(retry)){
            player.setAnswer(retry);
            return true;
        }
        return false;
    }
}
