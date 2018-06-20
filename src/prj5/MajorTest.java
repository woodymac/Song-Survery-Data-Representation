package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Tests the methods of the Major class.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class MajorTest extends student.TestCase {

    private Major major;


    /**
     * Initializes variables.
     */
    public void setUp() {
        major = new Major();
    }


    /**
     * Tests the add method.
     */
    public void testAdd() {
        // Should not change any fields
        // major.add(AttributeEnum.READ, true, true);
        // assertEquals(0, major.getOtherTotal());

        // Questions were unanswered, total is not updated
        major.add(AttributeEnum.CS, false, true, false, true);
        assertEquals(0, major.getCSTotalHeard());
        assertEquals(0, major.getCSTotalLiked());

        major.add(AttributeEnum.CS, true, true, true, false);
        major.add(AttributeEnum.CS, true, true, true, false);
        major.add(AttributeEnum.CS, true, true, true, false);
        major.add(AttributeEnum.CS, true, false, true, true);
        major.add(AttributeEnum.CS, true, false, true, true);
        assertEquals(5, major.getCSTotalHeard());
        assertEquals(5, major.getCSTotalLiked());
        assertEquals(3, major.getCSHeard());
        assertEquals(2, major.getCSLiked());

        // Questions were unanswered, total is not updated
        major.add(AttributeEnum.MATH, false, true, false, true);
        assertEquals(0, major.getMathTotalHeard());
        assertEquals(0, major.getMathTotalLiked());

        major.add(AttributeEnum.MATH, true, true, true, false);
        major.add(AttributeEnum.MATH, true, true, true, false);
        major.add(AttributeEnum.MATH, true, true, true, false);
        major.add(AttributeEnum.MATH, true, false, true, true);
        major.add(AttributeEnum.MATH, true, false, true, true);
        assertEquals(5, major.getMathTotalHeard());
        assertEquals(5, major.getMathTotalHeard());
        assertEquals(3, major.getMathHeard());
        assertEquals(2, major.getMathLiked());

        // Questions were unanswered, total is not updated
        major.add(AttributeEnum.ENGINEERING, false, true, false, true);
        assertEquals(0, major.getEngineeringTotalHeard());
        assertEquals(0, major.getEngineeringTotalLiked());

        major.add(AttributeEnum.ENGINEERING, true, true, true, false);
        major.add(AttributeEnum.ENGINEERING, true, true, true, false);
        major.add(AttributeEnum.ENGINEERING, true, true, true, false);
        major.add(AttributeEnum.ENGINEERING, true, false, true, true);
        major.add(AttributeEnum.ENGINEERING, true, false, true, true);
        assertEquals(5, major.getEngineeringTotalHeard());
        assertEquals(5, major.getEngineeringTotalLiked());
        assertEquals(3, major.getEngineeringHeard());
        assertEquals(2, major.getEngineeringLiked());

        // Questions were unanswered, total is not updated
        major.add(AttributeEnum.OTHER_MAJOR, false, true, false, true);
        assertEquals(0, major.getOtherTotalHeard());
        assertEquals(0, major.getOtherTotalLiked());

        major.add(AttributeEnum.OTHER_MAJOR, true, true, true, false);
        major.add(AttributeEnum.OTHER_MAJOR, true, true, true, false);
        major.add(AttributeEnum.OTHER_MAJOR, true, true, true, false);
        major.add(AttributeEnum.OTHER_MAJOR, true, false, true, true);
        major.add(AttributeEnum.OTHER_MAJOR, true, false, true, true);
        assertEquals(5, major.getOtherTotalHeard());
        assertEquals(5, major.getOtherTotalLiked());
        assertEquals(3, major.getOtherHeard());
        assertEquals(2, major.getOtherLiked());
    }


    /**
     * Tests the percentage getter methods.
     */
    public void testGetPercentage() {
        // add has not been called, so all should return 0
        assertEquals(0, major.getCSPercentHeard());
        assertEquals(0, major.getCSPercentLiked());
        assertEquals(0, major.getMathPercentHeard());
        assertEquals(0, major.getMathPercentLiked());
        assertEquals(0, major.getEngineeringPercentHeard());
        assertEquals(0, major.getEngineeringPercentLiked());
        assertEquals(0, major.getOtherPercentHeard());
        assertEquals(0, major.getOtherPercentLiked());

        major.add(AttributeEnum.CS, true, false, true, false); // 0,0
        major.add(AttributeEnum.MATH, true, true, true, false);
        major.add(AttributeEnum.MATH, true, true, true, true); // 100,50
        major.add(AttributeEnum.ENGINEERING, true, true, true, true);
        major.add(AttributeEnum.ENGINEERING, true, false, true, true);
        major.add(AttributeEnum.ENGINEERING, true, false, true, false); // 33,66
        major.add(AttributeEnum.OTHER_MAJOR, true, true, true, true);
        major.add(AttributeEnum.OTHER_MAJOR, true, true, true, false);
        major.add(AttributeEnum.OTHER_MAJOR, true, true, true, false);
        major.add(AttributeEnum.OTHER_MAJOR, true, false, true, false); // 75,25

        assertEquals(0, major.getCSPercentHeard());
        assertEquals(0, major.getCSPercentLiked());
        assertEquals(100, major.getMathPercentHeard());
        assertEquals(50, major.getMathPercentLiked());
        assertEquals(33, major.getEngineeringPercentHeard());
        assertEquals(66, major.getEngineeringPercentLiked());
        assertEquals(75, major.getOtherPercentHeard());
        assertEquals(25, major.getOtherPercentLiked());
    }
}
