package bridge;

import java.util.List;

import static bridge.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart(){
        System.out.print(GAME_START_MESSAGE);
    }

    public void printBridgeSizeInput(){
        System.out.print(BRIDGE_SIZE_MESSAGE);
    }

    public void printMoveInput(){
        System.out.print(MOVE_MESSAGE);
    }

    public void printRetryInput(){
        System.out.print(RETRY_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> state) {
        printUpper(state);
        printLower(state);
    }

    private void printUpper(List<String> state) {
        System.out.print("[ ");

        for (int i = 0; i < state.size(); i++) {
            printBlank(state.get(i),"U");

            if (i + 1 != state.size()) {
                System.out.print(" | ");
            }
        }

        System.out.println(" ]");
    }

    private void printLower(List<String> state){
        System.out.print("[ ");

        for (int i = 0; i < state.size(); i++) {
            printBlank(state.get(i),"D");

            if (i + 1 != state.size()) {
                System.out.print(" | ");
            }
        }

        System.out.println(" ]");
    }

    private void printBlank(String blank,String position) {
        if (blank.contains(position) && !blank.contains("X")) {
            System.out.print("O");
        }

        if (blank.contains(position) && blank.contains("X")) {
            System.out.print("X");
        }

        if (!blank.contains(position)) {
            System.out.print(" ");
        }


    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result,int count,List<String> state) {
        System.out.println("최종 게임 결과");
        printMap(state);
        System.out.printf(GAME_RESULT,result,count);
    }

    public void printException(Exception e){
        System.out.println(ERROR + e.getMessage());
    }
}
