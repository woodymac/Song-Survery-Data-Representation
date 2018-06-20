package prj5;

/**
 * A singly linked list for storing glyphs. Can be sorted based on song title,
 * artist name, etc.
 * 
 * @author jtiernan
 * @version 2018.04.08
 * 
 * @param <Glyph>
 *            The abstract type Glyph
 *
 */
public class GlyphLinkedList implements LinkedList<Glyph> {

    /**
     * The Node<Glyph> class is to create nodes and manipulate their reference
     * pointers
     * 
     * @author jtiernan
     * @version 2018.04.08
     *
     */
    public class Node<Glyph> {

        private Glyph data;
        private Node<Glyph> next;


        /**
         * Creates a new Node object
         * 
         * @param dat
         *            The data for the node to hold
         */
        public Node(Glyph dat) {
            data = dat;
        }


        /**
         * Sets the data of the node
         * 
         * @param dat
         *            The new data for the node
         */
        public void setData(Glyph dat) {
            data = dat;
        }


        /**
         * Sets the next node reference for a node
         * 
         * @param n
         *            The next node to be referenced/pointed to
         */
        public void setNext(Node<Glyph> n) {
            next = n;
        }


        /**
         * Method to access the next referenced node from the previous node
         * 
         * @return Node<Glyph>
         *         Returns the next node
         */
        public Node<Glyph> next() {
            return this.next;
        }
    }

    private Node<Glyph> head;
    private int size;


    /**
     * Creates a new GlyphLinkedList object
     */
    public GlyphLinkedList() {
        head = null;
        size = 0;

    }


    /**
     * Returns the size of the list
     * 
     * @return int
     *         The size of the list (number of nodes)
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Adds a
     * 
     * @param index
     *            The index to add the Node at
     * @param obj
     *            The object that will be the data of the new Node
     */
    @Override
    public void add(int index, Glyph obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<Glyph> current = head;

        // empty list case
        if (isEmpty()) {
            head = new Node<Glyph>(obj);
        }

        else if (index == 0) {
            Node<Glyph> newNode = new Node<Glyph>(obj);
            newNode.setNext(head);
            head = newNode;
        }

        // all other cases
        else {
            int currentIndex = 0;
            while (current != null) {
                if ((currentIndex + 1) == index) {
                    Node<Glyph> nextNext = current.next;
                    Node<Glyph> newNode = new Node<Glyph>(obj);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);

                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;

    }


    /**
     * Adds a glyph object to the end of the linked list
     * 
     * @param obj
     *            The glyph object to be added
     */
    @Override
    public void add(Glyph obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<Glyph> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<Glyph>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<Glyph>(obj));
        }
        size++;
    }


    /**
     * Checks if list is empty
     * 
     * @return boolean
     *         True if list is empty, false if not
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes a specificed glyph from the list
     * 
     * @param obj
     *            The glyph to be removed from the list
     * @return boolean
     *         Returns true if successfully removed
     */
    @Override
    public boolean remove(Glyph obj) {
        Node<Glyph> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the glyph from a specified index in the list
     * 
     * @param index
     *            The index to remove a glyph from
     * @return boolean
     *         Returns true if removal is successful
     */
    @Override
    public boolean remove(int index) {
        // // if the index is invalid
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            Node<Glyph> current = head;
            int currentIndex = 0;

            // account for 1 size
            if ((index == 0)) {
                head = head.next;
                size--;
                return true;
            }

            // account for 2+ size
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<Glyph> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets/returns a glyph at the specified index in the list
     * 
     * @param index
     *            The index whose glyph we want to return
     * @return Glyph
     *         The glyph that is returned from the list
     */
    @Override
    public Glyph get(int index) {
        Node<Glyph> current = head;
        int currentIndex = 0;
        Glyph data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains a specified glyph
     * 
     * @param obj
     *            The glyph we are checking for
     * @return boolean
     *         True if the list contains the specified glyph, false if not
     */
    @Override
    public boolean contains(Glyph obj) {
        Node<Glyph> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Clears the list
     */
    @Override
    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Returns the last index of a glyph in the list
     * 
     * @param obj
     *            The glyph we are looking for in the list
     * @return int
     *         The index of the final occurrence of the specified glyph
     */
    @Override
    public int lastIndexOf(Glyph obj) {
        int lastIndex = -1;
        Node<Glyph> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns the list in a string format
     * 
     * @param a
     *            The atrribute type to return the list values
     * @return String
     *         The list in String format
     */
    public String toString(AttributeType a) {
        String result = "";

        Node<Glyph> current = head;
        while (current != null) {
            result += "" + current.data.toString(a);
            current = current.next;
            if (current != null) {
                result += '\n';
            }
        }
        return result;
    }


    /**
     * Sorts the list alphabetically by artist
     */
    public void sortArtist() {
        Node<Glyph> current = head;
        while (current.next() != null) {
            if ((current.data.getArtist().compareTo(current.next().data
                .getArtist())) > 0) {
                Glyph newNextData = current.data;
                Glyph newCurrentData = current.next().data;
                current.setData(newCurrentData);
                current.next().setData(newNextData);
                current = head;
            }
            else {
                current = current.next;
            }
        }
    }


    /**
     * Sorts the list alphabetically by title
     */
    public void sortTitle() {
        Node<Glyph> current = head;
        while (current.next() != null) {
            if ((current.data.getTitle().compareTo(current.next().data
                .getTitle())) > 0) {
                Glyph newNextData = current.data;
                Glyph newCurrentData = current.next().data;
                current.setData(newCurrentData);
                current.next().setData(newNextData);
                current = head;
            }
            else {
                current = current.next;
            }
        }
    }


    /**
     * Sorts the list numerically in increasing order by year
     */
    public void sortYear() {
        Node<Glyph> current = head;
        while (current.next() != null) {
            if ((current.data.getYear()) > (current.next().data.getYear())) {
                Glyph newNextData = current.data;
                Glyph newCurrentData = current.next().data;
                current.setData(newCurrentData);
                current.next().setData(newNextData);
                current = head;
            }
            else {
                current = current.next;
            }
        }
    }


    /**
     * Sorts the list alphabetically by genre
     */
    public void sortGenre() {
        Node<Glyph> current = head;
        while (current.next() != null) {
            if ((current.data.getGenre().compareTo(current.next().data
                .getGenre())) > 0) {
                Glyph newNextData = current.data;
                Glyph newCurrentData = current.next().data;
                current.setData(newCurrentData);
                current.next().setData(newNextData);
                current = head;
            }
            else {
                current = current.next;
            }
        }
    }

}
