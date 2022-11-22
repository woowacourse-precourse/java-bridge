package bridge.view;

public enum DrawBridge {
	BRIDGE_START("[ "), BRIDGE_MIDDLE(" | "), BRIDGE_END(" ]");

	private final String structure;

	DrawBridge(String structure) {
		this.structure = structure;
	}

	public String getStructure() {
		return structure;
	}
}
