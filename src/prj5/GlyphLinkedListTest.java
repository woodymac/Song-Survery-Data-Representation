package prj5;

import student.TestCase;

/**
 * 
 * Tests the methods of the GlyphLinkedList class besides the toArray methods.
 * 
 * @author Jonathan Tiernan (jtiernan)
 * 
 * 
 * @version 03/21/2018
 *
 */
public class GlyphLinkedListTest extends TestCase {

    private GlyphLinkedList emptyList;
    private GlyphLinkedList oneEntryList;
    private GlyphLinkedList multiEntryList;
    private Glyph nullObject;
    private Glyph glyph1;
    private Glyph glyph2;
    private Glyph glyph3;
    private Glyph glyph4;
    private Hobby hobby;


    /**
     * Creates three lists and glyph objects for use in test methods
     */
    public void setUp() {
        emptyList = new GlyphLinkedList();
        oneEntryList = new GlyphLinkedList();
        multiEntryList = new GlyphLinkedList();
        nullObject = null;
        glyph1 = new Glyph();
        glyph2 = new Glyph();
        glyph3 = new Glyph();
        glyph4 = new Glyph();
        glyph1.setTitle("DSong");
        glyph2.setTitle("CSong");
        glyph3.setTitle("BSong");
        glyph4.setTitle("ASong");
        glyph1.setArtist("DArtist");
        glyph2.setArtist("CArtist");
        glyph3.setArtist("BArtist");
        glyph4.setArtist("AArtist");
        glyph1.setGenre("DGenre");
        glyph2.setGenre("CGenre");
        glyph3.setGenre("BGenre");
        glyph4.setGenre("AGenre");
        glyph1.setYear(4);
        glyph2.setYear(3);
        glyph3.setYear(2);
        glyph4.setYear(1);

        oneEntryList.add(glyph1);

        multiEntryList.add(glyph1);
        multiEntryList.add(glyph2);
        multiEntryList.add(glyph3);
        multiEntryList.add(glyph4);

        hobby = new Hobby();

    }


    /**
     * Tests the size() method of the GlyphLinkedList class
     */
    public void testSize() {
        assertEquals(emptyList.size(), 0);
        assertEquals(oneEntryList.size(), 1);
        assertEquals(multiEntryList.size(), 4);
    }


    /**
     * Tests the isEmpty() method of the GlyphLinkedList class
     */
    public void testIsEmpty() {
        assertEquals(emptyList.isEmpty(), true);
        assertEquals(oneEntryList.isEmpty(), false);
        assertEquals(multiEntryList.isEmpty(), false);
    }


    /**
     * Tests both add() methods of the GlyphLinkedList class
     */
    public void testAdd() {
        oneEntryList.add(glyph1);
        assertEquals(oneEntryList.get(0), glyph1);
        assertEquals(oneEntryList.get(1), glyph1);
        multiEntryList.add(glyph1);
        assertEquals(multiEntryList.get(4), glyph1);
        emptyList.add(0, glyph1);
        assertEquals(emptyList.get(0), glyph1);
        emptyList.add(0, glyph2);
        assertEquals(emptyList.get(0), glyph2);

        Exception exception = null;
        try {
            emptyList.add(nullObject);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IllegalArgumentException);
        }

        oneEntryList.remove(1);
        oneEntryList.add(1, glyph2);
        assertEquals(oneEntryList.get(1), glyph2);
        multiEntryList.add(2, glyph1);
        assertEquals(multiEntryList.get(2), glyph1);

        try {
            emptyList.add(10, glyph1);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }

        try {
            oneEntryList.add(0, null);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IllegalArgumentException);
        }

        try {
            emptyList.add(-5, new Glyph());
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }

    }


    /**
     * Tests both remove() methods of the GlyphLinkedList class
     */
    public void testRemove() {
        assertEquals(oneEntryList.remove(glyph1), true);
        assertEquals(oneEntryList.remove(glyph4), false);
        assertEquals(multiEntryList.remove(glyph3), true);
        assertEquals(multiEntryList.remove(glyph3), false);

        Exception exception = null;
        try {
            multiEntryList.remove(100);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }
        try {
            emptyList.remove(0);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }
        try {
            oneEntryList.remove(-1);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }
        try {
            oneEntryList.remove(glyph4);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        oneEntryList.add(glyph1);
        assertEquals(oneEntryList.remove(0), true);
        multiEntryList.add(glyph2);
        assertEquals(multiEntryList.remove(2), true);
        multiEntryList.add(glyph4);
        multiEntryList.add(glyph4);
        multiEntryList.add(glyph4);
        multiEntryList.add(glyph4);
        assertEquals(multiEntryList.remove(1), true);
        assertEquals(multiEntryList.remove(multiEntryList.size() - 3), true);
        assertEquals(multiEntryList.remove(multiEntryList.size() - 1), true);
    }


    /**
     * Tests the get() method of the GlyphLinkedList class
     */
    public void testGet() {
        Exception exception = null;
        try {
            oneEntryList.get(100);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }
        try {
            emptyList.get(0);
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }

        assertEquals(oneEntryList.get(0), glyph1);
        assertEquals(multiEntryList.get(1), glyph2);
    }


    /**
     * Tests the contains() method of the GlyphLinkedList class
     */
    public void testContains() {
        assertEquals(emptyList.contains(glyph1), false);
        assertEquals(oneEntryList.contains(glyph1), true);
        assertEquals(multiEntryList.contains(glyph3), true);
    }


    /**
     * Tests the clear() method of the GlyphLinkedList class
     */
    public void testClear() {
        oneEntryList.clear();
        assertEquals(oneEntryList.size(), 0);
        assertEquals(multiEntryList.size(), 4);
        multiEntryList.clear();
        assertEquals(multiEntryList.size(), 0);
        Exception exception = null;
        try {
            emptyList.clear();
        }
        catch (Exception e) {
            exception = e;
            assertTrue(exception instanceof IndexOutOfBoundsException);
        }
    }


    /**
     * Tests the lastIndexOf() method of the GlyphLinkedList class
     */
    public void testLastIndexOf() {
        multiEntryList.add(glyph1);
        assertEquals(oneEntryList.lastIndexOf(glyph3), -1);
        assertEquals(oneEntryList.lastIndexOf(glyph1), 0);
        assertEquals(multiEntryList.lastIndexOf(glyph4), 3);
    }


    /**
     * Tests the toString() method of the GlyphLinkedList class
     */
    public void testToString() {
        assertEquals(emptyList.toString(hobby), "");
        assertEquals(oneEntryList.toString(hobby), "Song Title: DSong" + '\n'
            + "Song Artist: DArtist" + '\n' + "Song Genre: DGenre" + '\n'
            + "Song Year: 4" + '\n' + "Heard" + '\n'
            + "reading:0 art:0 sports:0 music:0" + '\n' + "Likes" + '\n'
            + "reading:0 art:0 sports:0 music:0\n");
        assertEquals(multiEntryList.toString(hobby), "Song Title: DSong" + '\n'
            + "Song Artist: DArtist" + '\n' + "Song Genre: DGenre" + '\n'
            + "Song Year: 4" + '\n' + "Heard" + '\n'
            + "reading:0 art:0 sports:0 music:0" + '\n' + "Likes" + '\n'
            + "reading:0 art:0 sports:0 music:0" + '\n' + '\n'
            + "Song Title: CSong" + '\n' + "Song Artist: CArtist" + '\n'
            + "Song Genre: CGenre" + '\n' + "Song Year: 3" + '\n' + "Heard"
            + '\n' + "reading:0 art:0 sports:0 music:0" + '\n' + "Likes" + '\n'
            + "reading:0 art:0 sports:0 music:0" + '\n' + '\n'
            + "Song Title: BSong" + '\n' + "Song Artist: BArtist" + '\n'
            + "Song Genre: BGenre" + '\n' + "Song Year: 2" + '\n' + "Heard"
            + '\n' + "reading:0 art:0 sports:0 music:0" + '\n' + "Likes" + '\n'
            + "reading:0 art:0 sports:0 music:0" + '\n' + '\n'
            + "Song Title: ASong" + '\n' + "Song Artist: AArtist" + '\n'
            + "Song Genre: AGenre" + '\n' + "Song Year: 1" + '\n' + "Heard"
            + '\n' + "reading:0 art:0 sports:0 music:0" + '\n' + "Likes" + '\n'
            + "reading:0 art:0 sports:0 music:0\n");
    }


    /**
     * Tests the sortArtist() method of the GlyphLinkedList class
     */
    public void testSortArtist() {
        oneEntryList.clear();
        multiEntryList.clear();
        oneEntryList.add(glyph2);
        oneEntryList.sortArtist();
        assertEquals(oneEntryList.get(0), glyph2);
        multiEntryList.add(glyph1);
        multiEntryList.add(glyph2);
        multiEntryList.add(glyph3);
        multiEntryList.add(glyph4);
        multiEntryList.sortArtist();
        assertEquals(multiEntryList.get(0), glyph4);
        assertEquals(multiEntryList.get(1), glyph3);
        assertEquals(multiEntryList.get(2), glyph2);
        assertEquals(multiEntryList.get(3), glyph1);
    }


    /**
     * Tests the sortGenre() method of the GlyphLinkedList class
     */
    public void testSortGenre() {
        oneEntryList.clear();
        multiEntryList.clear();
        oneEntryList.add(glyph1);
        oneEntryList.sortArtist();
        assertEquals(oneEntryList.get(0), glyph1);
        multiEntryList.add(glyph1);
        multiEntryList.add(glyph2);
        multiEntryList.add(glyph3);
        multiEntryList.add(glyph4);
        multiEntryList.sortArtist();
        assertEquals(multiEntryList.get(0), glyph4);
        assertEquals(multiEntryList.get(1), glyph3);
        assertEquals(multiEntryList.get(2), glyph2);
        assertEquals(multiEntryList.get(3), glyph1);
    }


    /**
     * Tests the sortYear() method of the GlyphLinkedList class
     */
    public void testSortYear() {
        oneEntryList.clear();
        multiEntryList.clear();
        oneEntryList.add(glyph1);
        oneEntryList.sortArtist();
        assertEquals(oneEntryList.get(0), glyph1);
        multiEntryList.add(glyph1);
        multiEntryList.add(glyph2);
        multiEntryList.add(glyph3);
        multiEntryList.add(glyph4);
        multiEntryList.sortArtist();
        assertEquals(multiEntryList.get(0), glyph4);
        assertEquals(multiEntryList.get(1), glyph3);
        assertEquals(multiEntryList.get(2), glyph2);
        assertEquals(multiEntryList.get(3), glyph1);
    }


    /**
     * Tests the sortTitle() method of the GlyphLinkedList class
     */
    public void testSortTitle() {
        oneEntryList.clear();
        multiEntryList.clear();
        oneEntryList.add(glyph1);
        oneEntryList.sortArtist();
        assertEquals(oneEntryList.get(0), glyph1);
        multiEntryList.add(glyph1);
        multiEntryList.add(glyph2);
        multiEntryList.add(glyph3);
        multiEntryList.add(glyph4);
        multiEntryList.sortArtist();
        assertEquals(multiEntryList.get(0), glyph4);
        assertEquals(multiEntryList.get(1), glyph3);
        assertEquals(multiEntryList.get(2), glyph2);
        assertEquals(multiEntryList.get(3), glyph1);
    }
}
