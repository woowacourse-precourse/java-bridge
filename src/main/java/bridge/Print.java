package bridge;

public class Print {

	public static void startBridgeGame(){
		System.out.println("다리 건너기 게임을 시작합니다.");
		System.out.println("");
	}

	public static void inputBridgeSize(){
		System.out.println("다리의 길이를 입력해주세요.");
	}

	public static void selectBlock() {
		System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
	}

	public static void restartOrQuit() {
		System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
	}
}
