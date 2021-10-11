package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.person.PersonCreateCommand;
import seedu.address.logic.executors.Executor;
import seedu.address.logic.executors.exceptions.ExecuteException;
import seedu.address.logic.executors.person.PersonCreateExecutor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.group.Group;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class PersonCreateCommandTest {

	@Test
	public void constructor_nullPerson_throwsNullPointerException() {
		assertThrows(NullPointerException.class, () -> new PersonCreateCommand(null, null));
	}

	@Test
	public void execute_personAcceptedByModel_addSuccessful() throws Exception {
		ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
		Executor.setup(modelStub);

		Person validPerson = new PersonBuilder().build();

		CommandResult commandResult = new PersonCreateCommand(null, validPerson).execute(modelStub);

		assertEquals(String.format(PersonCreateExecutor.MESSAGE_SUCCESS, validPerson),
				commandResult.getFeedbackToUser());
		assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
	}

	// @formatter:off
    @Test
    public void execute_duplicatePerson_throwsCommandException() throws ParseException {
        Person validPerson = new PersonBuilder().build();
        PersonCreateCommand personCreateCommand = new PersonCreateCommand(null, validPerson);
        ModelStub modelStub = new ModelStubWithPerson(validPerson);
        Executor.setup(modelStub);

        assertThrows(ExecuteException.class, PersonCreateExecutor.MESSAGE_DUPLICATE_PERSON, ()
            -> personCreateCommand.execute(modelStub));
    }

    @Test
    public void equals() throws ParseException {
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        PersonCreateCommand addAliceCommand = new PersonCreateCommand(null, alice);
        PersonCreateCommand addBobCommand = new PersonCreateCommand(null, bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        PersonCreateCommand addAliceCommandCopy = new PersonCreateCommand(null, alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void createPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void createGroup(Group group) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasGroup(Group group) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteGroup(Group target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGroup(Group group, Group editedGroup) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Group> getFilteredGroupList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredGroupList(Predicate<Group> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Person person;

        ModelStubWithPerson(Person person) {
            requireNonNull(person);
            this.person = person;
        }

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return this.person.isSame(person);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Person> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return personsAdded.stream().anyMatch(person::isSame);
        }

        @Override
        public void createPerson(Person person) {
            requireNonNull(person);
            personsAdded.add(person);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
