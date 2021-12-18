/**
 * An interface for an object that can be plundered.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public interface Plunderable {

    /**
     * Displays the contents of the object that is plundered.
     *
     * @return array of looted items
     */
    Loot[] bePlundered();
}
