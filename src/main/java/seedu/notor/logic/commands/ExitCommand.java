package seedu.notor.logic.commands;

import seedu.notor.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand implements Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, false,
                null, true);
    }

}