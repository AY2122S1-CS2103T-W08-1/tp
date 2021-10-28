package seedu.notor.logic.commands.person;

import static java.util.Objects.requireNonNull;
import static seedu.notor.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.notor.logic.commands.Command;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.model.Model;

/**
 * Lists all persons in Notor to the user.
 */
public class PersonListCommand implements Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
