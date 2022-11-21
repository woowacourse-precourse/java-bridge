package bridge;

public class Announcement {
    public static void start(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public static void move(){
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public static void restart(){
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    public static void bridge_result(){
        System.out.println("\n최종 게임 결과");
    }
}
