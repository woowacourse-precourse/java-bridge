package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private InputView(){}

	public static void printIntroMessage() {
		System.out.println("다리 건너기 게임을 시작합니다.");
		System.out.println();
	}

	public static int readBridgeSize() {
		System.out.println("다리의 길이를 입력해주세요.");
		String input = Console.readLine();
		validSize(input);
		System.out.println();
		return Integer.parseInt(input);
	}

	private static void validSize(String input) {
		if (!checkDigit(input) || input.equals("0")) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이는 자연수여야 합니다.");
		}
	}

	private static boolean checkDigit(String input) {
		boolean check = false;
		for (char c : input.toCharArray()) {
			check = Character.isDigit(c);
		}
		return check;
	}

	public static String readMoving() {
		System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
		String input = Console.readLine();
		validCommand(input);
		return input;
	}

	public static String readGameCommand() {
		System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
		String input = Console.readLine();
		validCommand(input);
		return input;
	}

	private static void validCommand(String input) {
		for (char c : input.toCharArray()) {
			checkUpperCase(c);
		}
	}

	private static void checkUpperCase(char input) {
		if (!Character.isUpperCase(input)) {
			throw new IllegalArgumentException("[ERROR] 커맨드는 대문자 알파벳으로 입력해야 합니다.");
		}
	}
}
