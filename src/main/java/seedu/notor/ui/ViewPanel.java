package seedu.notor.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.notor.model.common.Note;

/**
 * Viewing panel of object T.
 */
public class ViewPanel extends UiPart<Region> {
    private static final String FXML = "ViewPanel.fxml";

    @FXML
    protected VBox vbox;
    @FXML
    protected Label name;
    @FXML
    protected Label note;

    /**
     * Creates a {@code ViewPanel}.
     */
     public ViewPanel(Note theNote) {
        super(FXML);
        note.setText(theNote.value);
     }
}
