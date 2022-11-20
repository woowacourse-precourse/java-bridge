package bridge.controller;

import bridge.util.InputCallback;
import bridge.view.InputView;
import bridge.view.OutputView;

public class IOController {
    private InputView inputView;
    private OutputView outputView;

    public IOController()
    {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private <T> T inputTemplate(InputCallback<T> inputCallback)
    {
        while(true) {

            try {
                return inputCallback.input();
            }
            catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public Integer inputBridgeSize()
    {
        return inputTemplate(new InputCallback<Integer>() {
            @Override
            public Integer input() {
                outputView.printMessage("다리의 길이를 입력해주세요.\n");
                return inputView.readBridgeSize();
            }
        });
    }

    public String inputNextMove()
    {
        return inputTemplate(new InputCallback<String>() {
            @Override
            public String input() {
                outputView.printMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
                return inputView.readMoving();
            }
        });
    }

    public String inputGameCommand()
    {
        return inputTemplate(new InputCallback<String>() {
            @Override
            public String input() {
                outputView.printMessage("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n");
                return inputView.readGameCommand();
            }
        });
    }

    public void printMap(String bridgeMap)
    {
        outputView.printMap(bridgeMap);
    }

    public void printResult(String gameResult)
    {
        outputView.printMessage("최종 게임 결과\n");
        outputView.printResult(gameResult);
    }

    public void printGameStartMessage()
    {
        outputView.printMessage("다리 건너기 게임을 시작합니다.\n");
    }



}
