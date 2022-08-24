package wtf.nebula.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wtf.nebula.util.Globals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A repository for a feature of Nebula
 *
 * @author aesthetical
 * @since 06/27/22
 */
public abstract class BaseRepository<T> implements Globals {
    protected final Map<Class, T> childMap = new HashMap<>();
    protected final List<T> children = new ArrayList<>();

    protected Logger log;

    public BaseRepository() {
        if (getClass().isAnnotationPresent(Repository.class)) {
            Repository repo = getClass().getAnnotation(Repository.class);

            // create a logger
            log = LogManager.getLogger(repo.value());
        }
    }

    /**
     * The method repositories are called from for initialization
     */
    public abstract void init();

    /**
     * Adds a child to this repository
     * @param child the child instance
     */
    public abstract void addChild(T child);

    public List<T> getChildren() {
        return children;
    }
}
