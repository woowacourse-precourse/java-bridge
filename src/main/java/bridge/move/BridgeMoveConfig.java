package bridge.move;

public class BridgeMoveConfig {

	void OisUP(StringBuilder mapUpper,StringBuilder mapLower){
		prevElementDelete(mapUpper,mapLower);
		mapUpper.append("| O ]");
		mapLower.append("|   ]");
	}
	void OisDown(StringBuilder mapUpper,StringBuilder mapLower){
		prevElementDelete(mapUpper,mapLower);
		mapUpper.append("|   ]");
		mapLower.append("| O ]");
	}

	void XisUP(StringBuilder mapUpper,StringBuilder mapLower){
		prevElementDelete(mapUpper,mapLower);
		mapUpper.append("| X ]");
		mapLower.append("|   ]");
	}
	void XisDown(StringBuilder mapUpper,StringBuilder mapLower){
		prevElementDelete(mapUpper,mapLower);
		mapUpper.append("|   ]");
		mapLower.append("| X ]");
	}

	void firstOisUP(StringBuilder mapUpper,StringBuilder mapLower){
		mapUpper.append("[ O ]");
		mapLower.append("[   ]");
	}
	void firstOisDown(StringBuilder mapUpper,StringBuilder mapLower){
		mapUpper.append("[   ]");
		mapLower.append("[ O ]");
	}

	void firstXisUP(StringBuilder mapUpper,StringBuilder mapLower){
		mapUpper.append("[ X ]");
		mapLower.append("[   ]");
	}
	void firstXisDown(StringBuilder mapUpper,StringBuilder mapLower){
		mapUpper.append("[   ]");
		mapLower.append("[ X ]");
	}

	private void prevElementDelete(StringBuilder mapUpper,StringBuilder mapLower){
		mapUpper.deleteCharAt(mapUpper.toString().length()-1);
		mapLower.deleteCharAt(mapLower.toString().length()-1);
	}
}
