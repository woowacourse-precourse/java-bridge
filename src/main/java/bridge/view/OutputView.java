package bridge.view;

import bridge.Application;

public class OutputView {

    public static void printMap() {
        Application.upSide.makeUpSide();
        System.out.println(Application.upSide.getUpSide());
        Application.downSide.makeDownSide();
        System.out.println(Application.downSide.getDownSide());
        System.out.println();
    }

    public static void printResult() {
        System.out.println("최종 게임 결과");
        printMap();
        printSuccess();
        System.out.println("총 시도한 횟수: " + Application.totalTrial);
    }

    public static void printSuccess() {
        String successResult = "";
        if (Application.success) {
            successResult = "성공";
        }
        if (!Application.success) {
            successResult = "실패";
        }
        System.out.println("게임 성공 여부: " + successResult);
    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public static void printRequestSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printSelect() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
