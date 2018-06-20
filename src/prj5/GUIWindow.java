package prj5;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.io.FileNotFoundException;

public class GUIWindow {
    private Window window;
    private GlyphLinkedList glyphs;
    private int index;
    private static final int firstX = 120;
    private static final int firstY = 50;

    private Button major;


    public GUIWindow(GlyphLinkedList glyphs) {
        window = new Window();
        this.glyphs = glyphs;
        index = 0;

        Button hobby = new Button("Represent Hobby");
        hobby.onClick("clickedHobby");
        major = new Button("Represent Major");
        major.onClick(this, "clickedMajor");
        Button state = new Button("Represent Region");
        state.onClick("clickedState");
        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(state, WindowSide.SOUTH);

        Button quit = new Button("Quit");
        quit.onClick("clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);

        Button prev = new Button("<-- Prev");
        prev.onClick("clickedPrev");
        window.addButton(prev, WindowSide.NORTH);

        Button sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick("clickedSortArtist");
        Button sortTitle = new Button("Sort by Song Title");
        sortTitle.onClick("clickedSortTitle");
        Button sortYear = new Button("Sort by Release Year");
        sortYear.onClick("clickedSortYear");
        Button sortGenre = new Button("Sort by Genre");
        sortGenre.onClick("clickedSortGenre");
        window.addButton(sortArtist, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
        window.addButton(sortYear, WindowSide.NORTH);
        window.addButton(sortGenre, WindowSide.NORTH);

        Button next = new Button("Next -->");
        next.onClick("clickedNext");
        window.addButton(next, WindowSide.NORTH);

        // makeGlyph();
        makeLegend(new Major());
    }


    /**
     * public void makeGlyph()
     * {
     * TextShape title = new TextShape(window.getGraphPanelWidth()/ 2 - 50,
     * window.getGraphPanelHeight()/ 2 - 50, "Call Me Maybe", Color.black);
     * title.setBackgroundColor(Color.white);
     * window.addShape(title);
     * 
     * TextShape artist = new TextShape(window.getGraphPanelWidth()/ 2 - 65,
     * window.getGraphPanelHeight()/ 2 - 35, "by Carly Rae Jepsen",
     * Color.black);
     * artist.setBackgroundColor(Color.white);
     * window.addShape(artist);
     * 
     * Shape blackBar = new Shape(window.getGraphPanelWidth()/ 2,
     * window.getGraphPanelHeight()/ 2, 5, 60, Color.black);
     * window.addShape(blackBar);
     * 
     * Shape pinkBar = new Shape(350, 150, 135, 15, Color.pink);
     * window.addShape(pinkBar);
     * 
     * Shape blueBar = new Shape(370, 150 + 15, 154, 15, Color.blue);
     * window.addShape(blueBar);
     * 
     * Shape yellowBar = new Shape(355, 150 + 30, 140, 15, Color.yellow);
     * window.addShape(yellowBar);
     * 
     * Shape greenBar = new Shape(360, 150 + 45, 130, 15, Color.green);
     * window.addShape(greenBar);
     * 
     * TextShape titleLegend = new TextShape(700, 100, "Hobby Legend",
     * Color.black);
     * titleLegend.setBackgroundColor(Color.white);
     * window.addShape(titleLegend);
     * 
     * TextShape readLegend = new TextShape(700, 120, "Read", Color.pink);
     * readLegend.setBackgroundColor(Color.white);
     * window.addShape(readLegend);
     * 
     * TextShape artLegend = new TextShape(700, 135, "Art", Color.blue);
     * artLegend.setBackgroundColor(Color.white);
     * window.addShape(artLegend);
     * 
     * TextShape sportsLegend = new TextShape(700, 150, "Sports", Color.yellow);
     * sportsLegend.setBackgroundColor(Color.white);
     * window.addShape(sportsLegend);
     * 
     * TextShape musicLegend = new TextShape(700, 165, "Music", Color.green);
     * musicLegend.setBackgroundColor(Color.white);
     * window.addShape(musicLegend);
     * 
     * TextShape songTitleLegend = new TextShape(735, 185, "Song Title",
     * Color.black);
     * songTitleLegend.setBackgroundColor(Color.white);
     * window.addShape(songTitleLegend);
     * 
     * TextShape heardLegend = new TextShape(720, 210, "Heard", Color.black);
     * heardLegend.setBackgroundColor(Color.white);
     * window.addShape(heardLegend);
     * 
     * Shape blackBarLegend = new Shape(765, 205, 5, 30, Color.black);
     * window.addShape(blackBarLegend);
     * 
     * TextShape likedLegend = new TextShape(770, 210, "Liked", Color.black);
     * likedLegend.setBackgroundColor(Color.white);
     * window.addShape(likedLegend);
     * 
     * Shape legendBox = new Shape(690, 90, 135, 150, Color.white);
     * legendBox.setForegroundColor(Color.black);
     * window.addShape(legendBox);
     * }
     */

    /**
     * Creates the legend in the bottom right corner.
     * 
     * @param type
     *            The attribute type currently being represented. Determines
     *            which four attribute names are being displayed in the legend.
     */
    private void makeLegend(AttributeType type) {
        int panelWidth = window.getGraphPanelWidth();
        int panelHeight = window.getGraphPanelHeight();

        // creates the glyph bar display at the bottom of the legend

        TextShape songTitleLegend = new TextShape(0, panelHeight - 70,
            "Song Title", Color.black);
        songTitleLegend.setBackgroundColor(Color.white);
        songTitleLegend.setX(panelWidth - 67 - (songTitleLegend.getWidth()
            / 2));
        window.addShape(songTitleLegend);

        Shape blackBarLegend = new Shape(panelWidth - 70, panelHeight - 50, 5,
            40, Color.black);
        window.addShape(blackBarLegend);

        TextShape heardLegend = new TextShape(0, panelHeight - 40, "Heard",
            Color.black);
        heardLegend.setBackgroundColor(Color.white);
        heardLegend.setX(blackBarLegend.getX() - heardLegend.getWidth() - 5);
        window.addShape(heardLegend);

        TextShape likedLegend = new TextShape(0, panelHeight - 40, "Liked",
            Color.black);
        likedLegend.setBackgroundColor(Color.white);
        likedLegend.setX(blackBarLegend.getX() + 5);
        window.addShape(likedLegend);

        // if statement based on attribute type
        if (type.getClass() == Hobby.class) {
            legendAttributes("Hobby", "Read", "Art", "Sports", "Music");
        }
        else if (type.getClass() == Major.class) {
            legendAttributes("Major", "Comp Sci", "Other Eng", "Math/CMDA",
                "Other");
        }
        else if (type.getClass() == State.class) {
            legendAttributes("Region", "Northeast US", "Southeast US",
                "Rest of US", "Outside US");
        }

        // creates the legend box
        Shape legendBox = new Shape(panelWidth - 135, panelHeight - 150, 135,
            150, Color.white);
        legendBox.setForegroundColor(Color.black);
        window.addShape(legendBox);

    }


    /**
     * Creates the legend title and the four attribute labels.
     * 
     * @param titleType
     *            The attribute type being represented.
     * 
     * @param attr1
     *            First attribute.
     * 
     * @param attr2
     *            Second attribute.
     * 
     * @param attr3
     *            Third attribute.
     * 
     * @param attr4
     *            Fourth attribute.
     */
    private void legendAttributes(
        String titleType,
        String attr1,
        String attr2,
        String attr3,
        String attr4) {
        // title
        TextShape title = new TextShape(0, window.getGraphPanelHeight() - 145,
            titleType + " Legend", Color.black);
        title.setBackgroundColor(Color.white);
        title.setX(window.getGraphPanelWidth() - (135 / 2) - (title.getWidth()
            / 2));
        window.addShape(title);

        // attribute 1
        TextShape firstAttr = new TextShape(window.getGraphPanelWidth() - 130,
            window.getGraphPanelHeight() - 130, attr1, Color.pink);
        firstAttr.setBackgroundColor(Color.white);
        window.addShape(firstAttr);

        // attribute 2
        TextShape secondAttr = new TextShape(window.getGraphPanelWidth() - 130,
            window.getGraphPanelHeight() - 115, attr2, Color.blue);
        secondAttr.setBackgroundColor(Color.white);
        window.addShape(secondAttr);

        // attribute 3
        TextShape thirdAttr = new TextShape(window.getGraphPanelWidth() - 130,
            window.getGraphPanelHeight() - 100, attr3, new Color(244, 208, 63));
        thirdAttr.setBackgroundColor(Color.white);
        window.addShape(thirdAttr);

        // attribute 4
        TextShape fourthAttr = new TextShape(window.getGraphPanelWidth() - 130,
            window.getGraphPanelHeight() - 85, attr4, Color.green);
        fourthAttr.setBackgroundColor(Color.white);
        window.addShape(fourthAttr);
    }


    public void clickedMajor(Button button) {
        window.removeAllShapes();
        int curIndex = index;
        for (int y = firstY, yCount = 0; yCount < 3; y += 2
            * firstY, yCount++) {
            for (int x = firstX, xCount = 0; xCount < 3; x += 2
                * firstX, xCount++) {
                if (curIndex < glyphs.size()) {
                    Glyph glyph = glyphs.get(curIndex);
                    String songTitle = glyph.getTitle();
                    String artist = glyph.getArtist();

                    Shape blackBar = new Shape(x, y, 5, 40, Color.black);
                    window.addShape(blackBar);

                    TextShape titleShape = new TextShape(x, y - 40, songTitle,
                        Color.black);
                    titleShape.setBackgroundColor(Color.white);
                    titleShape.setX(x - (titleShape.getWidth() / 2));
                    window.addShape(titleShape);

                    TextShape artistShape = new TextShape(x, y - 25, "by "
                        + artist, Color.black);
                    artistShape.setBackgroundColor(Color.white);
                    artistShape.setX(x - (titleShape.getWidth() / 2));
                    window.addShape(artistShape);

                    curIndex++;

                    Major major = glyph.getMajor();
                }
            }
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        // SongReader songs = new SongReader(args[0]);
        // GlyphLinkedList list = songs.getGlyphList();
        // SurveyReader survey = new SurveyReader(args[0], list);
        GUIWindow g = new GUIWindow(null);
    }
}
