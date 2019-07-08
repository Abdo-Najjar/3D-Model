package Main;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Main extends Application {

    private final static int width = 1000;
    private final static int height = 500;

    @Override
    public void start(Stage stage) throws Exception {
        Sphere sphere = new Sphere(50);
        
        Group group = new Group();
        group.getChildren().add(sphere);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, width, height);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        
        sphere.translateXProperty().set(width / 2);
        sphere.translateYProperty().set(height / 2);
        
        stage.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
            switch (event.getCode()) {
                case W:
                    sphere.translateZProperty().set(sphere.getTranslateZ() + 10);
                    break;
                case S:
                    sphere.translateZProperty().set(sphere.getTranslateZ() -10);
                    break;

            }
        });
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
