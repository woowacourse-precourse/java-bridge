package bridge.move;

public class CompareMove {
	public String compareInputAndIndex(String bridge_move,String list_index){
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
}
