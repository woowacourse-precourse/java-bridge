package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView implements OutputMaker{

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void printMap(List<List<String>> maps) {
        for(List<String> map : maps) {
            String output = "[";
            for(String mark : map) {
                output += " " + mark + " " + "|";
            }
            System.out.println(output.substring(0, output.length() - 1) + "]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void printResult(List<List<String>> maps, boolean success, int cnt) {
        System.out.println("최종 게임 결과");
        printMap(maps);
        System.out.print("게임 성공 여부: ");
        printStatus(success);
        System.out.println("총 시도한 횟수: " + cnt);
    }

    @Override
    public void printStatus(boolean success) {
        if(success) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }
}
