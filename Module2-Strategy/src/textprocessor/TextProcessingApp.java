package textprocessor;

public class TextProcessingApp {
	public static void main(String[] args) {
		String text = "This is also sample text. It will be processed by this application.";

		ProcessorUI ui = new ProcessorUI(text);
		
		ui.show();
	}
}
