package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Command;
import bridge.validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int BRIDGE_MIN_LENGTH = 3;
    private final int BRIDGE_MAX_LENGTH = 20;
    private final int ZERO = 0;
    private final List<String> systemBridge;

    private List<String> userBridge = new ArrayList<>();
    private int totalAttempt = ZERO;

    public BridgeGame(BridgeNumberGenerator generator, int bridgeSize) throws IllegalArgumentException{
        this.systemBridge = makeBridge(generator, bridgeSize);
        totalAttempt++;
    }

    private List<String> makeBridge(BridgeNumberGenerator generator, int bridgeSize) throws IllegalArgumentException{
        final BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Validator.validateListLengthInRange(bridge, BRIDGE_MIN_LENGTH, BRIDGE_MAX_LENGTH);
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String nextMove) throws IllegalArgumentException{
        Validator.validateIsStringCommand(nextMove, Command.MOVE_UP, Command.MOVE_DOWN);
        userBridge.add(nextMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userBridge = new ArrayList<>();
        totalAttempt++;
    }

    public List<List<String>> getRoundResult(){
        List<List<String>> result = new ArrayList<>();
        result.add(Collections.unmodifiableList(userBridge));
        result.add(getBridgeLog());
        return result;
    }

    private List<String> getBridgeLog(){
        List<String> bridgeLog = new ArrayList<>();
        for(int index=ZERO; index<userBridge.size(); index++){
            bridgeLog.add(getOXByUserMove(index));
        }
        return bridgeLog;
    }

    private String getOXByUserMove(int index){
        if(systemBridge.get(index).equals(userBridge.get(index))){
            return "O";
        }
        return "X";
    }

    public boolean isGameOver(){
        return !systemBridge.subList(ZERO,userBridge.size()).equals(userBridge);
    }

    public boolean isGameCompleted(){
        return systemBridge.equals(userBridge);
    }

    public int getTotalAttempt(){
        return totalAttempt;
    }
}