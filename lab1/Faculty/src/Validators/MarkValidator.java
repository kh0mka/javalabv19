package Validators;

import Abstractions.Validators.Base.Validator;
import Entities.Mark;

public class MarkValidator extends Validator<Mark> {
    public int validate (int mark)  {
        if(mark > 10) {
            return 10;
        }
        if(mark < 1) {
            return 1;
        }

        return mark;
    }
}
