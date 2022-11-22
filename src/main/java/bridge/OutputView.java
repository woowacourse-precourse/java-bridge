package bridge;

public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(String upResult, String downResult) {
        System.out.printf("[ %c", upResult.charAt(0));
        for (int index = 1; index < upResult.length(); index++) {
            System.out.printf(" | %c", upResult.charAt(index));
        }
        System.out.println(" ]");
        System.out.printf("[ %c", downResult.charAt(0));
        for (int index = 1; index < downResult.length(); index++) {
            System.out.printf(" | %c", downResult.charAt(index));
        }
        System.out.println(" ]");
    }

    public void printResult(String upResult, String downResult) {
        System.out.println("최종 게임 결과");
        printMap(upResult, downResult);
    }

    public void printSuccess(boolean isSuccess) {
        String resultToString = "성공";
        if (!isSuccess) {
            resultToString = "실패";
        }
        System.out.println("게임 성공 여부: " + resultToString);
    }

    public void printRetryCount(int retry) {
        System.out.println("총 시도한 횟수: " + retry);
    }
}
