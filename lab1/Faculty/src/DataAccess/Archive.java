package DataAccess;

import Abstractions.DataAccess.Repositories.MarkRepository;

public class Archive implements Abstractions.DataAccess.Archive {
    private final MarkRepository markRepository;

    public Archive(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public MarkRepository marks(){
        return markRepository;
    }
}
