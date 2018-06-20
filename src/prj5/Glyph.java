package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * The Song class represents a single song. The fields hold data representing
 * the song title, artist, genre, and year.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class Glyph {

    private String title;
    private String artist;
    private String genre;
    private int year;
    private Major major;
    private Hobby hobby;
    private State state;


    /**
     * Creates a new Song Object.
     */
    public Glyph() {
        major = new Major();
        hobby = new Hobby();
        state = new State();
    }


    /**
     * Returns the major object associated with the song. This stores the data
     * for number of heard and liked.
     * 
     * @return The major object associated with the song.
     */
    public Major getMajor() {
        return major;
    }


    /**
     * Returns the hobby object associated with the song. This stores the data
     * for number of heard and liked.
     * 
     * @return The hobby object associated with the song.
     */
    public Hobby getHobby() {
        return hobby;
    }


    /**
     * Returns the state object associated with the song. This stores the data
     * for number of heard and liked.
     * 
     * @return The state object associated with the song.
     */
    public State getState() {
        return state;
    }


    /**
     * Returns the song's title.
     * 
     * @return The song's title.
     */
    public String getTitle() {
        return title;
    }


    /**
     * Returns the song's artist.
     * 
     * @return The song's artist.
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Returns the song's genre.
     * 
     * @return The song's genre.
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Returns the song's year.
     * 
     * @return The song's year.
     */
    public int getYear() {
        return year;
    }


    /**
     * Sets the song's title to the specified value.
     * 
     * @param t
     *            The desired title.
     */
    public void setTitle(String t) {
        title = t;
    }


    /**
     * Sets the song's artist to the specified value.
     * 
     * @param a
     *            The desired artist.
     */
    public void setArtist(String a) {
        artist = a;
    }


    /**
     * Sets the song's genre to the specified value.
     * 
     * @param g
     *            The desired genre.
     */
    public void setGenre(String g) {
        genre = g;
    }


    /**
     * Sets the song's year to the specified value.
     * 
     * @param y
     *            The desired year.
     */
    public void setYear(int y) {
        year = y;
    }


    /**
     * Returns a string containing the data of this Glyph.
     * 
     * @param aType
     *            The attribute type the string will display data for.
     * 
     * @return A string containing the data of this Glyph.
     */
    public String toString(AttributeType aType) {
        if (aType.getClass() == Major.class) {
            return ("Song Title: " + title + "\nSong Artist: " + artist
                + "\nSong Genre: " + genre + "\nSong Year: " + year
                + "\nHeard\nComputer Science:" + major.getCSPercentHeard()
                + " Math/CMDA:" + major.getMathPercentHeard() + " Engineering:"
                + major.getEngineeringPercentHeard() + " other:" + major
                    .getOtherPercentHeard() + "\nLikes\nComputer Science:"
                + major.getCSPercentLiked() + " Math/CMDA:" + major
                    .getMathPercentLiked() + " Engineering:" + major
                        .getEngineeringPercentLiked() + " other:" + major
                            .getOtherPercentLiked() + "\n");
        }
        else if (aType.getClass() == Hobby.class) {
            return ("Song Title: " + title + "\nSong Artist: " + artist
                + "\nSong Genre: " + genre + "\nSong Year: " + year
                + "\nHeard\nreading:" + hobby.getReadPercentHeard() + " art:"
                + hobby.getArtPercentHeard() + " sports:" + hobby
                    .getSportsPercentHeard() + " music:" + hobby
                        .getMusicPercentHeard() + "\nLikes\nreading:" + hobby
                            .getReadPercentLiked() + " art:" + hobby
                                .getArtPercentLiked() + " sports:" + hobby
                                    .getSportsPercentLiked() + " music:" + hobby
                                        .getMusicPercentLiked() + "\n");
        }
        else {
            return ("Song Title: " + title + "\nSong Artist: " + artist
                + "\nSong Genre: " + genre + "\nSong Year: " + year
                + "\nHeard\nNortheast US:" + state.getNEUSPercentHeard()
                + " Southeast US:" + state.getSEUSPercentHeard() + " Other US:"
                + state.getOtherUSPercentHeard() + " Outside US:" + state
                    .getOutsideUSPercentHeard() + "\nLikes\nNortheast US:"
                + state.getNEUSPercentLiked() + " Southeast US:" + state
                    .getSEUSPercentLiked() + " Other US:" + state
                        .getOtherUSPercentLiked() + " Outside US:" + state
                            .getOutsideUSPercentLiked() + "\n");
        }

    }
}

