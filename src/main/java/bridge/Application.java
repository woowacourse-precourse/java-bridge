package bridge;


import static bridge.GameStatus.QUIT;
import static bridge.GameStatus.SELECT_RE_TRY;
import static bridge.UserInterface.SUCCESS;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 다리 생성
        FrontController frontController = new FrontController();
        ;

        GameEntity gameEntity = frontController.gameRepository();
        gameEntity.move();




    }

}
