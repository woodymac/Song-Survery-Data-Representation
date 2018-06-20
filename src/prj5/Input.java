package prj5;

import java.io.FileNotFoundException;

public class Input {
    public static void main(String[] strings) throws FileNotFoundException {
        SongReader songs = new SongReader(strings[1]);
        GlyphLinkedList list = songs.getGlyphList();
        SurveyReader survey = new SurveyReader(strings[0], list);
        list.sortGenre();
        System.out.println(list.toString(new Hobby()));
        list.sortTitle();
        System.out.println(list.toString(new Hobby()));
    }
}
