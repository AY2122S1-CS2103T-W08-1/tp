package seedu.notor.guitest;

import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationAdapter;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;


public class UiTest extends ApplicationTest {

    @BeforeAll
    public static void headlessSetUp() {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
    }

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
        FxToolkit.cleanupStages();
        FxToolkit.cleanupApplication(new ApplicationAdapter(this));
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

}
