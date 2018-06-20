package prj5;

import java.io.FileNotFoundException;
import student.TestCase;
/**
 * This class tests the SongReader class
 * @author jaredblumen
 * @version 2018 April 9
 */
public class SongReaderTest extends TestCase
{
    private SongReader songReader;
    /**
     * Constructor for test class is empty
     */
    public SongReaderTest()
    {
        // empty
    }
    /**
     * This sets up every test method, executing before 
     * each method
     */
    public void setUp() throws FileNotFoundException
    {
        songReader = new SongReader("SongListTest1.csv");
    }
    /**
     * This tests the size of the GlyphLinkedList that is 
     * returned from songReader and tests the title and order of every 
     * glyph object in the list.
     */
    public void testSongReader()
    {
        GlyphLinkedList gll = songReader.getGlyphList();
        assertEquals(5, gll.size());
        assertEquals("All These Things I've Done", gll.get(0).getTitle());
        assertEquals("All You Need Is Love", gll.get(1).getTitle());
        assertEquals("American Pie", gll.get(2).getTitle());
        assertEquals("Anarchy in the UK", gll.get(3).getTitle());
        assertEquals("Another One Bites the Dust", gll.get(4).getTitle());
    }
}
