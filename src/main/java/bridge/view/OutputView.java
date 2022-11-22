package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printIntro(){
        System.out.println(Notice.STARTING_GAME);
        System.out.println();
        System.out.println(Notice.SET_GAME);
    }

    public void printMove(){
        System.out.println(Notice.RUNNING_GAME);
    }
    public void printRetry(){
        System.out.println(Notice.GAME_RETRY);
    }
    public void printException(String exception){
        System.out.println(exception);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> buffer) {
        for(int i = 0;i <2; i++){
            System.out.println();
            for (int j = 0; j < buffer.get(i).size();j++)
                System.out.print(buffer.get(i).get(j));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> buffer, String result, int totalCount) {
        System.out.println(Notice.GAME_RESULT);
        printMap(buffer);
        System.out.println();
        System.out.println(Notice.GAME_SUCCESS_OR_FAILURE + result);
        System.out.println(String.format(Notice.ATTEMPT_COUNT,totalCount));
    }
}
