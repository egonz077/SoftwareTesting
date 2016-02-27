package Storage;

import ApplicationLogic.ClassDetails;

import java.util.Collection;

public class BackendFacade {

    private String subject;
    private String catlgNbr;

    public BackendFacade(String substring, String substring1) {
        this.subject = substring;
        this.catlgNbr = substring1;
    }

    public BackendFacade() {

    }

    public boolean isLoginValid(String pantherID, String pass) {
        return new DatabaseStub().isLoginValid(pantherID, pass);
    }

    public Collection<ClassDetails> getClasses(String term, Collection<String> campus) {
        return new DatabaseStub(subject, catlgNbr).getClasses(term, campus);
    }
}
