package view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printStartBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public static void printBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printToChoicePlace() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
    }

    public static void printMap(String upBridge, String downBridge) {
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    public static void printChoiceRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    
    public static void printResult(String bridge, String failOrPass, int count) {
        System.out.println("\n최종 게임 결과");
        System.out.println(bridge);
        System.out.println("게임 성공 여부: " + failOrPass);
        System.out.println("총 시도한 횟수: " + String.valueOf(count));
    }
}