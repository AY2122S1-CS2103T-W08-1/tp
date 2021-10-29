package seedu.notor.model;

import seedu.notor.model.common.Name;
import seedu.notor.model.common.Note;

public interface Notable {

    public abstract Name getName();
    public abstract Note getNote();

}
