package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Archive;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class ArchiveContentStrategy extends ComponentContentStrategy {
    private final Archive archive;

    public ArchiveContentStrategy(Archive archive) {
        this.archive = archive;
    }

    @Override
    public String getContentAsString() {
        var marks = archive.marks ().getAll ();

        if(marks.isEmpty () || marks == null)
            return "\nSorry, there aren't any marks...\n";

        var stringBuilder = new StringBuilder ();

        marks.forEach (mark -> {
            stringBuilder.append ("\nStudentID: " + mark.getStudentId () );
            stringBuilder.append ("\nMark: " + mark.getMark ());
            stringBuilder.append ("\nCourse: " + mark.getCourseId ());
            stringBuilder.append ("\n");
        });

        return stringBuilder.toString ();
    }
}
