package bridge.view.output;

public class OutputView implements ConsoleOutput {

	private static final String ENTER = "\n";

	private final String content;

	private OutputView(String content, Boolean frontParagraphing, Boolean backParagraphing) {
		this.content = formatOutput(content, frontParagraphing, backParagraphing);
	}

	public static OutputView withContentOf(String content, Boolean frontParagraphing, Boolean backParagraphing) {
		return new OutputView(content, frontParagraphing, backParagraphing);
	}

	private String formatOutput(String content, Boolean frontParagraphing, Boolean backParagraphing) {
		if (frontParagraphing || backParagraphing) {
			return backFormatting(frontFormatting(content, frontParagraphing), backParagraphing);
		}
		return content;
	}

	private String backFormatting(String content, Boolean backParagraphing) {
		if (backParagraphing) {
			return content + ENTER;
		}
		return content;
	}

	private String frontFormatting(String content, Boolean frontParagraphing) {
		if (frontParagraphing) {
			return ENTER + content;
		}
		return content;
	}

	@Override
	public void ConsoleMessage() {
		System.out.println(this.content);
	}
}
