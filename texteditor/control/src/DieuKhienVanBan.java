import javax.swing.*;

public class DieuKhienVanBan {
    private MoHinhVanBan model;
    private GiaoDienVanBan view;
    private TimKiemFile timKiem;

    public DieuKhienVanBan() {
        this.model = new MoHinhVanBan();
        this.view = new GiaoDienVanBan();
        this.timKiem = new TimKiemFile();

        this.view.themSuKienNutLuu(e -> luuVanBan());
        this.view.themSuKienNutTai(e -> taiVanBan());
        this.view.themSuKienNutTimKiem(e -> timKiemFile());
    }

    private void luuVanBan() {
        try {
            model.luuVaoFile(view.getDuongDan() + "/" + view.getTenFile(), view.getNoiDung());
            JOptionPane.showMessageDialog(null, "File đã được lưu.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi lưu file: " + e.getMessage());
        }
    }

    private void taiVanBan() {
        try {
            String noiDung = model.taiTuFile(view.getDuongDan() + "/" + view.getTenFile());
            view.setNoiDung(noiDung);
            JOptionPane.showMessageDialog(null, "File đã được tải.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải file: " + e.getMessage());
        }
    }

    private void timKiemFile() {
        java.util.List<String> ketQua = timKiem.timFile(view.getDuongDan(), view.getTenFile());
        if (ketQua.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy file nào.");
        } else {
            JOptionPane.showMessageDialog(null, "File(s) tìm thấy: \n" + String.join("\n", ketQua));
        }
    }

    public static void main(String[] args) {
            new DieuKhienVanBan();
    }
}
