package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String ERROR = "[ERROR] ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> mapString) {
        int index = 0;
        System.out.print("[ ");
        for (index = 0; index < mapString.get(0).length() - 1; index++){
            System.out.print(mapString.get(0).charAt(index));
            System.out.print(" | ");
        }
        System.out.println(mapString.get(0).charAt(index) + " ]");
        index = 0;
        System.out.print("[ ");
        for (index = 0; index < mapString.get(1).length() - 1; index++){
            System.out.print(mapString.get(1).charAt(index));
            System.out.print(" | ");
        }
        System.out.println(mapString.get(1).charAt(index) + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int result, List<String> mapString) {
        String[] strResult = {"실패", "성공"};
        System.out.println("최종 게임 결과");
        printMap(mapString);
        System.out.println();
        System.out.println("게임 성공 여부: " + strResult[result]);
        System.out.println("총 시도한 횟수: " + BridgeGame.gameCount);
    }

    public void printErrorMessage(String e){
        System.out.println(ERROR + e);
    }
}
