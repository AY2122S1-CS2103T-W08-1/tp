package seedu.notor.ui;


import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import seedu.notor.logic.commands.exceptions.CommandException;

public class ConfirmationWindow extends UiPart<Stage> {

    private static final String FXML = "ConfirmationWindow.fxml";
    private static final String SAVE_MESSAGE = "Do you want to save the notes for %s?";

    @FXML
    private TextFlow textFlow;

    private final NoteWindow noteWindow;

    /**
     * Creates a Confirmation Window if user attempts to exits without saving.
     *
     * @param personName of NoteWindow.
     */
    public ConfirmationWindow(String personName, NoteWindow noteWindow) {
        super(FXML);
        Text text = new Text(String.format(SAVE_MESSAGE, personName));
        textFlow.getChildren().add(text);
        this.noteWindow = noteWindow;
        getRoot().setTitle("Note");
        getRoot().initModality(Modality.APPLICATION_MODAL);
        getRoot().setResizable(false);
    }

    /**
     *
     */
    public void show() {
        getRoot().showAndWait();
        getRoot().centerOnScreen();
    }

    /**
     * Saves and exits both Note Window and Confirmation Window upon clicking save button.
     *
     * @throws CommandException commandException
     */
    @FXML
    public void onClickSave() throws CommandException {
        getRoot().close();
        noteWindow.handleSaveAndExit();
    }

    /**
     * Exits both Note Window and Confirmation Window without saving note upon clicking don't save button.
     */
    @FXML
    public void onClickDoNotSave() {
        getRoot().close();
        noteWindow.setForceExit();
        noteWindow.handleExit();
    }

    /**
     * Exits Confirmation Window upon clicking cancel button.
     */
    @FXML
    public void onClickCancel() {
        getRoot().close();
    }


}
