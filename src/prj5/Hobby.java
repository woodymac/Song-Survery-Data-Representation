package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Represents the data related to each hobby for a particular song.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class Hobby extends AttributeType {

    private int readHeard;
    private int readLiked;
    private int readTotalHeard;
    private int readTotalLiked;

    private int sportsHeard;
    private int sportsLiked;
    private int sportsTotalHeard;
    private int sportsTotalLiked;

    private int artHeard;
    private int artLiked;
    private int artTotalHeard;
    private int artTotalLiked;

    private int musicHeard;
    private int musicLiked;
    private int musicTotalHeard;
    private int musicTotalLiked;


    /**
     * Creates a new Hobby object.
     */
    public Hobby() {
        readHeard = 0;
        readLiked = 0;
        readTotalHeard = 0;
        readTotalLiked = 0;

        sportsHeard = 0;
        sportsLiked = 0;
        sportsTotalHeard = 0;
        sportsTotalLiked = 0;

        artHeard = 0;
        artLiked = 0;
        artTotalHeard = 0;
        artTotalLiked = 0;

        musicHeard = 0;
        musicLiked = 0;
        musicTotalHeard = 0;
        musicTotalLiked = 0;
    }


    /**
     * Adds 1 to the specified attribute's total tally, and heard or liked
     * depending on the passed boolean values (Only if it is in the HOBBY group)
     * 
     * @param attr
     *            The attribute to have its data changed.
     * 
     * @param hAns
     *            Adds to the total heard if true, unchanged otherwise.
     * 
     * @param heard
     *            Adds to the heard tally if true. It is unchanged otherwise.
     * 
     * @param lAns
     *            Adds to the total liked if true, unchanged otherwise.
     * 
     * @param liked
     *            Adds to the liked tally if true. It is unchanged otherwise.
     */
    @Override
    public void add(
        AttributeEnum attr,
        boolean hAns,
        boolean heard,
        boolean lAns,
        boolean liked) {
        // if (attr.isInGroup(Group.HOBBY)) {
        switch (attr) {
            case READ: {
                if (hAns) {
                    readTotalHeard++;
                    if (heard) {
                        readHeard++;
                    }
                }
                if (lAns) {
                    readTotalLiked++;
                    if (liked) {
                        readLiked++;
                    }
                }
                break;
            }
            case SPORTS: {
                if (hAns) {
                    sportsTotalHeard++;
                    if (heard) {
                        sportsHeard++;
                    }
                }
                if (lAns) {
                    sportsTotalLiked++;
                    if (liked) {
                        sportsLiked++;
                    }
                }
                break;
            }
            case ART: {
                if (hAns) {
                    artTotalHeard++;
                    if (heard) {
                        artHeard++;
                    }
                }
                if (lAns) {
                    artTotalLiked++;
                    if (liked) {
                        artLiked++;
                    }
                }
                break;
            }
            default: {
                if (hAns) {
                    musicTotalHeard++;
                    if (heard) {
                        musicHeard++;
                    }
                }
                if (lAns) {
                    musicTotalLiked++;
                    if (liked) {
                        musicLiked++;
                    }
                }
                break;
            }
        }
        // }
    }


    /**
     * Returns the number people who read that heard the song.
     * 
     * @return The number people who read that heard the song.
     */
    public int getReadHeard() {
        return readHeard;
    }


    /**
     * Returns the number people who read that liked the song.
     * 
     * @return The number people who read that liked the song.
     */
    public int getReadLiked() {
        return readLiked;
    }


    /**
     * Returns the total number of people who read who responded to the heard
     * question.
     * 
     * @return The total number of people who read who responded to the heard
     *         question.
     */
    public int getReadTotalHeard() {
        return readTotalHeard;
    }


    /**
     * Returns the total number of people who read that responded to the like
     * question.
     * 
     * @return The total number of people who read that responded to the like
     *         question.
     */
    public int getReadTotalLiked() {
        return readTotalLiked;
    }


    /**
     * Returns the percentage of people who read heard the song.
     * 
     * @return The percentage of people who read that heard the song.
     */
    public int getReadPercentHeard() {
        if (readTotalHeard == 0) {
            return 0;
        }
        double percent = (double)readHeard / (double)readTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who read that liked the song.
     * 
     * @return The percentage of people who read that liked the song.
     */
    public int getReadPercentLiked() {
        if (readTotalLiked == 0) {
            return 0;
        }
        double percent = (double)readLiked / (double)readTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number people who play sports that heard the song.
     * 
     * @return The number people who play sports that heard the song.
     */
    public int getSportsHeard() {
        return sportsHeard;
    }


    /**
     * Returns the number people who play sports that like the song.
     * 
     * @return The number people who play sports that like the song.
     */
    public int getSportsLiked() {
        return sportsLiked;
    }


    /**
     * Returns the total number of people who sports who responded to the heard
     * question.
     * 
     * @return The total number of people who sports who responded to the heard
     *         question.
     */
    public int getSportsTotalHeard() {
        return sportsTotalHeard;
    }


    /**
     * Returns the total number of people who sports that responded to the like
     * question.
     * 
     * @return The total number of people who sports that responded to the like
     *         question.
     */
    public int getSportsTotalLiked() {
        return sportsTotalHeard;
    }


    /**
     * Returns the percentage of people who play sports heard the song.
     * 
     * @return The percentage of people who play sports that heard the song.
     */
    public int getSportsPercentHeard() {
        if (sportsTotalHeard == 0) {
            return 0;
        }
        double percent = (double)sportsHeard / (double)sportsTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who play sports that liked the song.
     * 
     * @return The percentage of people who play sports that liked the song.
     */
    public int getSportsPercentLiked() {
        if (sportsTotalLiked == 0) {
            return 0;
        }
        double percent = (double)sportsLiked / (double)sportsTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number people who do art that heard the song.
     * 
     * @return The number people who do art that heard the song.
     */
    public int getArtHeard() {
        return artHeard;
    }


    /**
     * Returns the number people who do art that liked the song.
     * 
     * @return The number people who do art that liked the song.
     */
    public int getArtLiked() {
        return artLiked;
    }


    /**
     * Returns the total number of people who art who responded to the heard
     * question.
     * 
     * @return The total number of people who art who responded to the heard
     *         question.
     */
    public int getArtTotalHeard() {
        return artTotalHeard;
    }


    /**
     * Returns the total number of people who art that responded to the like
     * question.
     * 
     * @return The total number of people who art that responded to the like
     *         question.
     */
    public int getArtTotalLiked() {
        return artTotalHeard;
    }


    /**
     * Returns the percentage of people who do art that heard the song.
     * 
     * @return The percentage of people who do art that heard the song.
     */
    public int getArtPercentHeard() {
        if (artTotalHeard == 0) {
            return 0;
        }
        double percent = (double)artHeard / (double)artTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who do art that liked the song.
     * 
     * @return The percentage of people who do art that liked the song.
     */
    public int getArtPercentLiked() {
        if (artTotalLiked == 0) {
            return 0;
        }
        double percent = (double)artLiked / (double)artTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number people who do music that heard the song.
     * 
     * @return The number people who do music that heard the song.
     */
    public int getMusicHeard() {
        return musicHeard;
    }


    /**
     * Returns the number people who do music that liked the song.
     * 
     * @return The number people who do music that liked the song.
     */
    public int getMusicLiked() {
        return musicLiked;
    }


    /**
     * Returns the total number of people who music who responded to the heard
     * question.
     * 
     * @return The total number of people who music who responded to the heard
     *         question.
     */
    public int getMusicTotalHeard() {
        return musicTotalHeard;
    }


    /**
     * Returns the total number of people who music that responded to the like
     * question.
     * 
     * @return The total number of people who music that responded to the like
     *         question.
     */
    public int getMusicTotalLiked() {
        return musicTotalHeard;
    }


    /**
     * Returns the percentage of people who do music that heard the song.
     * 
     * @return The percentage of people who do music that heard the song.
     */
    public int getMusicPercentHeard() {
        if (musicTotalHeard == 0) {
            return 0;
        }
        double percent = (double)musicHeard / (double)musicTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who do music that liked the song.
     * 
     * @return The percentage of people who do music that liked the song.
     */
    public int getMusicPercentLiked() {
        if (musicTotalLiked == 0) {
            return 0;
        }
        double percent = (double)musicLiked / (double)musicTotalLiked;
        return (int)(percent * 100);
    }
}
