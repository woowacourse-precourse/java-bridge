package bridge.ui;

import bridge.domain.Game;
import bridge.domain.MapString;

public class OutputView {
    private final String ERROR = "[ERROR] ";

    private void printEachString(String str){
        int index = 0;
        System.out.print("[ ");
        for (index = 0; index < str.length() - 1; index++){
            System.out.print(str.charAt(index));
            System.out.print(" | ");
        }
        System.out.println(str.charAt(index) + " ]");
    }
    public void printMap(MapString mapString) {
        printEachString(mapString.getUpstairs());
        printEachString(mapString.getDownstairs());
        System.out.println();
    }

    public void printResult(int result, MapString mapString) {
        String[] strResult = {"실패", "성공"};
        System.out.println("최종 게임 결과");
        printMap(mapString);
        System.out.println("게임 성공 여부: " + strResult[result]);
        System.out.println("총 시도한 횟수: " + Game.gameCount);
    }

    public void printErrorMessage(String e){
        System.out.println(ERROR + e);
    }
}
