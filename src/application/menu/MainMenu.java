package application.menu;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenu extends Menu {
	public MainMenu(Pane root, Scene scene, Stage stage) {
		super(root, scene, stage);
	}
	
	public void showContent() {
		System.out.println("Main Menu");
	}
}
