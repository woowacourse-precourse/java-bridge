package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();

    private static boolean retryOrNot = true;
    public enum correctWrong{
        CORRECT(true, "O", "성공"),
        WRONG(false, "X", "실패");

        boolean trueFalse;
        String ox;
        String successFail;


        correctWrong(boolean trueFalse, String ox, String successFail) {
            this.trueFalse = trueFalse;
            this.ox = ox;
            this.successFail = successFail;
        }

        public boolean getTrueFalse(){
            return trueFalse;
        }

        public String getOx(){
            return ox;
        }

        public String getSuccessFail(){
            return successFail;
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int inputNumber = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
        //최초 1회 구현



        int tryNumber = 0;
        String ox = null;
        String successFail = null;
        while(retryOrNot){
            outputView.resetMap();

            for (int order = 0; order < bridgeList.size(); order++){
                String upDownUserInput = inputView.readMoving();
                boolean trueFalse = bridgeGame.move(bridgeList, upDownUserInput, order);



                if (trueFalse = true){
                    correctWrong correct = correctWrong.CORRECT;
                    ox = correct.getOx();
                    successFail = correct.getSuccessFail();
                    outputView.printMap(ox,order,upDownUserInput);
                    if (order == bridgeList.size() - 1){
                        trueFalse = false;
                        break;
                    }
                } else if (trueFalse = false){
                    correctWrong correct = correctWrong.WRONG;
                    ox = correct.getOx();
                    successFail = correct.getSuccessFail();
                    outputView.printMap(ox,order,upDownUserInput);
                    trueFalse = bridgeGame.retry();
                    break;
                }

            }


            retryOrNot = trueFalse;

            tryNumber++;
        }

        outputView.printResult(tryNumber,successFail);



    }
}
