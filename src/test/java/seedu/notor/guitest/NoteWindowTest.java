package seedu.notor.guitest;

import static org.testfx.api.FxAssert.verifyThat;

import org.junit.jupiter.api.Test;

import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import seedu.notor.logic.commands.NoteCommand;
import seedu.notor.ui.note.NoteWindow;



public class NoteWindowTest extends UiTest {
    public static final String COMMAND_BOX_ID = "#commandTextField";
    public static final String NOTE_TEXTAREA_ID = "#noteTextArea";
    public static final String GENERAL_NOTE_PANEL_ID = "#generalNote";
    public static final String TEST_TEXT = "hello world 121234~ hello world";


    @Test
    public void should_updateNoteWindowTextArea_onAddText() {
        clickOn(COMMAND_BOX_ID).write(NoteCommand.COMMAND_WORD);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        clickOn(NOTE_TEXTAREA_ID).write(TEST_TEXT);
        verifyThat(NOTE_TEXTAREA_ID, (TextArea textArea) -> textArea.getText().equals(TEST_TEXT));
        MainAppStub.removeTestFile();
    }

    //    @Test
    //    public void should_containsSameContentForNotePaneAndNoteWindow_onSaved() {
    //        clickOn(COMMAND_BOX_ID).write(NoteCommand.COMMAND_WORD);
    //        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
    //
    //        clickOn(NOTE_TEXTAREA_ID).write(TEST_TEXT);
    //        clickOn(NOTE_TEXTAREA_ID).push((KeyCodeCombination) NoteWindow.EXIT_AND_SAVE_KEY);
    //
    //        verifyThat(GENERAL_NOTE_PANEL_ID, (TextArea textArea) -> textArea.getText().equals(TEST_TEXT));
    //        MainAppStub.removeTestFile();
    //    }

    @Test
    public void should_promptConfirmationWindow_onExitNoteWithoutSaving() {

        clickOn(COMMAND_BOX_ID).write(NoteCommand.COMMAND_WORD);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);

        clickOn(NOTE_TEXTAREA_ID).write(TEST_TEXT);

        clickOn(NOTE_TEXTAREA_ID).push((KeyCodeCombination) NoteWindow.EXIT_KEY);
        clickOn("#doNotSaveButton");
        MainAppStub.removeTestFile();
    }

}
