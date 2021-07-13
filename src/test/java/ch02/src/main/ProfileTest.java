package ch02.src.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
        profile = new Profile("Bull Hockey, Inc");
        question = new BooleanQuestion(1, "Got Bonused?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {

        profile.add(new Answer(question, Bool.FALSE));
        Criterion criterion = new Criterion(
                new Answer(question, Bool.TRUE),
                Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertFalse(matches);

    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {

        profile.add(new Answer(question, Bool.FALSE));
        Criterion criterion = new Criterion(
                new Answer(question, Bool.TRUE),
                Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }

    @Test
    public void matchAnswersFalseWhenCriteriaIsEmtpty() {

        profile.add(new Answer(question, Bool.FALSE));
        boolean matches = profile.matches(criteria);
        assertFalse(matches);

    }

    @Test(expected = NullPointerException.class)
    public void throwNpeWhenProfileAnswerIsNull() {
        profile.add(null);
        Criterion criterion = new Criterion(
                new Answer(question, Bool.TRUE),
                Weight.DontCare);
        criteria.add(criterion);
        boolean matches = profile.matches(criteria);
    }

    @Test(expected = NullPointerException.class)
    public void throwNpewhenCriterionAnswerIsNull() {
        profile.add(new Answer(question, Bool.FALSE));
        Criterion criterion = new Criterion(
                null, Weight.MustMatch
        );
        criteria.add(criterion);
        boolean matches = profile.matches(criteria);
    }
}
