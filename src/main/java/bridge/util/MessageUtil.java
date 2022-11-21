package bridge.util;

public class MessageUtil {

    public static void gameStartMsg() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void bridgeSizeInputMsg() {
        System.out.println("다리 길이를 입력해주세요.");
    }

    public static void movementInputMsg() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void retryCommandMsg() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public static void gameResultMsg(String map, String result, int trialNum) {
        System.out.printf("최종 게임 결과 \n%s \n게임 성공 여부: %s \n총 시도한 횟수: %d", map, result, trialNum);
    }


}
