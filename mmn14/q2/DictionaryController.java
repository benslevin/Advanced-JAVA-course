import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Map;

//This class is the graphic class for the dictionary. the buttons, event handlers and text area are controlled from this class.
public class DictionaryController {

    @FXML
    private TableView<Map.Entry<String,String>> tableView;
    @FXML
    private TableColumn<Map.Entry<String,String>, String> wordCol;
    @FXML
    private TableColumn<Map.Entry<String,String>, String> descriptionCol;
    @FXML
    private TextField addWord;
    @FXML
    private TextField addDescription;
    @FXML
    private TextField deleteName;
    @FXML
    private TextField updateName;
    @FXML
    private TextField updateDescription;
    @FXML
    private TextField searchName;
    @FXML
    private TextField saveFileAs;

    private final Alert error;
    private final Alert info;
    private  Dictionary dictionary;

    //Initializes the dictionary and alerts for further use
    public void initialize() {
        tableView.setPlaceholder(new Label("No Words in the dictionary"));
        wordCol.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey()));
        descriptionCol.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getValue()));
    }

    //Constructor
    public DictionaryController(){
        dictionary = new Dictionary();
        error = new Alert(Alert.AlertType.ERROR);
        info = new Alert(Alert.AlertType.INFORMATION);
    }

    //This function uses the add function in the Dictionary class to add a new word and checks that the text fields are ok
    @FXML
    void addWord(ActionEvent event) {
        if(addWord.getText() != null && !addWord.getText().trim().isEmpty() && addDescription.getText() != null && !addDescription.getText().trim().isEmpty()) {
            dictionary.addNewWord(addWord.getText(), addDescription.getText());
            displayDictionary();
        } else if(addWord.getText() == null || addWord.getText().trim().isEmpty() || addDescription.getText() == null || addDescription.getText().trim().isEmpty()){
            error.setContentText("One of the fields is empty, please enter a word and description");
            error.show();
        }
        addWord.setText("");
        addWord.setPromptText("Add new word");
        addDescription.setText("");
        addDescription.setPromptText("Add new Description");
    }

    //This function uses the delete function in the Dictionary class to delete a word from the dictionary
    @FXML
    void deleteWord(ActionEvent event) {
        dictionary.delete(deleteName.getText());
        deleteName.setPromptText("Delete word");
        deleteName.setText("");
        displayDictionary();
    }

    //This function uses the search function in the Dictionary class to show to outcome of the search on in the tableview and checks that the text fields are ok
    @FXML
    void searchWord(ActionEvent event) {
        if(!searchName.getText().trim().isEmpty()){
            tableView.getItems().clear();
            tableView.getItems().addAll(dictionary.search(searchName.getText()).entrySet());
        } else {
            displayDictionary();
        }
    }

    //This function uses the update function in the Dictionary class to update a description and show in the tableview and checks that the text fields are ok
    @FXML
    void updateDesc(ActionEvent event) {
        if(updateName.getText() != null && !updateName.getText().trim().isEmpty() && updateDescription.getText() != null && !updateDescription.getText().trim().isEmpty()) {
            dictionary.updateDictionary(updateName.getText(), updateDescription.getText());
            displayDictionary();
        } else if(updateName.getText() == null || updateName.getText().trim().isEmpty() || updateDescription.getText() == null || updateDescription.getText().trim().isEmpty()){
            error.setContentText("One of the fields is empty, please enter a word and description");
            error.show();
        }
    }

    //This function lets the user save a file containing the dictionary displayed in the tableview
    @FXML
    void SaveAsFile(ActionEvent event) {
        if(saveFileAs.getText() != null && !saveFileAs.getText().trim().isEmpty()) {
            try{
                FileOutputStream fo = new FileOutputStream(saveFileAs.getText() + ".txt");
                ObjectOutputStream out = new ObjectOutputStream(fo);
                out.writeObject(dictionary);
                out.close();
                info.setContentText("The dictionary was saved in the file: " + saveFileAs.getText());
                info.show();
            } catch (IOException e){
                error.setContentText(e.getMessage());
                error.show();
            }
        } else {
            info.setContentText("File name is empty, please enter a file name and try again");
            info.show();
        }
        saveFileAs.setText("");
        saveFileAs.setPromptText("File name");
    }

    //This function lets the user choose a file from the file directory and show it in the tableview
    @FXML
    void loadFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose dictionary");
        fc.setInitialDirectory(new File("."));
        File file = fc.showOpenDialog(null);
        if(file != null) {
            try {
                String fileName = file.getName();
                FileInputStream fi = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fi);
                dictionary= (Dictionary) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                error.setContentText(e.getMessage());
                error.show();
            } finally {
                displayDictionary();
            }
        }
    }

    //This function displays the dictionary in the tableview
    private void displayDictionary(){
        tableView.getItems().clear();
        tableView.getItems().addAll(dictionary.getDictionary().entrySet());
    }
}
