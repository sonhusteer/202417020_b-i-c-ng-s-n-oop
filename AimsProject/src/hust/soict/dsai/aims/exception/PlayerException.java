package hust.soict.dsai.aims.exception;

/**
 * Ngoại lệ tùy chỉnh cho hệ thống phát media AIMS.
 * Ném ra khi độ dài media không hợp lệ (<=0) hoặc khi phát thất bại.
 */
public class PlayerException extends Exception {

    /**
     * Khởi tạo với thông điệp lỗi mô tả nguyên nhân.
     *
     * @param message mô tả lỗi
     */
    public PlayerException(String message) {
        super(message);
    }

    /**
     * Khởi tạo với thông điệp lỗi và nguyên nhân gốc (chaining).
     *
     * @param message mô tả lỗi
     * @param cause   ngoại lệ gốc gây ra lỗi này
     */
    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
