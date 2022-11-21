package bridge.service;

import bridge.dto.BridgeMapDto;
import bridge.dto.PlayerDto;
import bridge.dto.RetryCountDto;
import bridge.model.entity.*;

import java.util.List;

import static bridge.model.value.BridgeIngredient.*;
import static bridge.model.value.MatchMessage.*;
import static bridge.model.value.RetryMessage.Quit;
import static bridge.model.value.RetryMessage.Retry;

/**

 */
public class BridgeGame { // TODO: 다시 시도한 횟수를 저장해야 한다.

    private Player player;
    private BridgeMap bridgeMap;
    private  Bridge bridge;
    private RetryCount retryCount;

    public PlayerDto getPlayer() {
        return PlayerDto.of(player);
    }
    public BridgeMapDto getBridgeMap() {
        return BridgeMapDto.of(bridgeMap);
    }
    public Bridge getBridge() {
        return bridge;
    }
    public RetryCountDto getRetryCount() {
        return RetryCountDto.of(retryCount);
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
    public Boolean checkMove(int index, String move) { //정답과 일치하는지 확인
        updateIndex(index); //TODO: Refactoring 해줄 것 return type 없앨 수 있는 방향 생각하기
        if(bridge.getAnswer().get(index).equals(move)){
            addMatchMap(move);
            return null;
        }
        addNotMatchMap(move);
        return null;
    }

    private void updateIndex(int index) {
        bridgeMap.setIndex(index +1);
    }

    public void addMatchMap(String move){
        if(move.equals("U")){ // TODO: Refactoring else 없애고 간결하게 적성할것
            bridgeMap.add(MATCH.getIngredient(), BLANK.getIngredient());
        }else{
            bridgeMap.add(BLANK.getIngredient(), MATCH.getIngredient());
        }
    }

    public void addNotMatchMap(String move){
        if(move.equals("U")){
            bridgeMap.add(NOT_MATCH.getIngredient(), BLANK.getIngredient());
        }else{
            bridgeMap.add(BLANK.getIngredient(),  NOT_MATCH.getIngredient());
        }
    }
    public Boolean checkResult() { //둘다 X가 없을 때 true 반환
        return !bridgeMap.getUpMap().contains(NotMatch) && !bridgeMap.getDownMap().contains(NotMatch);
    }

    public Boolean isEnd(){
        return bridgeMap.getUpMap().size() == bridge.getAnswer().size();
    }

    public Boolean keepGoingGame() {

        return player.getAnswer().equals(Retry);
    }

    public String success(){
        if(bridgeMap.getUpMap().size() == bridge.getAnswer().size() && checkResult()){
            player.setAnswer(Quit);
            return Sucees;
        }
        return Fail;
    }

    public void retry(String retry) { // TODO: Refactring 해줄 것
        checkRetry(retry);
    }

    public void checkRetry(String retry) {
        if(Quit.equals(retry)){
            player.setAnswer(retry);
            return ;
        }
        player.setAnswer(retry);
        this.bridgeMap = BridgeMap.of(); // TODO: Refactoring 예정
        this.retryCount.upCount();
    }
}
