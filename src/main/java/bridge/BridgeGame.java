package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int BRIDGE_NUMBER = 2;
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String EMPTY = "   ";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private List<String> createdBridge;
    private List<List<String>> resultBridges;

    public BridgeGame(List<String> createdBridge) {
        this.createdBridge = createdBridge;
        resultBridges = createEmptyResultBridge();
    }

    public List<List<String>> createEmptyResultBridge(){
        List<List<String>> resultBridges = new ArrayList<>();
        for(int i = 0; i < BRIDGE_NUMBER; i++){
            resultBridges.add(new ArrayList<>());
        }
        return resultBridges;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String movingBlock, int index) {
        if(!isValidMove(movingBlock,index)) {
            return inValidMove(movingBlock);
        }
        return validMove(movingBlock);
    }

    public boolean isValidMove(String movingBlock, int index){
        if(createdBridge.get(index).equals(movingBlock)){
            return true;
        }
        return false;
    }

    public List<List<String>> validMove(String movingBlock){
        return processMove(movingBlock, CORRECT);
    }

    public List<List<String>> inValidMove(String movingBlock){
        return processMove(movingBlock, WRONG);
    }

    private List<List<String>> processMove(String movingBlock, String marking) {
        if(UpAndDown.UP.isEqualDirection(movingBlock)) {
            resultBridges.get(UpAndDown.UP.getIndex()).add(marking);
            resultBridges.get(UpAndDown.DOWN.getIndex()).add(EMPTY);
        }
        if(UpAndDown.DOWN.isEqualDirection(movingBlock)){
            resultBridges.get(UpAndDown.UP.getIndex()).add(EMPTY);
            resultBridges.get(UpAndDown.DOWN.getIndex()).add(marking);
        }
        return resultBridges;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if(gameCommand.equals(RETRY)){
            return true;
        }
        if(!gameCommand.equals(QUIT)){
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.");
        }
        return false;
    }

    public boolean isGameFailed(List<List<String>> resultBridges){
        for(List<String> bridge : resultBridges){
            if(bridge.contains(WRONG)){
                return true;
            }
        }
        return false;
    }
}
