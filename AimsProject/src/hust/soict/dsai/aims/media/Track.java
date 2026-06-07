package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Media length is non-positive!");
        }
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Track) {
            return ((Track) o).getTitle().equals(this.title) && ((Track) o).getLength() == this.length;
        }
        return false;
    }
}