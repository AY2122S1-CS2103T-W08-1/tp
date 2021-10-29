//package seedu.notor.logic.commands.group;
//
//import seedu.notor.commons.core.index.Index;
//import seedu.notor.logic.commands.CommandResult;
//import seedu.notor.logic.executors.exceptions.ExecuteException;
//import seedu.notor.logic.executors.group.GroupExecutor;
//import seedu.notor.logic.executors.group.SuperGroupCreateExecutor;
//import seedu.notor.logic.executors.group.SuperGroupListExecutor;
//import seedu.notor.model.group.SuperGroup;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static java.util.Objects.requireNonNull;
//
//public class SuperGroupViewCommand extends GroupCommand {
//    public static final String COMMAND_WORD = "view";
//    public static final List<String> COMMAND_WORDS = Arrays.asList("view", "v");
//
//    private static final String COMMAND_DESCRIPTION =
//            ": Views all groups\n";
//
//    public static final String MESSAGE_USAGE = GroupCommand.COMMAND_WORD + " /" + COMMAND_WORD + " "
//            + COMMAND_DESCRIPTION
//            + "Example: "
//            + GroupCommand.COMMAND_WORD + " /" + COMMAND_WORD;
//
//    private final SuperGroupViewExecutor executor;
//
//    /**
//     * Constructor for a PersonListCommand.
//     */
//    public SuperGroupViewCommand(Index index) {
//        super(null);
//        this.executor = new SuperGroupViewExecutor(index);
//    }
//
//    @Override
//    public CommandResult execute() throws ExecuteException {
//        return executor.execute();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        // short circuit if same object
//        return (other instanceof PersonListCommand); // instanceof handles nulls
//    }
//}
