package view;

import camp.nextstep.edu.missionutils.Console;
import constants.CommandTable;
import constants.DirectionTable;
import view.vo.Command;
import view.vo.Moving;
import view.vo.Size;

public class InputView {
    public static int readBridgeSize() {
        for (; ; ) {
            try {
                printInputBridgeSize();
                return new Size(input()).getSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static String readMoving() {
        for (; ; ) {
            try {
                printInputMoving();
                return new Moving(input()).getMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputMoving() {
        System.out.println(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"
                , DirectionTable.UP.getInitial(), DirectionTable.DOWN.getInitial()));
    }

    public static String readGameCommand() {
        for (; ; ) {
            try {
                printInputCommand();
                return new Command(input()).getCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printInputCommand() {
        System.out.println(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)"
                , CommandTable.RETRY.getInitial(), CommandTable.QUIT.getInitial()));
    }

    private static String input() {
        return Console.readLine();
    }
}
