package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Represents the data related to each major for a particular song.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class Major extends AttributeType {

    private int csHeard;
    private int csLiked;
    private int csTotalHeard;
    private int csTotalLiked;

    private int mathHeard;
    private int mathLiked;
    private int mathTotalHeard;
    private int mathTotalLiked;

    private int engineeringHeard;
    private int engineeringLiked;
    private int engineeringTotalHeard;
    private int engineeringTotalLiked;

    private int otherHeard;
    private int otherLiked;
    private int otherTotalHeard;
    private int otherTotalLiked;


    /**
     * Creates a new Hobby object.
     */
    public Major() {
        csHeard = 0;
        csLiked = 0;
        csTotalHeard = 0;
        csTotalLiked = 0;

        mathHeard = 0;
        mathLiked = 0;
        mathTotalHeard = 0;
        mathTotalLiked = 0;

        engineeringHeard = 0;
        engineeringLiked = 0;
        mathTotalHeard = 0;
        mathTotalLiked = 0;

        otherHeard = 0;
        otherLiked = 0;
        mathTotalHeard = 0;
        mathTotalLiked = 0;
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
        // if (attr.isInGroup(Group.MAJOR)) {
        switch (attr) {
            case CS: {
                if (hAns) {
                    csTotalHeard++;
                    if (heard) {
                        csHeard++;
                    }
                }
                if (lAns) {
                    csTotalLiked++;
                    if (liked) {
                        csLiked++;
                    }
                }
                break;
            }
            case MATH: {
                if (hAns) {
                    mathTotalHeard++;
                    if (heard) {
                        mathHeard++;
                    }
                }
                if (lAns) {
                    mathTotalLiked++;
                    if (liked) {
                        mathLiked++;
                    }
                }
                break;
            }
            case ENGINEERING: {
                if (hAns) {
                    engineeringTotalHeard++;
                    if (heard) {
                        engineeringHeard++;
                    }
                }
                if (lAns) {
                    engineeringTotalLiked++;
                    if (liked) {
                        engineeringLiked++;
                    }
                }
                break;
            }
            default: {
                if (hAns) {
                    otherTotalHeard++;
                    if (heard) {
                        otherHeard++;
                    }
                }
                if (lAns) {
                    otherTotalLiked++;
                    if (liked) {
                        otherLiked++;
                    }
                }
                break;
            }
        }
        // }
    }


    /**
     * Returns the number of CS majors that heard the song.
     * 
     * @return The number of CS majors that heard the song.
     */
    public int getCSHeard() {
        return csHeard;
    }


    /**
     * Returns the number of CS majors that liked the song.
     * 
     * @return The number of CS majors that liked the song.
     */
    public int getCSLiked() {
        return csLiked;
    }


    /**
     * Returns the total number of people in CS who responded to the heard
     * question.
     * 
     * @return The total number of people in CS who responded to the heard
     *         question.
     */
    public int getCSTotalHeard() {
        return csTotalHeard;
    }


    /**
     * Returns the total number of people in CS that responded to the like
     * question.
     * 
     * @return The total number of people in CS that responded to the like
     *         question.
     */
    public int getCSTotalLiked() {
        return csTotalLiked;
    }


    /**
     * Returns the percentage of CS majors that heard the song.
     * 
     * @return The percentage of CS majors that heard the song.
     */
    public int getCSPercentHeard() {
        if (csTotalHeard == 0) {
            return 0;
        }
        double percent = (double)csHeard / (double)csTotalHeard;
        return (int)(percent * 100);

    }


    /**
     * Returns the percentage of CS majors that liked the song.
     * 
     * @return The percentage of CS majors that liked the song.
     */
    public int getCSPercentLiked() {
        if (csTotalHeard == 0) {
            return 0;
        }
        double percent = (double)csLiked / (double)csTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the number of math/CMDA majors that heard the song.
     * 
     * @return The number of math/CMDA majors that heard the song.
     */
    public int getMathHeard() {
        return mathHeard;
    }


    /**
     * Returns the number of math/CMDA majors that liked the song.
     * 
     * @return The number of math/CMDA majors that liked the song.
     */
    public int getMathLiked() {
        return mathLiked;
    }


    /**
     * Returns the total number of people in math who responded to the heard
     * question.
     * 
     * @return The total number of people in math who responded to the heard
     *         question.
     */
    public int getMathTotalHeard() {
        return mathTotalHeard;
    }


    /**
     * Returns the total number of people in math that responded to the like
     * question.
     * 
     * @return The total number of people in math that responded to the like
     *         question.
     */
    public int getMathTotalLiked() {
        return mathTotalLiked;
    }


    /**
     * Returns the percentage of math/CMDA majors that heard the song.
     * 
     * @return The percentage of math/CMDA majors that heard the song.
     */
    public int getMathPercentHeard() {
        if (mathTotalHeard == 0) {
            return 0;
        }
        double percent = (double)mathHeard / (double)mathTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of math/CMDA majors that liked the song.
     * 
     * @return The percentage of math/CMDA majors that liked the song.
     */
    public int getMathPercentLiked() {
        if (mathTotalLiked == 0) {
            return 0;
        }
        double percent = (double)mathLiked / (double)mathTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number of engineering majors that heard the song.
     * 
     * @return The number of engineering majors that heard the song.
     */
    public int getEngineeringHeard() {
        return engineeringHeard;
    }


    /**
     * Returns the number of engineering majors that liked the song.
     * 
     * @return The number of engineering majors that liked the song.
     */
    public int getEngineeringLiked() {
        return engineeringLiked;
    }


    /**
     * Returns the total number of people in engineering who responded to the
     * heard
     * question.
     * 
     * @return The total number of people in engineering who responded to the
     *         heard
     *         question.
     */
    public int getEngineeringTotalHeard() {
        return engineeringTotalHeard;
    }


    /**
     * Returns the total number of people in engineering that responded to the
     * like
     * question.
     * 
     * @return The total number of people in engineering that responded to the
     *         like
     *         question.
     */
    public int getEngineeringTotalLiked() {
        return engineeringTotalLiked;
    }


    /**
     * Returns the percentage of engineering majors that heard the song.
     * 
     * @return The percentage of engineering majors that heard the song.
     */
    public int getEngineeringPercentHeard() {
        if (engineeringTotalHeard == 0) {
            return 0;
        }
        double percent = (double)engineeringHeard
            / (double)engineeringTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of engineering majors that liked the song.
     * 
     * @return The percentage of engineering majors that liked the song.
     */
    public int getEngineeringPercentLiked() {
        if (engineeringTotalLiked == 0) {
            return 0;
        }
        double percent = (double)engineeringLiked
            / (double)engineeringTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number of other majors that heard the song.
     * 
     * @return The number of other majors that heard the song.
     */
    public int getOtherHeard() {
        return otherHeard;
    }


    /**
     * Returns the number of other majors that liked the song.
     * 
     * @return The number of other majors that liked the song.
     */
    public int getOtherLiked() {
        return otherLiked;
    }


    /**
     * Returns the total number of people in other majors who responded to the
     * heard
     * question.
     * 
     * @return The total number of people in other majors who responded to the
     *         heard
     *         question.
     */
    public int getOtherTotalHeard() {
        return otherTotalHeard;
    }


    /**
     * Returns the total number of people in other majors that responded to the
     * like
     * question.
     * 
     * @return The total number of people in other majors that responded to the
     *         like
     *         question.
     */
    public int getOtherTotalLiked() {
        return otherTotalLiked;
    }


    /**
     * Returns the percentage of other majors that heard the song.
     * 
     * @return The percentage of other majors that heard the song.
     */
    public int getOtherPercentHeard() {
        if (otherTotalHeard == 0) {
            return 0;
        }
        double percent = (double)otherHeard / (double)otherTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of other majors that liked the song.
     * 
     * @return The percentage of other majors that liked the song.
     */
    public int getOtherPercentLiked() {
        if (otherTotalLiked == 0) {
            return 0;
        }
        double percent = (double)otherLiked / (double)otherTotalLiked;
        return (int)(percent * 100);
    }
}
