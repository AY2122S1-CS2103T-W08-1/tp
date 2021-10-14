package seedu.notor.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.notor.commons.core.GuiSettings;
import seedu.notor.model.group.SubGroup;
import seedu.notor.model.group.SuperGroup;
import seedu.notor.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    // TODO: List
    // Predicate<Group> PREDICATE_SHOW_ALL_GROUPS = unused -> true;
    
    //=========== UserPrefs ==================================================================================
    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getNotorFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setNotorFilePath(Path notorFilePath);
    
    //=========== Notor =====================================================================================
    
    /**
     * Replaces Notor data (of the list) with the data in {@code notor}.
     */
    void setNotor(ReadOnlyNotor notor);

    /**
     * Returns the Notor data (lists and the like)
     */
    ReadOnlyNotor getNotor();

    /**
     * Returns true if a person with the same identity as {@code person} exists in Notor.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in Notor.
     */
    void createPerson(Person person);

    /**
     * Finds the given person.
     */
    Person findPerson(String name);

    /**
     * Returns true if the SuperGroup exist.
     */
    boolean hasSuperGroup(SuperGroup superGroup);

    void addSuperGroup(SuperGroup superGroup);

    void deleteSuperGroup(SuperGroup superGroup);

    SuperGroup findSuperGroup(String name);

    SubGroup findSubGroup(String name);

    void addSubGroup(SubGroup subGroup);

    void deleteSubGroup(SubGroup subGroup);

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);
}