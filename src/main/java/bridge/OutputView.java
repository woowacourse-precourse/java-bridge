package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String BLANK = "   ";




    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> movingResult) {
      List<String> upLine = new ArrayList<>();
      List<String> underLine = new ArrayList<>();

        for (int i = 0; i < movingResult.size(); i++) {
            String[] result = movingResult.get(i).split(",");
            makeMap(result,upLine,underLine);
        }
        printLine(upLine);
        printLine(underLine);
    }

    private void removeLastIdx(List<String> line) {
        String last = line.get(line.size() - 1);
        line.remove(line.size()-1);
        line.add(last.replace("|",""));
    }

    private void printLine(List<String> upLine) {
        removeLastIdx(upLine);
        System.out.print("[");
        for (int i = 0; i < upLine.size(); i++) {
            System.out.print(upLine.get(i));
        }
        System.out.println("]");
    }


    private void makeMap(String[] result,List<String > up, List<String > down) {
        if(result[0].equals("U")){
            up.add(" "+result[1]+" |");
            down.add(BLANK +"|");
        }
        if(result[0].equals("D")){
            down.add(" "+result[1]+" |");
            up.add(BLANK +"|");
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
