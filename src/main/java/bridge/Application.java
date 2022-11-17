package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    static InputView inputView = new InputView();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n" + "다리의 길이를 입력해주세요.");
        inputView.readBridgeSize();
    }
}
