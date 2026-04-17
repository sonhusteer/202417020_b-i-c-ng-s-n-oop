public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Hàm hoán đổi hai đối tượng
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm thay đổi tiêu đề
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    // Lưu tạm tiêu đề của dvd1
    String tmpTitle = dvd1.getTitle();
    // Gán tiêu đề của dvd2 cho dvd1
    dvd1.setTitle(dvd2.getTitle());
    // Gán tiêu đề tạm cho dvd2
    dvd2.setTitle(tmpTitle);
    
    // Lưu ý: Trong thực tế bạn cần hoán đổi tất cả các thuộc tính khác (giá, danh mục...)
}
}