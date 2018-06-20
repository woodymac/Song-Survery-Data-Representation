package prj5;

/**
 * Contains abstract methods to be implemented by the SongReader and
 * SurveyReader classes.
 * 
 * @author jaredblumen
 * @verison 2018 April 9
 * 
 * @param <T>
 *            The generic type, will be string when implemented.
 */
public interface Iterator<T> {
    public abstract boolean hasNext();


    public abstract T next();


    public abstract boolean hasNextLine();


    public abstract T nextLine();
}
