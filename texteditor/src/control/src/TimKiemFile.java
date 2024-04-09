import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TimKiemFile {
    public List<String> timFile(String duongDanThuMuc, String tenFile) {
        List<String> ketQua = new ArrayList<>();
        File thuMuc = new File(duongDanThuMuc);
        File[] danhSachFile = thuMuc.listFiles();

        if (danhSachFile != null) {
            for (File file : danhSachFile) {
                if (file.isDirectory()) {
                    ketQua.addAll(timFile(file.getAbsolutePath(), tenFile));
                } else if (file.getName().equals(tenFile)) {
                    ketQua.add(file.getAbsolutePath());
                }
            }
        }

        return ketQua;
    }
}
