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
