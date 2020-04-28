import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
        MyApplication myApplication = new MyApplication("C://Users//Mi Notebook//Desktop//references.txt");
        System.out.println("An application is about to start..");
        myApplication.start();

        String data = "Almaty is the largest city in Kazakhstan";
        Files.write(Paths.get("D:\\IdeaProjects\\Task12\\src\\com\\company\\db.txt"), data.getBytes());
    }

    public static class Magazine {
    }
}

