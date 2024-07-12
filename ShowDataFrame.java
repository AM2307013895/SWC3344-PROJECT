import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

public class ShowDataFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> showDataListModel = new DefaultListModel<>();

    public ShowDataFrame(Queue<String> customerQueue) {
        setTitle("Show Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 414, 239);
        contentPane.add(scrollPane);

        JList<String> showDataList = new JList<>(showDataListModel);
        scrollPane.setViewportView(showDataList);

        for (String customer : customerQueue) {
            showDataListModel.addElement(customer);
        }
    }
}