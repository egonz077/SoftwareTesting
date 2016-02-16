package Storage;

import ApplicationLogic.ClassDetails;

import java.util.Collection;

public class BackendFacade {

    Course c;

    public BackendFacade(String substring, String substring1) {
        c = new Course(substring, substring1);
    }

    public BackendFacade() {

    }

    public boolean isLoginValid(String pantherID, String pass) {
        return new DatabaseInterface().isLoginValid(pantherID, pass);
    }


    public Collection<ClassDetails> getClasses(String term, Collection<String> campus) {
        return c.getClasses(term, campus);
    }
}
