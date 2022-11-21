package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    //인스턴스 변수 추가 가능
    public final Bridge bridge;

    public  List<String> movingPositions;
    public  List<String> result;

    public int count;
    public boolean clear;
    public boolean failure;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.movingPositions = new ArrayList<>();
        this.result = new ArrayList<>();
        clear = false;
        failure = false;
        count = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movePosition) {
        positionValidation(movePosition);
        movingPositions.add(movePosition);
        comparedBridge();
    }

    public void positionValidation(String position){
        if(!Objects.equals(position, "U") && !Objects.equals(position, "D")){
            throw new IllegalArgumentException("이동하는 칸은 \"U\"(위칸), \"D\"(아래칸) 만 가능합니다.");
        }
    }

    public void comparedBridge(){
        String bridgeValue = bridge.getBridge().get(movingPositions.size()-1);
        String movingPosition = movingPositions.get(movingPositions.size()-1);
        if(Objects.equals(bridgeValue, movingPosition)){
            result.add("O");
        }

        if(!Objects.equals(bridgeValue, movingPosition)){
            result.add("X");
            failure = true;
        }

        if(bridge.getBridge().size() == movingPositions.size()){
            clear = true;
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        commandValidation(command);
        if(Objects.equals(command, "R")){
            setMovingPositions(new ArrayList<>());
            setResult(new ArrayList<>());
            setFailure(false);
            setClear(false);
            count++;
        }
        if(Objects.equals(command, "Q")){
            setClear(true);
        }
    }

    private void commandValidation(String command) {
        if(!Objects.equals(command, "R") && (!Objects.equals(command, "Q"))){
            throw new IllegalArgumentException("재시도는 \"R\" , 종료는 \"Q\"를 누르셔야 합니다.");
        }
    }

    public List<String> getMovingPositions() {
        return movingPositions;
    }

    public boolean isClear() {
        return clear;
    }

    public boolean isFailure() {
        return failure;
    }

    public List<String> getResult() {
        return result;
    }

    public void setMovingPositions(List<String> movingPositions) {
        this.movingPositions = movingPositions;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public void setFailure(boolean failure) {
        this.failure = failure;
    }

    public int getCount() {
        return count;
    }
}
