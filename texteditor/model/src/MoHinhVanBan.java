import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class MoHinhVanBan {
    public void luuVaoFile(String duongDan, String noiDung) throws IOException {
        Files.write(Paths.get(duongDan), noiDung.getBytes());
    }

    public String taiTuFile(String duongDan) throws IOException {
        return new String(Files.readAllBytes(Paths.get(duongDan)));
    }
}
