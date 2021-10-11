package seedu.address.logic.executors.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.executors.exceptions.ExecuteException;
import seedu.address.model.person.Person;

public class PersonCreateExecutor extends PersonExecutor {
    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    protected Person person;

    public PersonCreateExecutor(Index index, Person person) {
        super(index);
        requireNonNull(person);
        this.person = person;
    }

    @Override
    public CommandResult execute() throws ExecuteException {
        if (model.hasPerson(person)) {
            throw new ExecuteException(MESSAGE_DUPLICATE_PERSON);
        }

        model.createPerson(person);
        return new CommandResult(String.format(MESSAGE_SUCCESS, person));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCreateExecutor)) {
            return false;
        }

        PersonCreateExecutor e = (PersonCreateExecutor) other;

        // state check
        return super.equals(other) && person.equals(e.person);
    }
}
