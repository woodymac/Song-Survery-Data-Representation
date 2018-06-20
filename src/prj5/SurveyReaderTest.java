package prj5;

import java.io.FileNotFoundException;
import student.TestCase;
/**
 * 
 * @author jaredblumen
 * @version 2018 April 9
 */
public class SurveyReaderTest extends TestCase 
{
    private SongReader songReader;
    private GlyphLinkedList gll;
    private SurveyReader surveyReader;
    /**
     * Constructor for test class is empty
     */
    public SurveyReaderTest()
    {
        // empty
    }
    /**
     * This method executes before every test method. 
     */
    public void setUp() throws FileNotFoundException
    {
        songReader = new SongReader("SongListTest1.csv");
        gll = songReader.getGlyphList();
        surveyReader = new SurveyReader("MusicSurveyDataTest1.csv", gll);
    }
    /**
     * This tests the large file assuring the list size is correct and 
     * that no exceptions are thrown
     * @throws FileNotFoundException
     */
    public void testSurveyReaderLarge() throws FileNotFoundException
    {
        songReader = new SongReader("SongList.csv");
        gll = songReader.getGlyphList();
        surveyReader = new SurveyReader("MusicSurveyData.csv", gll);
        assertEquals(59,  gll.size());  
    }
    /**
     * This tests the small file, asserting the Hobby object at
     * index = 0 is correct
     * 
     */
    public void testSurveyReaderSmallHobby()
    {
        assertEquals(1, gll.get(1).getHobby().getReadHeard());
        assertEquals(1, gll.get(1).getHobby().getReadLiked());
        assertEquals(1, gll.get(1).getHobby().getReadTotalHeard());
        assertEquals(1, gll.get(1).getHobby().getReadTotalLiked());
        assertEquals(0, gll.get(1).getHobby().getArtHeard());
        assertEquals(0, gll.get(1).getHobby().getArtLiked());
        assertEquals(0, gll.get(1).getHobby().getArtTotalHeard());
        assertEquals(0, gll.get(1).getHobby().getArtTotalLiked());
        assertEquals(4, gll.get(1).getHobby().getSportsHeard());
        assertEquals(1, gll.get(1).getHobby().getSportsLiked());
        assertEquals(4, gll.get(1).getHobby().getSportsTotalHeard());
        assertEquals(2, gll.get(1).getHobby().getSportsTotalLiked());
        assertEquals(0, gll.get(1).getHobby().getMusicHeard());
        assertEquals(1, gll.get(1).getHobby().getMusicLiked());
        assertEquals(1, gll.get(1).getHobby().getMusicTotalHeard());
        assertEquals(1, gll.get(1).getHobby().getMusicTotalLiked());
    }
    /**
     * This tests the small file, asserting the Major object at
     * index = 0 is correct
     * 
     */
    public void testSurveyReaderSmallMajor()
    {
        assertEquals(2, gll.get(1).getMajor().getCSHeard());
        assertEquals(2, gll.get(1).getMajor().getCSLiked());
        assertEquals(3, gll.get(1).getMajor().getCSTotalHeard());
        assertEquals(2, gll.get(1).getMajor().getCSTotalLiked());
        assertEquals(3, gll.get(1).getMajor().getMathHeard());
        assertEquals(1, gll.get(1).getMajor().getMathLiked());
        assertEquals(3, gll.get(1).getMajor().getMathTotalHeard());
        assertEquals(2, gll.get(1).getMajor().getMathTotalLiked());
        assertEquals(0, gll.get(1).getMajor().getEngineeringHeard());
        assertEquals(0, gll.get(1).getMajor().getEngineeringLiked());
        assertEquals(0, gll.get(1).getMajor().getEngineeringTotalHeard());
        assertEquals(0, gll.get(1).getMajor().getEngineeringTotalLiked());
        assertEquals(0, gll.get(1).getMajor().getOtherHeard());
        assertEquals(0, gll.get(1).getMajor().getOtherLiked());
        assertEquals(0, gll.get(1).getMajor().getOtherTotalHeard());
        assertEquals(0, gll.get(1).getMajor().getOtherTotalLiked());
        
    }
    /**
     * This tests the small file, asserting the State object at
     * index = 0 is correct
     * 
     */
    public void testSurveyReaderSmallState()
    {
        assertEquals(0, gll.get(1).getState().getNEUSHeard());
        assertEquals(0, gll.get(1).getState().getNEUSLiked());
        assertEquals(0, gll.get(1).getState().getNEUSTotalHeard());
        assertEquals(0, gll.get(1).getState().getNEUSTotalLiked());
        assertEquals(5, gll.get(1).getState().getSEUSHeard());
        assertEquals(3, gll.get(1).getState().getSEUSLiked());
        assertEquals(6, gll.get(1).getState().getSEUSTotalHeard());
        assertEquals(4, gll.get(1).getState().getSEUSTotalLiked());
        assertEquals(0, gll.get(1).getState().getOtherUSHeard());
        assertEquals(0, gll.get(1).getState().getOtherUSLiked());
        assertEquals(0, gll.get(1).getState().getOtherUSTotalHeard());
        assertEquals(0, gll.get(1).getState().getOtherUSTotalLiked());
        assertEquals(0, gll.get(1).getState().getOutsideUSHeard());
        assertEquals(0, gll.get(1).getState().getOutsideUSLiked());
        assertEquals(0, gll.get(1).getState().getOutsideUSTotalHeard());
        assertEquals(0, gll.get(1).getState().getOutsideUSTotalLiked());
    }

}
