package seedu.notor.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.notor.commons.core.GuiSettings;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.commands.exceptions.CommandException;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.logic.parser.exceptions.ParseException;
import seedu.notor.model.ReadOnlyAddressBook;
import seedu.notor.model.person.Person;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException, ExecuteException;


    /**
     * Executes instruction to save note of the person.
     *
     * @param person The person with yet to edit notes.
     * @param editedPerson The person with newly edited notes.
     * @throws CommandException
     */
    void executeSaveNote(Person person, Person editedPerson) throws CommandException;
    /**
     * Returns the AddressBook.
     *
     * @see seedu.notor.model.Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns an unmodifiable view of the filtered list of persons
     */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}