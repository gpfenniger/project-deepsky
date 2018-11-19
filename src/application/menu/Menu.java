package application.menu;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class Menu {
	private Stage stage;
	private Scene scene;
	private Pane root;
	private Pane menuWindow;
	
	public Menu(Pane root, Scene scene, Stage stage) {
		this.stage = stage;
		this.root = root;
		this.scene = scene;
		menuWindow = new Pane();
		menuWindow.getChildren().add(new ImageView("/resources/base_menu.png"));
	}
	
	public void open() {
		this.scene = new Scene(menuWindow, 600, 600);
		stage.setScene(scene);
		showContent();
	}
	
	public void close() {
		this.scene = new Scene(root, 600, 600);
		stage.setScene(scene);
	}
	
	public Scene getScene() { return this.scene; }
	
	public abstract void showContent();
}
