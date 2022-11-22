package bridge.domain;

import java.util.Arrays;

public enum Path {
	U(1),
	D(0);

	private final int correspondingNumber;

	Path(int randomNumber) {
		this.correspondingNumber = randomNumber;
	}

	public static String getPathAlphabet(int randomNumber) {
		return valueOf(randomNumber).name();
	}

	private static Path valueOf(int randomNumber) {
		return Arrays.stream(Path.values())
				.filter(path -> path.correspondingNumber == randomNumber)
				.findAny()
				.orElse(null);
	}
}
