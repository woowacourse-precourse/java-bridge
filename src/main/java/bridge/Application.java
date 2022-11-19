package bridge;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try {
            InputView Input = new InputView();

            System.out.println("다리 건너기 게임을 시작합니다.");
            System.out.println("다리의 길이를 입력해주세요.");

            Input.readBridgeSize();

        }catch (IOException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
