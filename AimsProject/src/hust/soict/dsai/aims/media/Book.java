package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super(); // Gọi constructor của lớp Media
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Thêm các phương thức addAuthor và removeAuthor ở đây
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return this.getId() + ". Book - " + this.getTitle() + " - " + this.getCategory() + " - " + authors.toString() + " - " + this.getCost() + " $";
    }
}
