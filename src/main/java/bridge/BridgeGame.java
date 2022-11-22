package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int START_LOCATION = -1;
    int location;
    public List<String> userDirections;
    private List<String> bridge;
    int retryStack = 1;

    public BridgeGame(List<String> bridge){
        location = START_LOCATION;
        this.userDirections = new ArrayList<>();
        this.bridge = bridge;
    }
    private void init(){
        location = START_LOCATION;
        this.userDirections = new ArrayList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> getUserDirections(){
        return this.userDirections;
    }



    public GameState play(String direction){
        move(direction);
        if(result() == GameState.ALIVE){
            if(isArrival()){
                return GameState.WIN;
            }
            return GameState.ALIVE;
        }
        return GameState.FALL;
    }


    public void move(String direction) {
        location = location + 1;
        userDirections.add(direction);
    }


    public GameState result(){
        String correct = bridge.get(location);
        int lastInputIndex = userDirections.size()-1;
        if(correct.equals(userDirections.get(lastInputIndex))){
            System.out.println("결과 = ALIVE" );
            return GameState.ALIVE;
        }
        System.out.println("결과 = FALL");
        return GameState.FALL;
    }


    //bridge 끝까지 갔다면
    public boolean isArrival(){
        if(bridge.size() == location + 1){
            return true;
        }
        return false;
    }
    public boolean isStop(GameState state){
        if(state == GameState.FALL){
            return false;
        }
        if (state == GameState.WIN){
            return false;
        }
        return true;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean isRetry(String answer){
        if(answer.equals("Q")){
            System.out.println("재시작 x");
            return false;
        }
        if(answer.equals("R")){
            this.retry();
        }
        return true;
    }
    public boolean retry() {
        retryStack = retryStack + 1;
        init();
        System.out.println("게임을 다시시작합니다.");
        return true;
    }
}
