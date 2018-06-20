package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Tests the methods of the Hobby class.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class HobbyTest extends student.TestCase {

    private Hobby hobby;


    /**
     * Initializes variables.
     */
    public void setUp() {
        hobby = new Hobby();
    }


    /**
     * Tests the add method.
     */
    public void testAdd() {
        // Should not change any fields
        // hobby.add(AttributeEnum.READ, true, true);
        // assertEquals(0, hobby.getMusicTotal());

        // Questions were unanswered, total is not updated
        hobby.add(AttributeEnum.READ, false, true, false, true);
        assertEquals(0, hobby.getReadTotalHeard());
        assertEquals(0, hobby.getReadTotalLiked());

        hobby.add(AttributeEnum.READ, true, true, true, false);
        hobby.add(AttributeEnum.READ, true, true, true, false);
        hobby.add(AttributeEnum.READ, true, true, true, false);
        hobby.add(AttributeEnum.READ, true, false, true, true);
        hobby.add(AttributeEnum.READ, true, false, true, true);
        assertEquals(5, hobby.getReadTotalHeard());
        assertEquals(5, hobby.getReadTotalLiked());
        assertEquals(3, hobby.getReadHeard());
        assertEquals(2, hobby.getReadLiked());

        // Questions were unanswered, total is not updated
        hobby.add(AttributeEnum.SPORTS, false, true, false, true);
        assertEquals(0, hobby.getSportsTotalHeard());
        assertEquals(0, hobby.getSportsTotalLiked());

        hobby.add(AttributeEnum.SPORTS, true, true, true, false);
        hobby.add(AttributeEnum.SPORTS, true, true, true, false);
        hobby.add(AttributeEnum.SPORTS, true, true, true, false);
        hobby.add(AttributeEnum.SPORTS, true, false, true, true);
        hobby.add(AttributeEnum.SPORTS, true, false, true, true);
        assertEquals(5, hobby.getSportsTotalHeard());
        assertEquals(5, hobby.getSportsTotalLiked());
        assertEquals(3, hobby.getSportsHeard());
        assertEquals(2, hobby.getSportsLiked());

        // Questions were unanswered, total is not updated
        hobby.add(AttributeEnum.ART, false, true, false, true);
        assertEquals(0, hobby.getArtTotalHeard());
        assertEquals(0, hobby.getArtTotalLiked());

        hobby.add(AttributeEnum.ART, true, true, true, false);
        hobby.add(AttributeEnum.ART, true, true, true, false);
        hobby.add(AttributeEnum.ART, true, true, true, false);
        hobby.add(AttributeEnum.ART, true, false, true, true);
        hobby.add(AttributeEnum.ART, true, false, true, true);
        assertEquals(5, hobby.getArtTotalHeard());
        assertEquals(5, hobby.getArtTotalLiked());
        assertEquals(3, hobby.getArtHeard());
        assertEquals(2, hobby.getArtLiked());

        // Questions were unanswered, total is not updated
        hobby.add(AttributeEnum.MUSIC, false, true, false, true);
        assertEquals(0, hobby.getMusicTotalHeard());
        assertEquals(0, hobby.getMusicTotalLiked());

        hobby.add(AttributeEnum.MUSIC, true, true, true, false);
        hobby.add(AttributeEnum.MUSIC, true, true, true, false);
        hobby.add(AttributeEnum.MUSIC, true, true, true, false);
        hobby.add(AttributeEnum.MUSIC, true, false, true, true);
        hobby.add(AttributeEnum.MUSIC, true, false, true, true);
        assertEquals(5, hobby.getMusicTotalHeard());
        assertEquals(5, hobby.getMusicTotalHeard());
        assertEquals(3, hobby.getMusicHeard());
        assertEquals(2, hobby.getMusicLiked());
    }


    /**
     * Tests the percentage getter methods.
     */
    public void testGetPercentage() {
        // add has not been called, so all should return 0
        assertEquals(0, hobby.getReadPercentHeard());
        assertEquals(0, hobby.getReadPercentLiked());
        assertEquals(0, hobby.getSportsPercentHeard());
        assertEquals(0, hobby.getSportsPercentLiked());
        assertEquals(0, hobby.getArtPercentHeard());
        assertEquals(0, hobby.getArtPercentLiked());
        assertEquals(0, hobby.getMusicPercentHeard());
        assertEquals(0, hobby.getMusicPercentLiked());

        hobby.add(AttributeEnum.READ, true, false, true, false); // 0,0
        hobby.add(AttributeEnum.SPORTS, true, true, true, false);
        hobby.add(AttributeEnum.SPORTS, true, true, true, true); // 100,50
        hobby.add(AttributeEnum.ART, true, true, true, true);
        hobby.add(AttributeEnum.ART, true, false, true, true);
        hobby.add(AttributeEnum.ART, true, false, true, false); // 33,66
        hobby.add(AttributeEnum.MUSIC, true, true, true, true);
        hobby.add(AttributeEnum.MUSIC, true, true, true, false);
        hobby.add(AttributeEnum.MUSIC, true, true, true, false);
        hobby.add(AttributeEnum.MUSIC, true, false, true, false); // 75,25

        assertEquals(0, hobby.getReadPercentHeard());
        assertEquals(0, hobby.getReadPercentLiked());
        assertEquals(100, hobby.getSportsPercentHeard());
        assertEquals(50, hobby.getSportsPercentLiked());
        assertEquals(33, hobby.getArtPercentHeard());
        assertEquals(66, hobby.getArtPercentLiked());
        assertEquals(75, hobby.getMusicPercentHeard());
        assertEquals(25, hobby.getMusicPercentLiked());
    }
}
