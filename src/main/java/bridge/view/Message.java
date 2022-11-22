package bridge.view;

public class Message {
  public static void startMessage() {
    System.out.println("다리 건너기 게임을 시작합니다.");
  }

  public static void requestBridgeSizeMessage() {
    System.out.println("다리의 길이를 입력해주세요.");
  }

  public static void requestMovingMessage() {
    System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
  }

  public static void requestContinueMessage() {
    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
  }

  public static void gameResultMesaage() {
    System.out.println("최종 게임 결과");
  }
  public static void result() {
    System.out.print("게임 성공 여부: ");
  }
  public static void fail() {
    System.out.println("실패");
  }

  public static void success() {
    System.out.println("성공");
  }

  public static void tryCount(int count) {
    System.out.println("총 시도한 횟수: " + count);
  }
}
