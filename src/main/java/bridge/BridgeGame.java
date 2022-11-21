package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    HashMap<String, List<String>> path;
    private List<String> bridge;
    private int tryCount;
    private int moveCount;
    private boolean success;

    public BridgeGame(List<String> bridge){
        this.tryCount=1;
        this.moveCount=0;
        this.path=new HashMap<>(Map.of("U", new ArrayList<>(), "D",new ArrayList<>()));
        this.bridge=bridge;
        this.success=false;
    }

    public HashMap<String, List<String>> getPath() {
        return path;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
    public boolean getSuccess(){
        return success;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public HashMap<String, List<String>> move(String movingCommand) {
        HashMap<String,String> oppositionCommand = new HashMap<>(Map.of("U","D","D","U"));
        pathCheck(movingCommand, oppositionCommand);
        moveCount++;
        return path;
    }
    private void pathCheck(String movingCommand, HashMap<String,String> oppositionCommand){
        if (movingCommand.equals(bridge.get(moveCount))){
            path.get(movingCommand).add("O");
            path.get(oppositionCommand.get(movingCommand)).add("N");
        }
        if (!movingCommand.equals(bridge.get(moveCount))){
            path.get(movingCommand).add("X");
            path.get(oppositionCommand.get(movingCommand)).add("N");
        }
    }
    public boolean isFail(){
        boolean result = false;
        if (path.get("U").contains("X") || path.get("D").contains("X")){
            result = true;
        }
        return result;
    }
    public boolean isSuccess(){
        boolean result = false;
        if (moveCount==bridge.size() && !isFail()){
            result = true;
            success=true;
        }
        return result;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryCommand) {
        if (retryCommand.equals("R")){
            path=new HashMap<>(Map.of("U", new ArrayList<>(), "D",new ArrayList<>()));
            moveCount=0;
            tryCount++;
            success=false;
            return true;
        }
        return false;
    }
}
