package seedu.notor.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.notor.commons.exceptions.IllegalValueException;
import seedu.notor.logic.parser.ParserUtil;
import seedu.notor.model.group.SuperGroup;

public class JsonAdaptedSuperGroup {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Group's format is wrong!";

    private final String name;

    private List<JsonAdaptedSubGroup> subGroups = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedSuperGroup} with the given group details.
     */
    @JsonCreator
    public JsonAdaptedSuperGroup(@JsonProperty("name") String name,
            @JsonProperty("subGroups") List<JsonAdaptedSubGroup> subGroups) {
        this.name = name;
        this.subGroups.addAll(subGroups);
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedSuperGroup(SuperGroup source) {
        this.name = source.getName();
        subGroups.addAll(source.getSubGroups().asUnmodifiableObservableList().stream()
                .map(JsonAdaptedSubGroup::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted SuperGroup object into the model's {@code SuperGroup}
     * and {@code SuperGroup} objects.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public SuperGroup toModelType() throws IllegalValueException {
        SuperGroup group = ParserUtil.parseSuperGroup(name);
        for (JsonAdaptedSubGroup subGroup : this.subGroups) {
            group.addSubGroup(subGroup.toModelType());
        }
        return group;
    }
}
