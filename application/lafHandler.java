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

public class lafHandler implements EventHandler<ActionEvent> {

  private Button b;
  private TextField tf;
  static private File selectedFile;

  lafHandler(Button b) {
    this.b = b;
  }

  lafHandler(Button b, TextField tf) {
    this.b = b;
    this.tf = tf;
  }

  @Override
  public void handle(ActionEvent event) {
    // Opens a new window to select a file from
    if (b.getText().equals("Pick a File From System")) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      fileChooser.getExtensionFilters().addAll(new ExtensionFilter("JSON Files", "*.json"));
      fileChooser.setInitialDirectory(new File("."));
      // opens the new window in program's directory and stores the choosen file
      lafHandler.selectedFile = fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
      if (selectedFile != null) {
        tf.setText(selectedFile.getName());
      }
    }

    if (b.getText().equals("Import File")) {
      if (selectedFile != null) {
        try {
          FileIn fileIn = new FileIn(selectedFile.getAbsolutePath(), Main.questionTable);
          selectedFile = null;
          tf.clear();
        } catch (Exception e) {
          tf.setText("Could Not Parse File");
        }
      }
      try {
        FileIn fileIn = new FileIn(tf.getText(), Main.questionTable);
        selectedFile = null;
        tf.clear();
      } catch (Exception e) {
        tf.setText("Could Not Parse File");
      }
    }
  }
}
