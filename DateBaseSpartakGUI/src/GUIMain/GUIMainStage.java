package GUIMain;

import GUIMain.CustomStage.SystemErrorStage;
import GUIMain.Styles.CssUrl;
import MySQLDB.ServerMySQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import Logger.LOG;
import javafx.stage.StageStyle;

public class GUIMainStage extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GUIMain.fxml"));
             Scene scene = new Scene(root);
//            String css = this.getClass().getResource("Styles/style2.css").toExternalForm();
            scene.getStylesheets().add(new CssUrl ().get ());
//            LOG.info ("CSS: " + css);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        double width = screenSize.getWidth();
//        double height = screenSize.getHeight();
//        primaryStage.setY(height / 6);
//        primaryStage.setX(width / 6);
//        primaryStage.initStyle(StageStyle.UNDECORATED);

//        scene.setFill(Color.TRANSPARENT);
//        primaryStage.setWidth(width - (width / 3));
//        primaryStage.setHeight(height - (height / 3));
//        primaryStage.setHeight (740);
//        primaryStage.setWidth (1024);

        primaryStage.getIcons().add(new Image(new File("img\\logo\\DataBaseLogo.png").toURI().toURL().toString()));
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth (1024);
        primaryStage.setMinHeight (760);
        primaryStage.show();
        } catch (IOException e) {
            LOG.error ("Ошибка при запуске приложения.", e);
            new SystemErrorStage (e);
            e.printStackTrace();
        }
        LOG.info ("Успешный старт приложения.");
    }


    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void stop(){
        ServerMySQL.disconnect ();
        LOG.info ("Приложение закрыто.");
        System.exit (0);
    }
}
