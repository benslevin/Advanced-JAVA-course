import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.TreeMap;

//This class implements the logic of the dictionary and uses the functions of the TreeMap to do all the necessary work
public class Dictionary implements Serializable {

    private  TreeMap<String,String> dictionary = new TreeMap<>();
    private transient static final Alert warning = new Alert(Alert.AlertType.WARNING);
    private static final long serialVersionUID=1L;

    //Getter
    protected TreeMap<String, String> getDictionary() {
        return dictionary;
    }

    //This function adds a new word to the dictionary and displays all the word in it
    protected  void addNewWord(String word, String description){
        if(dictionary.containsKey(word)) {
            warning.setContentText("The word already exists in the dictionary");
            warning.show();
        }
        else if(validWord(word) && validWord(description)){
            dictionary.put(word,description);
        } else {
            warning.setContentText("The word or description are invalid, please try again");
            warning.show();
        }
    }

    //This function deletes a word from the dictionary
    protected  void delete(String word){
        if(dictionary.containsKey(word)){
            dictionary.remove(word);
        } else {
            warning.setContentText("The word entered does not exist in the dictionary, please enter a different word");
            warning.show();
        }
    }

    //This function searches a word in the dictionary and displays the word found
    protected TreeMap<String,String> search(String word){
        if(dictionary.containsKey(word)){
            return new TreeMap<String,String>() {{put(word, dictionary.get(word));}};
        } else {
            return new TreeMap<String,String>();
        }
    }

    //This function updates a description of a word in the dictionary and displays the updated dictionary
    protected  void updateDictionary(String word, String description){
        if(dictionary.containsKey(word)){
            if(validWord(description)) {
                dictionary.put(word, description);
            } else {
                warning.setContentText("The description is invalid, please try again");
                warning.show();
            }
        } else {
            warning.setContentText("The word does not exist in the dictionary");
            warning.show();
        }
    }

    //This function validates the input of words from the user
    private static boolean validWord(String word){
        return word.matches("^[^0-9]*$"); //Checks to see if there are any numbers in the word or description
    }

    //This function overrides the toString method in object class
    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary+
                '}';
    }
}
