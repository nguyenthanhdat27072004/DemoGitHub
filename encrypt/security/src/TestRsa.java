import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class TestRsa {

    public static KeyPair taoCapKhoaRSA() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.genKeyPair();
    }

    public static byte[] maHoaRSA(String vanBan, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(vanBan.getBytes());
    }

    public static String giaiMaRSA(byte[] duLieuMaHoa, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(duLieuMaHoa);
        return new String(result);
    }

    public static void main(String[] args) {
        try {
            String vanBan = "Hello world i am nguyenthanhdat 23ns016";
            KeyPair capKhoa = taoCapKhoaRSA();
            PublicKey khoaCongKhai = capKhoa.getPublic();
            PrivateKey khoaRiengTu = capKhoa.getPrivate();
            byte[] vanBanMaHoa = maHoaRSA(vanBan, khoaCongKhai);
            System.out.println("Văn bản đã được mã hóa: " + new String(vanBanMaHoa));
            String vanBanGiaiMa = giaiMaRSA(vanBanMaHoa, khoaRiengTu);
            System.out.println("Văn bản sau khi giải mã: " + vanBanGiaiMa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
