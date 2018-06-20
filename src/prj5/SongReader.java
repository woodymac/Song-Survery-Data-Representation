package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class reads a SongList file and creates and returns
 * a GlyphLinkedList that has a glyph for every song in the file
 * @author jaredblumen
 * @version 2018 April 9
 */
public class SongReader implements Iterator<String>
{
    private Scanner scanner;
    private GlyphLinkedList glyphList;
    /**
     * Constructor. Conducts the scanning of the file and creates
     * and adds to the glyphList object. 
     * @param fileString String of SongList file
     * @throws FileNotFoundException throws if file is not found
     */
    public SongReader(String fileString) throws FileNotFoundException
    {
        // Scanner object to read through file
        scanner = new Scanner(new File(fileString));
        
        // This list will take in the songs from the file
        glyphList = new GlyphLinkedList();
        
        // This takes out the first line of the file which is 
        // not nessecary for the following while loop
        scanner.nextLine();
        
        // Runs while the Song List file has another line
        while (this.hasNextLine())
        {
            // Puts the nextLine in an array
            String[] line = new String[4];
            line = scanner.nextLine().split(",");
            
            // Takes the values needed for a glyph object
            String title = line[0];
            String artist = line[1];
            String year = line[2];
            String genre = line[3];

            // Creates the glyph and adds the values
            Glyph glyph = new Glyph();
            glyph.setArtist(artist);
            glyph.setTitle(title);
            glyph.setYear(Integer.parseInt(year));
            glyph.setGenre(genre);
            
            // adds glyph to list
            glyphList.add(glyph);
        }
    }
    
    /**
     * Boolean to see if iterator has a next string
     * @boolean true if scanner has a next string
     */
    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }
    
    /**
     * This returns the next string in the list
     * @return scanner's next string
     */
    @Override
    public String next() {
        return scanner.next();
    }
    
    /**
     * Boolean to see if iterator has a next line
     * @boolean true if scanner has a next line
     */
    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
    
    /**
     * This returns the next line in the list
     * @return scanner's next line
     */
    @Override
    public String nextLine()
    {
        return scanner.nextLine();
    }
    
   /**
    * This returns the glyphList that was created so it can 
    * be used outside
    * @return glyphList
    */
   public GlyphLinkedList getGlyphList()
   {
       return glyphList;
   }
    
}
