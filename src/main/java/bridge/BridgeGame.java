package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static int bridge_size = InputView.readBridgeSize();
    static String final_result;
    static int final_count;
    static String map_move;

    BridgeGame(){

    }

    public static BridgeGame create(){
        return new BridgeGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String direction = InputView.readMoving();
        List<String> Bridge_path = BridgeMaker.makeBridge(bridge_size);
        int i = 0; int count = 0;
        while(i == (bridge_size*2)) { // 끝까지 도달할때까지 반복
            if (direction == "U") { // "U"을 입력하였고, 정답이면, 다음칸으로
                if (Bridge_path.get(i) == direction) { i += 2; count++; map_print("O"); direction = InputView.readMoving();
                } else map_print("X"); retry();
            } else if (direction == "D") { // "D"를 입력하였고, 정답이면, 다음칸으로
                if (Bridge_path.get(i) == direction) { i += 2; count++; map_print("O"); direction = InputView.readMoving();
                } else map_print("X"); retry();
            }
        }
        if(i >= (bridge_size*2)) success("성공", count);
    }
    public static void success(String result, int count){
        final_result = result;
        final_count = count;
    }
    public static void map_print(String is_success){
        map_move = is_success;
    }
    public static String map_move(){
        return map_move;
    }

    public static String endgame_1(){
        return final_result;
    }
    public static int endgame_2(){
        return final_count;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String game_choice = InputView.readGameCommand();
        boolean result = true; // 성공
        if(game_choice == "R") create();
        else if(game_choice == "Q") success("실패", final_count);
    }
}
