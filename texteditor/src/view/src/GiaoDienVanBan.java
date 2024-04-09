import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GiaoDienVanBan {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField pathField, filenameField;
    private JButton saveButton, loadButton, searchButton;

    public GiaoDienVanBan() {
        frame = new JFrame("Text Editor");
        textArea = new JTextArea();
        pathField = new JTextField(20);
        filenameField = new JTextField(20);
        saveButton = new JButton("Lưu");
        loadButton = new JButton("Tải");
        searchButton = new JButton("Tìm Kiếm");

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Đường dẫn:"));
        northPanel.add(pathField);
        northPanel.add(new JLabel("Tên File:"));
        northPanel.add(filenameField);
        frame.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.add(saveButton);
        southPanel.add(loadButton);
        southPanel.add(searchButton);
        frame.add(southPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    // Getter và Setter cùng các phương thức thêm sự kiện
    public String getNoiDung() {
        return textArea.getText();
    }

    public void setNoiDung(String noiDung) {
        textArea.setText(noiDung);
    }

    public String getDuongDan() {
        return pathField.getText();
    }

    public String getTenFile() {
        return filenameField.getText();
    }

    public void themSuKienNutLuu(ActionListener langNghe) {
        saveButton.addActionListener(langNghe);
    }

    public void themSuKienNutTai(ActionListener langNghe) {
        loadButton.addActionListener(langNghe);
    }

    public void themSuKienNutTimKiem(ActionListener langNghe) {
        searchButton.addActionListener(langNghe);
    }
}
