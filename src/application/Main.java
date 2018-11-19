package application;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import application.entities.*;
import application.menu.*;
import application.ships.*;

public class Main extends Application {
	private final double WINDOW_WIDTH = 800;
	private final double WINDOW_HEIGHT = 600;
	private Pane root;
	
	private List<GameObject> projectiles = new ArrayList<GameObject>();
	private List<GameObject> enemies = new ArrayList<GameObject>();
	private List<Point2D> movement = new ArrayList<Point2D>();
	private GameObject player;
	
	@Override
	public void start(Stage primaryStage) {
	   
		try {
			root = new Pane();
			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			root.getChildren().add(new ImageView("/resources/space_bckg.jpg"));
			
			player = new Player(new ShipObject(null, null, null, null, null, null));
			player.setVelocity(new Point2D(0, 0));
			addGameObject(player, WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
			
			AnimationTimer timer = new AnimationTimer() {
				
				@Override
				public void handle(long now) {
					
					onUpdate();
				}
			};
			timer.start();
			
			scene.setOnKeyPressed(e -> {
				switch(e.getCode()) {
					case UP: 
					case W:
						movement.add(new Point2D(0, -0.5));
						break;
					case LEFT:
					case A:
						movement.add(new Point2D(-0.5, 0));
						break;
					case RIGHT:
					case D:
						movement.add(new Point2D(0.5, 0));
						break;
					case DOWN:
					case S:
						movement.add(new Point2D(0, 0.5 ));
						break;
					case SPACE:
						Bullet bullet = new Bullet();
						bullet.setVelocity(new Point2D(Math.cos(Math.toRadians(player.getRotate())), Math.sin(Math.toRadians(player.getRotate()))));
						addBullet(bullet, player.getView().getTranslateX(), player.getView().getTranslateY());
						break;
					case I:
						MainMenu menu = new MainMenu(root, scene, primaryStage);
						menu.open();
					default: break;
				}
			});
			
			scene.setOnMouseMoved(e -> {
					player.setRotate(
							Math.toDegrees(
									Math.atan2(
											e.getY() - player.getView().getTranslateY(),
											e.getX() - player.getView().getTranslateX()
									)
							)
					);
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addGameObject(GameObject object, double x, double y) {
		object.getView().setTranslateX(x);
		object.getView().setTranslateY(y);
		root.getChildren().add(object.getView());
	}
	
	private void addBullet(GameObject bullet, double x, double y) {
		projectiles.add(bullet);
		addGameObject(bullet, x, y);
	}
	
	/*
	private void addEnemy(GameObject enemy, double x, double y) {
		enemies.add(enemy);
		enemy.setVelocity(new Point2D(0, 0));
		addGameObject(enemy, x, y);
	}
	*/
	
	private void onUpdate() {
		
		for (GameObject bullet : projectiles) {
			for (GameObject enemy : enemies) {
				if (bullet.isColliding(enemy)) {
					bullet.setAlive(false);
					bullet.setAlive(false);
					root.getChildren().removeAll(bullet.getView(), enemy.getView());
				}
			}
		}
		
		for (Point2D move : movement)
			player.addVelocity(move);
		
		projectiles.removeIf(GameObject::isDead);
		enemies.removeIf(GameObject::isDead);
		
		projectiles.forEach(GameObject::update);
		enemies.forEach(GameObject::update);
		player.update();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	private static class Enemy extends GameObject {
		Enemy() {
			super(new Circle(15, 15, 15, Color.BROWN));
		}
	}
	*/
	
	private static class Bullet extends GameObject {
		Bullet() {
			super(new Circle(5, 5, 5, Color.RED));
		}
	}
}
