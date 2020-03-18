import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/initPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public static void centralizaScrean (Stage stage){
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------//
    // framework para passar informações entre tela

    private  static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

//evento
public interface OnChangeScreen {
    void onScreenChanged(String newScreen, Object userData);
}

    public static void addOnChangeScreenListeners(OnChangeScreen newListener){
        listeners.add(newListener);
    }
    // manda pra todas as telas que tiver cadastrado no Listeners
    private static void notifyAllListeners(String newScreen, Object userData){
        for (OnChangeScreen l : listeners){
            l.onScreenChanged(newScreen,userData);
        }
    }
}
