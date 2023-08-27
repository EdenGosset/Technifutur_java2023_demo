package be.technifutur.spring.demo.validation.validators;


import be.technifutur.spring.demo.models.form.CompetitionForm;
import be.technifutur.spring.demo.validation.contraints.BeforeDate;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class BeforeDateValidator implements ConstraintValidator<BeforeDate, CompetitionForm> {

    @Override
    public void initialize(BeforeDate beforeDate) {
    }

    @Override
    public boolean isValid(CompetitionForm form, ConstraintValidatorContext context) {

        if (form.getInscriptionStart() != null && form.getInscriptionEnd() != null && form.getCompetitionStart() != null && form.getCompetitionEnd() != null) {
            return form.getInscriptionStart().isBefore(form.getInscriptionEnd()) &&
                    form.getInscriptionEnd().isBefore(form.getCompetitionStart()) &&
                    form.getCompetitionStart().isBefore(form.getCompetitionEnd());
        }
        return true;
    }
}
