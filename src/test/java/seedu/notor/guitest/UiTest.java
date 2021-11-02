package seedu.notor.guitest;

import static org.testfx.api.FxAssert.verifyThat;

import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import seedu.notor.logic.commands.NoteCommand;


public class UiTest extends ApplicationTest {

    public static final String COMMAND_BOX_ID = "#commandTextField";
    public static final String NOTE_TEXTAREA_ID = "#noteTextArea";
    public static final String TEST_TEXT = "hello world 121234~ hello world";


    //    @BeforeAll
    //    public static void headlessSetUp() {
    //        System.setProperty("testfx.robot", "glass");
    //        System.setProperty("testfx.headless", "true");
    //    }

    @BeforeEach
    public void setup() throws Exception {
        ApplicationTest.launch(MainAppStub.class);
    }

    @Override
    public void start(Stage stage) {
        stage.show();
    }


    @AfterEach
    public void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void should_updateNoteWindowTextArea_onAddText() {
        clickOn(COMMAND_BOX_ID).write(NoteCommand.COMMAND_WORD);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        clickOn(NOTE_TEXTAREA_ID).write(TEST_TEXT);
        verifyThat(NOTE_TEXTAREA_ID, (TextArea textArea) -> textArea.getText().equals(TEST_TEXT));
        MainAppStub.removeTestFile();
    }
}
