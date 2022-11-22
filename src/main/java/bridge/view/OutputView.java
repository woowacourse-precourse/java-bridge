package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private DrawMap drawMap = new DrawMap();

    public void clearDrawMap() {
        this.drawMap = new DrawMap();
    }

    public void setUpDrawMap(String user, String upDown){
        drawMap.map(user, upDown);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        List<String> topList = drawMap.getTopList();
        List<String> bottomList = drawMap.getBottomList();
        printList(topList);
        printList(bottomList);
    }

    public void printList(List<String> list){
        System.out.printf("[ ");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s", list.get(i));
            if (i != list.size()-1) {
                System.out.printf(" | ");
            }
        }
        System.out.printf(" ]\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int gameCount, boolean gameStatus) {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println("게임 성공 여부: " + printSucess(gameStatus));
        System.out.println("총 시도한 횟수: " + gameCount);
    }

    /**
     * 게임 상태를 출력한다
     * @param gameStatus
     * @return 성공, 실패
     */
    public String printSucess(boolean gameStatus) {
        if (!gameStatus) {
            return "성공";
        }
        return "실패";
    }

    public String printStart(){
        return "다리 건너기 게임을 시작합니다.";
    }

}
