package controller;

import bridge.*;

import java.util.List;

public class BridgeController {
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();
	private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
	private List<String> bridge_list;

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
			String bridge_move_result = compareInputAndIndex(bridgeMoveOutputAndInput(), bridge_list.get(index));
			printMapByStringBuilder(bridge_move_result,index);
			if (bridge_move_result.contains("X")){
				break;
			}
		}
	}

	private String bridgeMoveOutputAndInput(){
		outputView.printMove();
		return inputView.readMoving();
	}

	private String compareInputAndIndex(String bridge_move,String list_index){
		if (bridge_move.equals(list_index)&&list_index.equals("U")){
			return "OU";
		}
		if (bridge_move.equals(list_index)&&list_index.equals("D")){
			return "OD";
		}
		if (!bridge_move.equals(list_index)&&list_index.equals("U")){
			return "XD";
		}
		return "XU";
	}

	private void printMapByStringBuilder(String bridge_move_result,int index){
		StringBuilder stringBuilder = outputView.printMap(bridge_move_result, index);
		System.out.println(stringBuilder);
	}
}
