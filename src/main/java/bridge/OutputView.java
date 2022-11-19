package bridge;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    public void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int userPosition, Boolean checkBridge, List<List<Integer>> map) {

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printFirstBridge(int userPosition, boolean checkBridge, List<Integer> firstBridge){
    }

    public void printMapStart(){
        System.out.print("[");
    }

    public void printNone(int index, List<Integer> firstBridge){
        if(firstBridge.get(index) == RANDOM_LOWER_INCLUSIVE){
            System.out.print("   ");
        }
    }

    public void printCorrect(int index, List<Integer> firstBridge){
        if(firstBridge.get(index) == RANDOM_UPPER_INCLUSIVE){
            System.out.print(" O ");
        }
    }

    public void printIncorrect(int index, List<Integer> firstBridge){
        if(firstBridge.get(index) == RANDOM_LOWER_INCLUSIVE){
            System.out.print(" X ");
        }
    }

    public void printSeparation(){
        System.out.print("|");
    }

    public void printMapEnd(){
        System.out.print("]");
    }

    public void printUserPositionValue(int userPosition, boolean checkBridge,  List<Integer> partOfBridge){
        if(checkBridge == true && partOfBridge.get(userPosition) == RANDOM_UPPER_INCLUSIVE){
            System.out.print(" O ");
            return;
        }

        if(checkBridge == false && partOfBridge.get(userPosition) == RANDOM_LOWER_INCLUSIVE){
            System.out.print(" X ");
            return;
        }

        System.out.print("   ");
    }
}
