package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        String move_print = BridgeGame.map_move(); int count = BridgeGame.endgame_2();
        String count_print = " | " + move_print;
        for(int i = 0; i <= count; i++){
            if(count == 1){
                System.out.println("[ " + move_print + " ]");                System.out.println("[ " + move_print + " ]");
            }
            else if(count >= 1){
                System.out.println("[ " + move_print + count_print + " ]");
                System.out.println("[ " + move_print + count_print + " | " + move_print + " ]");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

        String final_result = BridgeGame.endgame_1();
        int final_count = BridgeGame.endgame_2();
        System.out.println("\n게임 성공 여부: " + final_result);
        System.out.println("총 시도한 횟수: " + final_count);
    }
}
