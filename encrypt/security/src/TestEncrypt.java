import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestEncrypt {

    public static String taoMaHoaSHA256(String vanBan) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(vanBan.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        try {
            String vanBan = "hello world";
            String ketQuaMaHoa = taoMaHoaSHA256(vanBan);
            System.out.println("Chuỗi mã hóa SHA-256: " + ketQuaMaHoa);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }
}
