package bridge;

import java.util.List;

public class OutputView {

    public static String upResult = "";
    public static String downResult = "";
    public static String tempUpResult = "";
    public static String tempDownResult = "";

    public void printMap(String alphabet, List<String> bridge, int bridgeCount) {
        insertLeftBracket(bridgeCount);
        correctOrWrongResult(alphabet, bridge, bridgeCount);
        makeTempResult();
        printResult();
    }

    public void correctOrWrongResult(String alphabet, List<String> bridge, int bridgeCount) {
        if (bridgeCount != 0) {
            insertLineShape();
        }
        insertCorrect(alphabet, bridgeCount, bridge);
        insertWrong(alphabet, bridgeCount, bridge);
    }

    public void insertLeftBracket(int bridgeCount){
        if (bridgeCount == 0){
            upResult += "[";
            downResult += "[";
        }
    }

    public void makeTempResult(){
        tempUpResult = upResult + "]";
        tempDownResult = downResult + "]";
    }

    public void insertCorrect(String alphabet, int index, List<String> bridge) {
        if (alphabet.equals("U") && alphabet.equals(bridge.get(index))) {
            upResult += " O ";
            downResult += "   ";}
        if (alphabet.equals("D") && alphabet.equals(bridge.get(index))) {
            upResult += "   ";
            downResult += " O ";}
    }

    public void insertWrong(String alphabet, int index, List<String> bridge) {
        if (alphabet.equals("U") && !alphabet.equals(bridge.get(index))) {
            upResult += " X ";
            downResult += "   ";}
        if (alphabet.equals("D") && !alphabet.equals(bridge.get(index))) {
            upResult += "   ";
            downResult += " X ";}
    }

    public void insertLineShape() {
        upResult += "|";
        downResult += "|";
    }

    public void printResult() {
        System.out.println(tempUpResult);
        System.out.println(tempDownResult);
        System.out.println();
    }

    public void clearResult() {
        upResult = "";
        downResult = "";
    }

    public void clearTempResult() {
        tempUpResult = "";
        tempDownResult = "";
    }

    public void printResult(boolean wrongMovement, int count) {
        if (wrongMovement == true) {
            printFail(count);
        }
        if (wrongMovement == false) {
            printSuccess(count);
        }
    }

    public void printFail(int count) {
        System.out.println("게임 성공 여부: 실패");
        System.out.println(String.format("총 시도한 횟수: %d", count));
    }

    public void printSuccess(int count) {
        System.out.println("게임 성공 여부: 성공");
        System.out.println(String.format("총 시도한 횟수: %d", count));
    }

    public void printFinal() {
        System.out.println("최종 게임 결과");
    }

    public static void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void bridgeMakingMessage(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void readMovingMessage(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void readGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
