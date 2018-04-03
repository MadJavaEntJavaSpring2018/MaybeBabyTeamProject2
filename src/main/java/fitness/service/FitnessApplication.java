package fitness.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the main application service class.
 */

@ApplicationPath("/fitness")
public class FitnessApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(FitnessService.class); // Don't forget to add any new service class you may create.
        return h;
    }
}
