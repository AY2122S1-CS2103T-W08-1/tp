package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.GroupCreateCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.PersonAddGroupCommand;
import seedu.address.logic.commands.PersonAddSubGroupCommand;
import seedu.address.logic.commands.PersonRemoveGroupCommand;
import seedu.address.logic.commands.PersonRemoveSubGroupCommand;
import seedu.address.logic.commands.person.PersonCreateCommand;
import seedu.address.logic.commands.person.PersonDeleteCommand;
import seedu.address.logic.commands.person.PersonEditCommand;
import seedu.address.logic.commands.person.PersonNoteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.person.PersonCreateCommandParser;
import seedu.address.logic.parser.person.PersonDeleteCommandParser;
import seedu.address.logic.parser.person.PersonEditCommandParser;
import seedu.address.logic.parser.person.PersonNoteCommandParser;

/**
 * Parses user input.
 */
public class AddressBookParser {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {

        case PersonCreateCommand.COMMAND_WORD:
            return new PersonCreateCommandParser().parse(arguments);

        case PersonEditCommand.COMMAND_WORD:
            return new PersonEditCommandParser().parse(arguments);

        case PersonDeleteCommand.COMMAND_WORD:
            return new PersonDeleteCommandParser().parse(arguments);

        case PersonNoteCommand.COMMAND_WORD:
            return new PersonNoteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case GroupCreateCommand.COMMAND_WORD:
            return new GroupCreateCommandParser().parse(arguments);

        case PersonAddGroupCommand.COMMAND_WORD:
            return new PersonAddGroupCommandParser().parse(arguments);

        case PersonAddSubGroupCommand.COMMAND_WORD:
            return new PersonAddSubGroupCommandParser().parse(arguments);

        case PersonRemoveGroupCommand.COMMAND_WORD:
            return new PersonRemoveGroupCommandParser().parse(arguments);

        case PersonRemoveSubGroupCommand.COMMAND_WORD:
            return new PersonRemoveSubGroupCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
