package application;

import java.io.File;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * 
 * Filename: LoadAdditionalFileScreen.java Project: ATeam Quiz Generator Course: cs400 Spring 2019
 * Authors: Sammy Zopf, Titus Smith
 * 
 */
public class lafHandler implements EventHandler<ActionEvent> {

  // Fields
  private Button b;
  private TextField tf;
  static private File selectedFile;

  /**
   * Constructors
   * 
   * @param b
   */
  lafHandler(Button b) {
    this.b = b;
  }

  lafHandler(Button b, TextField tf) {
    this.b = b;
    this.tf = tf;
  }

  @Override
  public void handle(ActionEvent event) {
    // Handler for picking a file
    // Opens a new window to select a file from
    if (b.getText().equals("Pick a File From System")) {

      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      fileChooser.getExtensionFilters().addAll(new ExtensionFilter("JSON Files", "*.json"));
      fileChooser.setInitialDirectory(new File("."));

      // opens the new window in program's directory and stores the chosen file
      lafHandler.selectedFile =
          fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
      if (selectedFile != null) {
        tf.setText(selectedFile.getName());
      }
    }

    // Handler for importing a file
    if (b.getText().equals("Import File")) {
      try {
        if (selectedFile != null) {
          FileIn fileIn = new FileIn(selectedFile.getAbsolutePath(), Main.questionTable);
        } else {
          FileIn fileIn = new FileIn(tf.getText(), Main.questionTable);
        }
        selectedFile = null;
        tf.clear();

      } catch (Exception e) {
        tf.setText("Could Not Parse File");
      }
    }
  }
}
