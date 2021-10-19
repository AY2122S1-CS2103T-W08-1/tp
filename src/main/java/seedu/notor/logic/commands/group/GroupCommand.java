package seedu.notor.logic.commands.group;

import seedu.notor.commons.core.index.Index;
import seedu.notor.logic.commands.TargetedCommand;

public abstract class GroupCommand extends TargetedCommand {
    public static final String MESSAGE_USAGE = "Please use the help command to find out how to use the bot.";

    public static final String COMMAND_WORD = "group";
    protected final Index index;

    public GroupCommand(Index index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GroupCommand)) {
            return false;
        }

        // state check
        GroupCommand e = (GroupCommand) other;
        return index.equals(e.index);
    }
}
