package bridge.domain;

import java.util.List;

public class Bridge {
	private final List<String> boards;

	public Bridge(List<String> boards) {
		this.boards = boards;
	}

	public List<String> getBoards() {
		return boards;
	}
}
