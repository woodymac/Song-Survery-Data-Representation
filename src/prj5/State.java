package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Woody McIlhenny (woodymac)

/**
 * Represents the data related to each state for a particular song.
 * 
 * @author Woody McIlhenny
 * @version 2018.04.09
 */
public class State extends AttributeType {

    private int neUSHeard;
    private int neUSLiked;
    private int neUSTotalHeard;
    private int neUSTotalLiked;

    private int seUSHeard;
    private int seUSLiked;
    private int seUSTotalHeard;
    private int seUSTotalLiked;

    private int otherUSHeard;
    private int otherUSLiked;
    private int otherUSTotalHeard;
    private int otherUSTotalLiked;

    private int outsideUSHeard;
    private int outsideUSLiked;
    private int outsideUSTotalHeard;
    private int outsideUSTotalLiked;


    /**
     * Creates a new Hobby object.
     */
    public State() {
        neUSHeard = 0;
        neUSLiked = 0;
        neUSTotalHeard = 0;
        neUSTotalLiked = 0;

        seUSHeard = 0;
        seUSLiked = 0;
        seUSTotalHeard = 0;
        seUSTotalLiked = 0;

        otherUSHeard = 0;
        otherUSLiked = 0;
        otherUSTotalHeard = 0;
        otherUSTotalLiked = 0;

        outsideUSHeard = 0;
        outsideUSLiked = 0;
        outsideUSTotalHeard = 0;
        outsideUSTotalLiked = 0;

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
        // if (attr.isInGroup(Group.STATE)) {
        switch (attr) {
            case NORTHEAST: {
                if (hAns) {
                    neUSTotalHeard++;
                    if (heard) {
                        neUSHeard++;
                    }
                }
                if (lAns) {
                    neUSTotalLiked++;
                    if (liked) {
                        neUSLiked++;
                    }
                }
                break;
            }
            case SOUTHEAST: {
                if (hAns) {
                    seUSTotalHeard++;
                    if (heard) {
                        seUSHeard++;
                    }
                }
                if (lAns) {
                    seUSTotalLiked++;
                    if (liked) {
                        seUSLiked++;
                    }
                }
                break;
            }
            case OTHER_US: {
                if (hAns) {
                    otherUSTotalHeard++;
                    if (heard) {
                        otherUSHeard++;
                    }
                }
                if (lAns) {
                    otherUSTotalLiked++;
                    if (liked) {
                        otherUSLiked++;
                    }
                }
                break;
            }
            default: {
                if (hAns) {
                    outsideUSTotalHeard++;
                    if (heard) {
                        outsideUSHeard++;
                    }
                }
                if (lAns) {
                    outsideUSTotalLiked++;
                    if (liked) {
                        outsideUSLiked++;
                    }
                }
                break;
            }
        }
        // }
    }


    /**
     * Returns the number of people from the northeast US that heard the song.
     * 
     * @return The number of people from the northeast US that heard the song.
     */
    public int getNEUSHeard() {
        return neUSHeard;
    }


    /**
     * Returns the number of people from the northeast US that liked the song.
     * 
     * @return The number of people from the northeast US that liked the song.
     */
    public int getNEUSLiked() {
        return neUSLiked;
    }


    /**
     * Returns the total number of people from the northeast US who responded to
     * the heard
     * question.
     * 
     * @return The total number of people from the northeast US who responded to
     *         the heard
     *         question.
     */
    public int getNEUSTotalHeard() {
        return neUSTotalHeard;
    }


    /**
     * Returns the total number of people from the northeast US that responded
     * to the like
     * question.
     * 
     * @return The total number of people from the northeast US that responded
     *         to the like
     *         question.
     */
    public int getNEUSTotalLiked() {
        return neUSTotalLiked;
    }


    /**
     * Returns the percentage of people who live in the northeast US that heard
     * the song.
     * 
     * @return The percentage of people who live in the northeast US that heard
     *         the song.
     */
    public int getNEUSPercentHeard() {
        if (neUSTotalHeard == 0) {
            return 0;
        }
        double percent = (double)neUSHeard / (double)neUSTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who live in the northeast US that liked
     * the song.
     * 
     * @return The percentage of people who live in the northeast US that liked
     *         the song.
     */
    public int getNEUSPercentLiked() {
        if (neUSTotalLiked == 0) {
            return 0;
        }
        double percent = (double)neUSLiked / (double)neUSTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number of people from the southeast US that heard the song.
     * 
     * @return The number of people from the southeast US that heard the song.
     */
    public int getSEUSHeard() {
        return seUSHeard;
    }


    /**
     * Returns the number of people from the southeast US that liked the song.
     * 
     * @return The number of people from the southeast US that liked the song.
     */
    public int getSEUSLiked() {
        return seUSLiked;
    }


    /**
     * Returns the total number of people from the southeast US who responded to
     * the heard
     * question.
     * 
     * @return The total number of people from the southeast US who responded to
     *         the heard
     *         question.
     */
    public int getSEUSTotalHeard() {
        return seUSTotalHeard;
    }


    /**
     * Returns the total number of people from the southeast US that responded
     * to the like
     * question.
     * 
     * @return The total number of people from the southeast US that responded
     *         to the like
     *         question.
     */
    public int getSEUSTotalLiked() {
        return seUSTotalLiked;
    }


    /**
     * Returns the percentage of people who live in the southeast US that heard
     * the song.
     * 
     * @return The percentage of people who live in the southeast US that heard
     *         the song.
     */
    public int getSEUSPercentHeard() {
        if (seUSTotalHeard == 0) {
            return 0;
        }
        double percent = (double)seUSHeard / (double)seUSTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who live in the southeast US that liked
     * the song.
     * 
     * @return The percentage of people who live in the southeast US that liked
     *         the song.
     */
    public int getSEUSPercentLiked() {
        if (seUSTotalLiked == 0) {
            return 0;
        }
        double percent = (double)seUSLiked / (double)seUSTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number of people from somewhere else in the US that liked the
     * song.
     * 
     * @return The number of people from somewhere else in the US that liked the
     *         song.
     */
    public int getOtherUSHeard() {
        return otherUSHeard;
    }


    /**
     * Returns the number of people from somewhere else in the US that liked the
     * song.
     * 
     * @return The number of people from somewhere else in the US that liked the
     *         song.
     */
    public int getOtherUSLiked() {
        return otherUSLiked;
    }


    /**
     * Returns the total number of people from somewhere else in the US who
     * responded to
     * the heard
     * question.
     * 
     * @return The total number of people from somewhere else in the US who
     *         responded to
     *         the heard
     *         question.
     */
    public int getOtherUSTotalHeard() {
        return otherUSTotalHeard;
    }


    /**
     * Returns the total number of people from somewhere else in the US that responded
     * to the like
     * question.
     * 
     * @return The total number of people from somewhere else in the US that responded
     *         to the like
     *         question.
     */
    public int getOtherUSTotalLiked() {
        return otherUSTotalLiked;
    }


    /**
     * Returns the percentage of people who live somewhere else in the US that
     * heard the song.
     * 
     * @return The percentage of people who live somewhere else in the US that
     *         heard the song.
     */
    public int getOtherUSPercentHeard() {
        if (otherUSTotalHeard == 0) {
            return 0;
        }
        double percent = (double)otherUSHeard / (double)otherUSTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who live somewhere else in the US that
     * liked the song.
     * 
     * @return The percentage of people who live somewhere else in the US that
     *         liked the song.
     */
    public int getOtherUSPercentLiked() {
        if (otherUSTotalLiked == 0) {
            return 0;
        }
        double percent = (double)otherUSLiked / (double)otherUSTotalLiked;
        return (int)(percent * 100);
    }


    /**
     * Returns the number of people from outside the US that liked the song.
     * 
     * @return The number of people from outside the US that liked the song.
     */
    public int getOutsideUSHeard() {
        return outsideUSHeard;
    }


    /**
     * Returns the number of people from outside the US that liked the song.
     * 
     * @return The number of people from outside the US that liked the song.
     */
    public int getOutsideUSLiked() {
        return outsideUSLiked;
    }


    /**
     * Returns the total number of people from outside the US who
     * responded to
     * the heard
     * question.
     * 
     * @return The total number of people from outside the US who
     *         responded to
     *         the heard
     *         question.
     */
    public int getOutsideUSTotalHeard() {
        return outsideUSTotalHeard;
    }


    /**
     * Returns the total number of people from outside the US that responded
     * to the like
     * question.
     * 
     * @return The total number of people from outside the US that responded
     *         to the like
     *         question.
     */
    public int getOutsideUSTotalLiked() {
        return outsideUSTotalLiked;
    }

    /**
     * Returns the percentage of people who live outside the US that heard
     * the song.
     * 
     * @return The percentage of people who live outside the US that heard
     *         the song.
     */
    public int getOutsideUSPercentHeard() {
        if (outsideUSTotalHeard == 0) {
            return 0;
        }
        double percent = (double)outsideUSHeard / (double)outsideUSTotalHeard;
        return (int)(percent * 100);
    }


    /**
     * Returns the percentage of people who live outside the US that liked
     * the song.
     * 
     * @return The percentage of people who live outside the US that liked
     *         the song.
     */
    public int getOutsideUSPercentLiked() {
        if (outsideUSTotalLiked == 0) {
            return 0;
        }
        double percent = (double)outsideUSLiked / (double)outsideUSTotalLiked;
        return (int)(percent * 100);
    }
}
