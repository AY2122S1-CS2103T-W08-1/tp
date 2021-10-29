package seedu.notor.logic.executors.group;

import static java.util.Objects.requireNonNull;

import seedu.notor.commons.core.Messages;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.executors.exceptions.ExecuteException;

/**
 * Executor for a PersonViewCommand.
 */
//public class SuperGroupViewExecutor extends GroupExecutor {
//
//    public SuperGroupViewExecutor() {
//        super(index);
//    }
//
//    @Override
//    public CommandResult execute() throws ExecuteException {
//        requireNonNull(model);
//        // TODO: Should we create a new method lol in model.
//        model.viewSuperGroups();
//        return new CommandResult(
//                String.format(Messages.MESSAGE_GROUPS_LISTED_OVERVIEW, model.getFilteredGroupList().size()));
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        // short circuit if same object
//        if (other == this) {
//            return true;
//        }
//
//        // instanceof handles nulls
//        if (!(other instanceof SuperGroupViewExecutor)) {
//            return false;
//        }
//        // state check
//        return super.equals(other);
//    }
//}