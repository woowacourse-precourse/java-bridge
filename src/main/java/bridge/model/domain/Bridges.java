package bridge.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.constant.Error;

public class Bridges {
	private static final BridgeMaker BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());

	private final List<String> bridges;

	public Bridges() {
		this.bridges = new ArrayList<>();
	}

	public void makeBridge(int size) {
		validateExistence();
		bridges.addAll(new ArrayList<>(BRIDGE_MAKER.makeBridge(size)));
	}

	public List<String> getBridges() {
		validateAbsence();
		return Collections.unmodifiableList(bridges);
	}

	private void validateAbsence() {
		if (bridges.size() == 0) {
			throw new IllegalStateException(Error.ABSENCE.getMessage());
		}
	}

	private void validateExistence() {
		if (bridges.size() != 0) {
			throw new IllegalStateException(Error.EXISTENCE.getMessage());
		}
	}
}
