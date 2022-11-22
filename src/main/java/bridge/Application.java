package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("횟수입력");
        InputView Input  =new InputView();
        int size = Input.readBridgeSize();
        BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(random);
        List<String> auto =  maker.makeBridge(size);
        BridgeGame game = new BridgeGame();
        int count = 1;
        InputView input = new InputView();
        BridgeGame gaming = new BridgeGame();
        String passOrFail = null;
        int AllCount = 1;
        for(int i = 0;i<size;i++){
            String choice = input.readMoving();
            OutputView view = new OutputView();
            List<StringBuffer> Answer =  game.move(auto.get(i),i,choice);
            int result = view.printMap(Answer,i);
            if(size -1 != i) {
                count = count + 4;
                gaming.slice(i, count, Answer.get(0), Answer.get(1));
            }
           if(result  == 1){
               String Retry = game.retry();
               if(Retry.equals("R")){
                   game = new BridgeGame();
                   i=-1;
                   count = 1;
                   AllCount = AllCount+1;
               } else if (Retry.equals("Q")) {
                   System.out.println("최종 게임 결과");
                   view.printMap(Answer,i);
                   passOrFail = "실패";
                   view.printResult(passOrFail,AllCount);
                   break;

               }
           }
            if(i==size-1){
                System.out.println("최종 게임 결과");
                view.printMap(Answer,i);
                passOrFail = "성공";
                view.printResult(passOrFail,AllCount);
                gaming.slice(i,count,Answer.get(0),Answer.get(1));

            }
        }

    }
}
