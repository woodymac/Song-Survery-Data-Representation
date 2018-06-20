package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Tests the methods of the State class.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class StateTest extends student.TestCase {

    private State state;


    /**
     * Initializes variables.
     */
    public void setUp() {
        state = new State();
    }


    /**
     * Tests the add method.
     */
    public void testAdd() {
        // Should not change any fields
        // state.add(AttributeEnum.NORTHEAST, true, true);
        // assertEquals(0, state.getOutsideUSTotal());

        // Questions were unanswered, total is not updated
        state.add(AttributeEnum.NORTHEAST, false, true, false, true);
        assertEquals(0, state.getNEUSTotalHeard());
        assertEquals(0, state.getNEUSTotalLiked());

        state.add(AttributeEnum.NORTHEAST, true, true, true, false);
        state.add(AttributeEnum.NORTHEAST, true, true, true, false);
        state.add(AttributeEnum.NORTHEAST, true, true, true, false);
        state.add(AttributeEnum.NORTHEAST, true, false, true, true);
        state.add(AttributeEnum.NORTHEAST, true, false, true, true);
        assertEquals(5, state.getNEUSTotalHeard());
        assertEquals(5, state.getNEUSTotalLiked());
        assertEquals(3, state.getNEUSHeard());
        assertEquals(2, state.getNEUSLiked());

        // Questions were unanswered, total is not updated
        state.add(AttributeEnum.SOUTHEAST, false, true, false, true);
        assertEquals(0, state.getSEUSTotalHeard());
        assertEquals(0, state.getSEUSTotalLiked());

        state.add(AttributeEnum.SOUTHEAST, true, true, true, false);
        state.add(AttributeEnum.SOUTHEAST, true, true, true, false);
        state.add(AttributeEnum.SOUTHEAST, true, true, true, false);
        state.add(AttributeEnum.SOUTHEAST, true, false, true, true);
        state.add(AttributeEnum.SOUTHEAST, true, false, true, true);
        assertEquals(5, state.getSEUSTotalHeard());
        assertEquals(5, state.getSEUSTotalLiked());
        assertEquals(3, state.getSEUSHeard());
        assertEquals(2, state.getSEUSLiked());

        // Questions were unanswered, total is not updated
        state.add(AttributeEnum.OTHER_US, false, true, false, true);
        assertEquals(0, state.getOtherUSTotalHeard());
        assertEquals(0, state.getOtherUSTotalLiked());

        state.add(AttributeEnum.OTHER_US, true, true, true, false);
        state.add(AttributeEnum.OTHER_US, true, true, true, false);
        state.add(AttributeEnum.OTHER_US, true, true, true, false);
        state.add(AttributeEnum.OTHER_US, true, false, true, true);
        state.add(AttributeEnum.OTHER_US, true, false, true, true);
        assertEquals(5, state.getOtherUSTotalHeard());
        assertEquals(5, state.getOtherUSTotalLiked());
        assertEquals(3, state.getOtherUSHeard());
        assertEquals(2, state.getOtherUSLiked());

        // Questions were unanswered, total is not updated
        state.add(AttributeEnum.OUTSIDE_US, false, true, false, true);
        assertEquals(0, state.getOutsideUSTotalHeard());
        assertEquals(0, state.getOutsideUSTotalLiked());

        state.add(AttributeEnum.OUTSIDE_US, true, true, true, false);
        state.add(AttributeEnum.OUTSIDE_US, true, true, true, false);
        state.add(AttributeEnum.OUTSIDE_US, true, true, true, false);
        state.add(AttributeEnum.OUTSIDE_US, true, false, true, true);
        state.add(AttributeEnum.OUTSIDE_US, true, false, true, true);
        assertEquals(5, state.getOutsideUSTotalHeard());
        assertEquals(5, state.getOutsideUSTotalLiked());
        assertEquals(3, state.getOutsideUSHeard());
        assertEquals(2, state.getOutsideUSLiked());
    }


    /**
     * Tests the percentage getter methods.
     */
    public void testGetPercentage() {
        // add has not been called, so all should return 0
        assertEquals(0, state.getNEUSPercentHeard());
        assertEquals(0, state.getNEUSPercentLiked());
        assertEquals(0, state.getSEUSPercentHeard());
        assertEquals(0, state.getSEUSPercentLiked());
        assertEquals(0, state.getOtherUSPercentHeard());
        assertEquals(0, state.getOtherUSPercentLiked());
        assertEquals(0, state.getOutsideUSPercentHeard());
        assertEquals(0, state.getOutsideUSPercentLiked());

        state.add(AttributeEnum.NORTHEAST, true, false, true, false); // 0,0
        state.add(AttributeEnum.SOUTHEAST, true, true, true, false);
        state.add(AttributeEnum.SOUTHEAST, true, true, true, true); // 100,50
        state.add(AttributeEnum.OTHER_US, true, true, true, true);
        state.add(AttributeEnum.OTHER_US, true, false, true, true);
        state.add(AttributeEnum.OTHER_US, true, false, true, false); // 33,66
        state.add(AttributeEnum.OUTSIDE_US, true, true, true, true);
        state.add(AttributeEnum.OUTSIDE_US, true, true, true, false);
        state.add(AttributeEnum.OUTSIDE_US, true, true, true, false);
        state.add(AttributeEnum.OUTSIDE_US, true, false, true, false); // 75,25

        assertEquals(0, state.getNEUSPercentHeard());
        assertEquals(0, state.getNEUSPercentLiked());
        assertEquals(100, state.getSEUSPercentHeard());
        assertEquals(50, state.getSEUSPercentLiked());
        assertEquals(33, state.getOtherUSPercentHeard());
        assertEquals(66, state.getOtherUSPercentLiked());
        assertEquals(75, state.getOutsideUSPercentHeard());
        assertEquals(25, state.getOutsideUSPercentLiked());
    }
}
