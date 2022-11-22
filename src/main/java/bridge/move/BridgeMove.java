package bridge.move;

public class BridgeMove {
	private final StringBuilder result=new StringBuilder();
	private final BridgeMoveConfig moveConfig=new BridgeMoveConfig();

	final StringBuilder mapUpper=new StringBuilder();
	final StringBuilder mapLower=new StringBuilder();

	public StringBuilder bridgeMoveByResult(String move_result,int index){
		if (index==0){
			firstIndexMap(move_result);
			result.append(mapUpper).append('\n').append(mapLower);
			return result;
		}
		anyIndexMap(move_result);
		updateResultStringBuilder();
		return result;
	}

	private void firstIndexMap(String move_result){
		if (move_result.contains("X")){
			moveFailFirst(move_result);
		}
		if (move_result.contains("O")){
			moveSuccessFirst(move_result);
		}
	}
	private void anyIndexMap(String move_result){
		if (move_result.contains("X")){
			moveFail(move_result);
		}
		if (move_result.contains("O")){
			moveSuccess(move_result);
		}
	}

	private void moveFail(String move_result){
		if (move_result.equals("XU")){
			moveConfig.XisUP(mapUpper,mapLower);
		}
		if (move_result.equals("XD")){
			moveConfig.XisDown(mapUpper,mapLower);
		}
	}

	private void moveSuccess(String move_result){
		if (move_result.equals("OU")){
			moveConfig.OisUP(mapUpper,mapLower);
		}
		if (move_result.equals("OD")){
			moveConfig.OisDown(mapUpper,mapLower);
		}
	}

	private void moveFailFirst(String move_result){
		if (move_result.equals("XU")){
			moveConfig.firstXisUP(mapUpper,mapLower);
		}
		if (move_result.equals("XD")){
			moveConfig.firstXisDown(mapUpper,mapLower);
		}
	}

	private void moveSuccessFirst(String move_result){
		if (move_result.equals("OU")){
			moveConfig.firstOisUP(mapUpper,mapLower);
		}
		if (move_result.equals("OD")){
			moveConfig.firstOisDown(mapUpper,mapLower);
		}
	}

	private void updateResultStringBuilder(){
		result.delete(0,result.length());
		result.append(mapUpper).append('\n').append(mapLower);
	}

	public void viewClean(){
		mapUpper.setLength(0);
		mapLower.setLength(0);
		result.setLength(0);
	}
}
