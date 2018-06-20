package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Tests the methods of the Glyph class.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class GlyphTest extends student.TestCase {

    private Glyph glyph;


    /**
     * Initializes fields.
     */
    public void setUp() {
        glyph = new Glyph();
        glyph.setTitle("Pepper");
        glyph.setArtist("Butthole Surfers");
        glyph.setGenre("Alternative Rock");
        glyph.setYear(1996);
    }


    /**
     * Tests the getters for the attribute types.
     */
    public void testGetAttributeTypes() {
        assertEquals(Major.class, glyph.getMajor().getClass());
        assertEquals(Hobby.class, glyph.getHobby().getClass());
        assertEquals(State.class, glyph.getState().getClass());
    }
    
    
    /**
     * Tests the getters for the song information.
     */
    public void testGetSongInfo() {
        assertTrue(glyph.getTitle().equals("Pepper"));
        assertTrue(glyph.getArtist().equals("Butthole Surfers"));
        assertTrue(glyph.getGenre().equals("Alternative Rock"));
        assertEquals(1996, glyph.getYear());
    }


    /**
     * Tests the toString method
     */
    public void testToString() {
        assertTrue(glyph.toString(new Major()).equals("Song Title: Pepper"
            + "\nSong Artist: Butthole Surfers\nSong Genre: Alternative Rock"
            + "\nSong Year: 1996\nHeard\nComputer Science:0 Math/CMDA:0"
            + " Engineering:0 other:0\nLikes\nComputer Science:0"
            + " Math/CMDA:0 Engineering:0 other:0\n"));

        assertTrue(glyph.toString(new Hobby()).equals("Song Title: Pepper"
            + "\nSong Artist: Butthole Surfers\nSong Genre: Alternative Rock"
            + "\nSong Year: 1996\nHeard\nreading:0 art:0 sports:0 music:0"
            + "\nLikes\nreading:0 art:0 sports:0 music:0\n"));

        assertTrue(glyph.toString(new State()).equals("Song Title: Pepper"
            + "\nSong Artist: Butthole Surfers\nSong Genre: Alternative Rock"
            + "\nSong Year: 1996\nHeard\nNortheast US:0 Southeast US:0 Other "
            + "US:0 Outside US:0\nLikes\nNortheast US:0 Southeast US:0 Other "
            + "US:0 Outside US:0\n"));
    }
}
