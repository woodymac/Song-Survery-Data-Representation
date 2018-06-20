package prj5;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Woody McIlhenny (woodymac)

/**
* Tests the methods of the Attribute Type class
* 
* @author Woody McIlhenny
* @version 2018.04.09
*/
public class AttributeTypeTest extends student.TestCase{
    
    /**
     * Initializes variables.
     */
    public void setUp() {
        // Nothing to initialize
    }
    
    /**
     * Tests the add method.
     */
    public void testAdd() {
        AttributeType aType = new AttributeType();
        aType.add(AttributeEnum.ART, false, false, false, false);
        assertEquals(AttributeType.class, aType.getClass());
    }
}
