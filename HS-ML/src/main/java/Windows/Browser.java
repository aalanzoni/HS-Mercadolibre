/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Source https://stackoverflow.com/questions/16370688/javafx-textfield-eventhandler
 */
package Windows;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.*;
import javafx.stage.Stage;

public class Browser extends Application {
  private WebEngine myWebEngine;
  private static String url;
  public static String url_Code;

  @Override
  public void start(Stage stage) {
    stage.setTitle("Browser");

 //   final TextField addressBar = new TextField();
 //   addressBar.setText(url);

 //   addressBar.setOnAction(new EventHandler<ActionEvent>() {
 //     @Override
 //     public void handle(ActionEvent event) {
 //       myWebEngine.load(addressBar.getText());
 //     }
 //   });

    WebView myBrowser = new WebView();
    myWebEngine = myBrowser.getEngine();
    myWebEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
      @Override public void changed(ObservableValue<? extends Throwable> observableValue, Throwable oldException, Throwable exception) {
        url_Code = myWebEngine.getLocation();

        try {
            stage.close();
            stop();
        } catch (Exception ex) {
            Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
    
    myWebEngine.load(url);

    VBox root = new VBox();
    root.getChildren().setAll(
//        addressBar,
        myBrowser
    );
    stage.setScene(new Scene(root));
    stage.show();
  }

  public static void main(String url) {
      Browser.url = url;
      launch(url); 
  }
}