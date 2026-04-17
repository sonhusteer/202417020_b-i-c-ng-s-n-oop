

public class DigitalVideoDisc {
    // 1. Khai báo thuộc tính ở đầu
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // 2. Các Constructors (Nạp chồng theo yêu cầu mục 8) [cite: 337]
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // 3. Chỉ giữ lại Getters (Accessors) theo yêu cầu mục 7 
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
}
