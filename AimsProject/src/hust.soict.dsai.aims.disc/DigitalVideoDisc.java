

public class DigitalVideoDisc {
    // 1. Khai báo thuộc tính ở đầu
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

private static int nbDigitalVideoDiscs = 0; 
    private int id;

    // 2. Các Constructors (Nạp chồng theo yêu cầu mục 8) [cite: 337]
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    // 3. Chỉ giữ lại Getters (Accessors) theo yêu cầu mục 7 
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public void setTitle(String title) {
    this.title = title;
}
@Override
public String toString() {
    return "DVD - " + title + " - " + (category != null ? category : "N/A") + 
           " - " + (director != null ? director : "N/A") + 
           " - " + length + ": " + cost + " $";
}
public boolean isMatch(String title) {
    // Kiểm tra xem tiêu đề đối tượng có chứa chuỗi title truyền vào không (không phân biệt hoa thường)
    return this.title.toLowerCase().contains(title.toLowerCase());
}
public int getId() {
    return id;
}
}
