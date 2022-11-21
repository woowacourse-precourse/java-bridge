package bridge;

import bridge.model.Bridge;
import bridge.model.User;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private User user;
    private BridgeMaker bridgeMaker;
    private Boolean retryInput;
    public BridgeGame(){
        user = new User();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void isCorrect(String input){
        if(!bridge.getBridgeListIndex(user.getPosition()).equals(input)){
            user.failResult();
        }
    }
    public void move() {
        if(!user.getResult()){
            return;
        }
        user.addPosition();
    }
    public Boolean isEnd(){
        if(!user.getResult())return Boolean.TRUE;
        if(user.getPosition().equals(bridge.getBridgeSize())) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.setStartPosition();
        user.successResult();
        user.addCount();
    }
    public void inputBridgeSize(int input){
        bridge = new Bridge(bridgeMaker.makeBridge(input));
    }
    public Boolean isSuccess(){
        return user.getResult();
    }
    public Bridge getBridge(){
        return this.bridge;
    }
    public User getUser(){
        return this.user;
    }
    public Boolean getRetryInput(){
        return this.retryInput;
    }
    public void setBridge(Bridge bridge){this.bridge = bridge;}
}