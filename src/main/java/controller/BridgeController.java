package controller;

import bridge.*;
import bridge.model.GameEnd;
import bridge.model.RetryDTO;
import bridge.move.CompareMove;
import bridge.util.InputView;
import bridge.util.OutputView;
import bridge.util.ViewClear;

import java.util.List;

public class BridgeController {

	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();
	private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
	private final CompareMove compareMove=new CompareMove();
	private final ViewClear viewClear=new ViewClear();
	private final BridgeGame bridgeGame = new BridgeGame();
	private final RetryController retryController=new RetryController();

	private List<String> bridge_list;
	private int TRY_COUNT=1;
	private String RESULT_CONDITION=GameEnd.SUCCESS.toString();
	private String GAME_RESULT;

	public void BridgeGameStart(){
		outputView.printStartGame();

		int bridgeSize = inputView.readBridgeSize();
		if(bridgeSize==0){
			throw new IllegalStateException("[ERROR] 예기치 못한 에러를 만났습니다.");
		}
		bridgeMakeBySize(bridgeSize);
	}

	private void bridgeMakeBySize(int bridge_size){
		bridge_list = bridgeMaker.makeBridge(bridge_size);
		crossingTheBridge();
	}

	private void crossingTheBridge(){
		System.out.println(bridge_list);
		for (int index=0;index<bridge_list.size();index++){
			String bridge_move_result = compareMove.compareInputAndIndex(bridgeMoveOutputAndInput(),
																	bridge_list.get(index));
			RESULT_CONDITION = outputView.printMapByStringBuilder(bridge_move_result, index);
			if(RESULT_CONDITION.equals("FAIL")){
				break;
			}
		}
		retryOrSuccess(bridgeGame.retry(RESULT_CONDITION,inputView,outputView));
	}
	private void retryOrSuccess(String user_input_condition){
		if (user_input_condition.equals("SUCCESS")){
			GAME_RESULT="성공";
			outputView.printResult(tryCountReturn(),gameResultReturn());
		}
		retryOrGiveUp(user_input_condition);
	}

	private void retryOrGiveUp(String user_input_condition){
		if (user_input_condition.equals("Q")){
			GAME_RESULT="실패";
			outputView.printResult(tryCountReturn(),gameResultReturn());
		}

		if (user_input_condition.equals("R")){
			retry();
		}
	}

	private void retry(){
		retryConfig();
		crossingTheBridge();
	}

	private String bridgeMoveOutputAndInput(){
		outputView.printMove();
		return inputView.readMoving();
	}

	private int tryCountReturn(){
		return TRY_COUNT;
	}

	private String gameResultReturn(){
		return GAME_RESULT;
	}

	private void retryConfig(){
		RetryDTO retryDTO=new RetryDTO(viewClear,TRY_COUNT,RESULT_CONDITION,GAME_RESULT);
		RetryDTO result_DTO = retryController.retryConfig(retryDTO, outputView);
		TRY_COUNT= result_DTO.TRY_COUNT;
		RESULT_CONDITION=result_DTO.RESULT_CONDITION;
		GAME_RESULT=result_DTO.GAME_RESULT;
	}
}
