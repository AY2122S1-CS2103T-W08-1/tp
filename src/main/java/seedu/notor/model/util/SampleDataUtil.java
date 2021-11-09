package seedu.notor.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import seedu.notor.commons.core.LogsCenter;
import seedu.notor.commons.util.DateUtil;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.model.Notor;
import seedu.notor.model.ReadOnlyNotor;
import seedu.notor.model.common.Name;
import seedu.notor.model.common.Note;
import seedu.notor.model.group.SubGroup;
import seedu.notor.model.group.SuperGroup;
import seedu.notor.model.person.Email;
import seedu.notor.model.person.Person;
import seedu.notor.model.person.Phone;
import seedu.notor.model.tag.Tag;

/**
 * Contains utility methods for populating {@code Notor} with sample data.
 */
public class SampleDataUtil {
    public static final Note EMPTY_NOTE = Note.of("", "");
    public static final String DATE_TIME_NOW = DateUtil.getCurrentDateTime();

    private static final Logger logger = LogsCenter.getLogger(SampleDataUtil.class);

    // @formatter:off
    public static Person[] getSamplePersons() {
        return new Person[]{
                new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                        Note.of("Agenda \n Review Milestone 2", DATE_TIME_NOW), getTagSet("SWE")),
                new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        Note.of("Agenda \n Milestone 2 Consultation", DATE_TIME_NOW), getTagSet()),
                new Person(new Name("Charlotte Oliveiro"), new Phone("92218221"), new Email("olicharlotte@example.com"),
                        EMPTY_NOTE, getTagSet("AI")),
                new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                        Note.of("Consultation tommorrow.", DATE_TIME_NOW), getTagSet("Database")),
                new Person(new Name("Irfan Ibrahim"), new Phone("91003210"), new Email("irfan@example.com"),
                        Note.of("Agenda \n Review Project.", DATE_TIME_NOW), getTagSet("Y4", "SWE")),
                new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                        Note.of("Agenda \n FYP Second Draft", DATE_TIME_NOW), getTagSet("Y4", "SWE")),
                new Person(new Name("Bridget Miller"), new Phone("80809192"), new Email("bridgetm@example.com"),
                        Note.of("Private tutorial tomorrow.", DATE_TIME_NOW), getTagSet("Y2", "Media")),
                new Person(new Name("Dorothy Ricks"), new Phone("92019202"), new Email("rickrolldorothy@example.com"),
                        Note.of("Meeting soon", DATE_TIME_NOW), getTagSet("Colleague")),
                new Person(new Name("Danya Fulbright"), new Phone("98071455"), new Email("fullybright@example.com"),
                        Note.of("Meeting soon", DATE_TIME_NOW), getTagSet("Colleague")),
                new Person(new Name("John Smith"), new Phone("91902492"), new Email("smithbro1@example.com"),
                        Note.of("Agenda \n Game review", DATE_TIME_NOW), getTagSet("Y1", "Game Dev")),
                new Person(new Name("Jack Smith"), new Phone("98771920"), new Email("smithbro2@example.com"),
                        Note.of("Agenda \n Game review", DATE_TIME_NOW), getTagSet("Y1", "Game Dev")),
                new Person(new Name("Port Kennings"), new Phone("90912822"), new Email("porterken@example.com"),
                        Note.of("Private tutorial this evening", DATE_TIME_NOW), getTagSet("Y2", "Media")),
                new Person(new Name("Lakia Dream"), new Phone("99995555"), new Email("onebulletdream@example.com"),
                        EMPTY_NOTE, getTagSet("Y3", "SWE")),
                new Person(new Name("Gunner Claussell"), new Phone("82820192"), new Email("fierygunner@example.com"),
                        Note.of("Milestone 2 Orbital", DATE_TIME_NOW), getTagSet("Y2", "Database")),
                new Person(new Name("Cortana Arthur"), new Phone("87102933"), new Email("cortanasiri@example.com"),
                        Note.of("Agenda \n Review Resume", DATE_TIME_NOW), getTagSet("Grad", "Database")),
                new Person(new Name("Zhang Li Hui"), new Phone("88012292"), new Email("lihuizhang@example.com"),
                        Note.of("Agenda \n Review Resume", DATE_TIME_NOW), getTagSet("Grad", "AI")),
                new Person(new Name("Carole Reinn"), new Phone("80000012"), new Email("tuesdaycarole@example.com"),
                        Note.of("Milestone 2 Orbital", DATE_TIME_NOW), getTagSet("Y2", "Algo")),
                new Person(new Name("Timothy Jason"), new Phone("85550292"), new Email("jasontim420@example.com"),
                        EMPTY_NOTE, getTagSet("Grad", "Algo")),
                new Person(new Name("Hannah Goh"), new Phone("83102101"), new Email("hannahgo@example.com"),
                        Note.of("Submit Report", DATE_TIME_NOW), getTagSet("Senior", "Admin")),
                new Person(new Name("Louwe Trevis"), new Phone("98000012"), new Email("kingmaster@example.com"),
                        Note.of("Meeting soon", DATE_TIME_NOW), getTagSet("Colleague")),
        };
    }

    public static ReadOnlyNotor getSampleNotor() {
        try {
            Notor sampleAb = new Notor();
            for (Person samplePerson : getSamplePersons()) {
                sampleAb.addPerson(samplePerson);
            }
            SuperGroup orbital = new SuperGroup(new Name("Orbital"), new HashSet<>(),
                    Note.of("School of Computing’s 1st year summer self-directed, independent work course. " +
                            "This programme gives students the opportunity to pick up software development skills on " +
                            "their own, using sources on the web. " +
                            "All while receiving course credit in the form of 4 modular credits of " +
                            "Unrestricted Electives (UE)", DATE_TIME_NOW));
            SuperGroup finalYearProject = new SuperGroup(new Name("FYP"), new HashSet<>(),
                    Note.of("a mix of research, design and development components on a topic of " +
                            "current interest in Computer Engineering", DATE_TIME_NOW));
            SuperGroup projectAB = new SuperGroup(new Name("ProjectAB"), new HashSet<>(),
                    Note.of("Private project conducted for students who " +
                            "have a hard time accessing SE projects.", DATE_TIME_NOW));
            SubGroup artemis = new SubGroup(new Name("Artemis"), new HashSet<>(), "Orbital");
            SubGroup apollo = new SubGroup(new Name("Apollo"), new HashSet<>(), "Orbital");
            SubGroup gemini = new SubGroup(new Name("Gemini"), new HashSet<>(), "Orbital");
            SubGroup vostox = new SubGroup(new Name("Vostox"), new HashSet<>(), "Orbital");
            SubGroup basic = new SubGroup(new Name("Basic"), new HashSet<>(), "ProjectAB");
            SubGroup intermediate = new SubGroup(new Name("Intermediate"), new HashSet<>(), "ProjectAB");
            SubGroup advanced = new SubGroup(new Name("Advanced"), new HashSet<>(), "ProjectAB");

            orbital.addSubGroup(artemis);
            orbital.addSubGroup(apollo);
            orbital.addSubGroup(gemini);
            orbital.addSubGroup(vostox);
            projectAB.addSubGroup(basic);
            projectAB.addSubGroup(intermediate);
            projectAB.addSubGroup(advanced);

            sampleAb.addSuperGroup(orbital);
            sampleAb.addSuperGroup(finalYearProject);
            sampleAb.addSuperGroup(projectAB);
            sampleAb.addPersonToSuperGroup(orbital, "Alex Yeoh", "Bernice Yu", "Charlotte Oliveiro",
                    "David Li", "Port Kennings", "Lakia Dream", "Gunner Claussell", "Carole Reinn");
            sampleAb.addPersonToSuperGroup(finalYearProject, "Irfan Ibrahim", "Roy Balakrishnan");
            sampleAb.addPersonToSuperGroup(projectAB, "Bridget Miller", "John Smith", "Jack Smith",
                    "Port Kennings", "Cortana Arthur", "Zhang Li Hui");
            sampleAb.addPersonToSubGroup(apollo, "Alex Yeoh", "Bernice Yu");
            sampleAb.addPersonToSubGroup(artemis, "Charlotte Oliveiro");
            sampleAb.addPersonToSubGroup(basic, "John Smith", "Jack Smith");
            sampleAb.addPersonToSubGroup(intermediate, "Bridget Miller", "Port Kennings");
            sampleAb.addPersonToSubGroup(advanced, "Cortana Arthur", "Zhang Li Hui");



            return sampleAb;
        } catch (ExecuteException e) {
            e.printStackTrace();
            logger.info("An unexpected error occurred when creating sample data."
                    + "Will be starting with an empty Notor.");
            return new Notor();
        }
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
