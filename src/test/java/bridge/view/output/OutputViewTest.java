package bridge.view.output;

import bridge.status.UserStatus;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void 성공_UI_확인용_테스트() {
        OutputView view = new OutputView();
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("U");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("D");

        view.printMap(userStatus);
    }

    @Test
    void 실패_UI_확인용_테스트() {
        OutputView view = new OutputView();
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("U");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("D");
        userStatus.lose();

        view.printMap(userStatus);
    }


    @Test
    void 최종결과_UI_확인용_테스트() {
        OutputView view = new OutputView();
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("U");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("D");
        userStatus.lose();

        view.printResult(userStatus);
    }

    @Test
    void 성공여부_UI_확인용_테스트() {
        OutputView view = new OutputView();
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        userStatus.addDirection("U");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("U");
        userStatus.addDirection("D");
        userStatus.addDirection("D");

        view.printResult(userStatus);
    }
}