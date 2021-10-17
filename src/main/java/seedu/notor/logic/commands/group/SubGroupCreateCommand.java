package seedu.notor.logic.commands.group;

import static seedu.notor.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.notor.commons.core.index.Index;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.commands.exceptions.CommandException;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.logic.executors.group.GroupExecutor;
import seedu.notor.logic.executors.group.SubGroupCreateExecutor;
import seedu.notor.model.group.SubGroup;

public class SubGroupCreateCommand extends GroupCommand {
    public static final String COMMAND_WORD = "create";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a group. "
            + "Parameters: "
            + COMMAND_WORD
            + "GROUP "
            + PREFIX_TAG + "TAGS... "
            + "Example: " + COMMAND_WORD
            + "Orbital";

    private final GroupExecutor executor;

    public SubGroupCreateCommand(Index index, SubGroup subGroup) {
        super(index);
        this.executor = new SubGroupCreateExecutor(index, subGroup);
    }


    @Override public CommandResult execute() throws CommandException, ExecuteException {
        return executor.execute();
    }
}
