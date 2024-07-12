import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.BorderLayout;

public class RecordFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> recordListModel = new DefaultListModel<>();

    public RecordFrame(StringBuilder counter1Receipts, StringBuilder counter2Receipts, StringBuilder counter3Receipts) {
        setTitle("All Receipts");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JList<String> recordList = new JList<>(recordListModel);
        scrollPane.setViewportView(recordList);

        // Add each receipt line by line for better scrolling experience
        recordListModel.addElement("Counter 1 Receipts:");
        for (String line : counter1Receipts.toString().split("\n")) {
            recordListModel.addElement(line);
        }

        recordListModel.addElement("Counter 2 Receipts:");
        for (String line : counter2Receipts.toString().split("\n")) {
            recordListModel.addElement(line);
        }

        recordListModel.addElement("Counter 3 Receipts:");
        for (String line : counter3Receipts.toString().split("\n")) {
            recordListModel.addElement(line);
        }
    }
}