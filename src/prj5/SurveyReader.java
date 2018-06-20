package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class takes in the glyphList from the songReader and sets each 
 * glyph's attributes based on the MusicSurveyData file. 
 * @author jaredblumen
 * @version 2018 April 8
 */
public class SurveyReader implements Iterator<String>
{
    private GlyphLinkedList glyphList;
    
    private Scanner scanner;  
    
    /**
     * Instantiates the scanner and glyphList fields. Runs through the glyphList and edits
     * each glyph's attributes based on the survey data. 
     * @param glyphList list of glyphs to analyze
     * @throws FileNotFoundException
     */
    public SurveyReader(String fileString, GlyphLinkedList glyphList) 
    {
        // Instantiates the glyphList object
        this.glyphList = glyphList;
        
        // Opens the survey data file to scanner 
        try {
            scanner = new Scanner(new File(fileString));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // Takes in the first line which is not needed in the following while loop
        scanner.nextLine();
       
        // Runs through every line of the file
        while (scanner.hasNextLine())
        {
            // Reperesents an array of one line in the file
            String[] line = scanner.nextLine().split(",");
            
            // true if survey is valid meaning
            // the data can be included
            boolean validSurvey = true;
            
            // The survey line is not valid if 
            // the line is less than 5 meaning none
            // of the questions are answered
            if (line.length < 5)
            {
                validSurvey = false;
            }
            
            // These string are the survey's answer 
            // to major, state, and hobby
            String majorAnswer = "";
            String stateAnswer = "";
            String hobbyAnswer = "";
            
            // survey is not valid if any of the major, state, or hobby
            // questions are left blank
            if (validSurvey)
            {
                majorAnswer = line[2];
                stateAnswer = line[3];
                hobbyAnswer = line[4];
                if (majorAnswer.equals("") || stateAnswer.equals("") || hobbyAnswer.equals(""))
                {
                    validSurvey = false;
                }
            }
            
            // Checks to make sure survey is valid
            if (validSurvey)
            {
                // Runs through the glyph list and increments the surveyIndex by two since there
                // are 2 survey questions (heard and liked) per glyph (song) which starts at index = 5;
                for (int glyphIndex = 0, surveyIndex = 5; glyphIndex < glyphList.size(); glyphIndex++, surveyIndex += 2)
                {
                    // Gets the glyph at the specified index
                    Glyph glyph = glyphList.get(glyphIndex);
                    
                    // These represent the answers for the heard and liked questions
                    // for this glyph
                    String heardAnswer = "";
                    String likedAnswer = "";
                    
                    // Checks to make sure the line is long enough as 
                    // some lines can be empty and not go to the end
                    if (surveyIndex < line.length)
                    {
                        heardAnswer = line[surveyIndex];
                    }
                    if (surveyIndex + 1 < line.length)
                    {
                        likedAnswer = line[surveyIndex + 1];
                    }
                    
                    // These booleans are true if the question has a no or yes
                    boolean heardAnswered = false;
                    boolean likedAnswered = false;
                    
                    if (!heardAnswer.equals(""))
                    {
                        heardAnswered = true;
                    }
                    if (!likedAnswer.equals(""))
                    {
                        likedAnswered = true;
                    }
                    
                    // These booleans are true if the question is yes
                    // and false if the 
                    boolean heard = false;
                    boolean liked = false;
                    
                    if (heardAnswer.equals("Yes"))
                    {
                        heard = true;
                    }
                 
                    if (likedAnswer.equals("Yes"))
                    {
                        liked = true;
                    }
                   
                    // edits the glyphs major attribute based on their major answer and their 
                    // heard and liked booleans
                    switch(majorAnswer)
                    {
                        case "Computer Science" : { glyph.getMajor().add(AttributeEnum.CS, heardAnswered, heard, likedAnswered, liked); break; }
                        case "Math or CMDA" : { glyph.getMajor().add(AttributeEnum.MATH, heardAnswered, heard, likedAnswered, liked); break; }                
                        case "Other Engineering" : { glyph.getMajor().add(AttributeEnum.ENGINEERING, heardAnswered, heard, likedAnswered, liked); break; }                 
                        case "Other" : { glyph.getMajor().add(AttributeEnum.OTHER_MAJOR, heardAnswered, heard, likedAnswered, liked); break; }
                    }
                    
                    // edits the glyphs state attribute based on their state answer and their 
                    // heard and liked booleans
                    switch(stateAnswer)
                    {
                        case "Northeast" : { glyph.getState().add(AttributeEnum.NORTHEAST, heardAnswered, heard, likedAnswered, liked); break; }                         
                        case "Southeast" : { glyph.getState().add(AttributeEnum.SOUTHEAST, heardAnswered, heard, likedAnswered, liked); break; }                          
                        case "Outside of United States" : { glyph.getState().add(AttributeEnum.OUTSIDE_US, heardAnswered, heard, likedAnswered, liked); break; }                          
                        case "United States (other than Southeast or Northwest)" : { glyph.getState().add(AttributeEnum.OTHER_US, heardAnswered, heard, likedAnswered, liked); break; }
                    }
                    
                    // edits the glyphs hobby attribute based on their hobby answer and their 
                    // heard and liked booleans
                    switch(hobbyAnswer)
                    {
                        case "sports" : { glyph.getHobby().add(AttributeEnum.SPORTS, heardAnswered, heard, likedAnswered, liked); break; }
                        case "music" : { glyph.getHobby().add(AttributeEnum.MUSIC, heardAnswered, heard, likedAnswered, liked); break; }                          
                        case "reading" : { glyph.getHobby().add(AttributeEnum.READ, heardAnswered, heard, likedAnswered, liked); break; }                         
                        case "art" : { glyph.getHobby().add(AttributeEnum.ART, heardAnswered, heard, likedAnswered, liked); break; }
                    }
                                   
                }
            }
            
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
    public String nextLine() {
        return scanner.nextLine();
    }
}
