import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

public class RestaurantManagement extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel countLabel;
    private int customerCount = 0;
    private Queue<String> customerQueue = new LinkedList<>();
    private Queue<String> counter1Queue = new LinkedList<>();
    private Queue<String> counter2Queue = new LinkedList<>();
    private Queue<String> counter3Queue = new LinkedList<>();
    private StringBuilder counter1Receipts = new StringBuilder();
    private StringBuilder counter2Receipts = new StringBuilder();
    private StringBuilder counter3Receipts = new StringBuilder();
    private DefaultListModel<String> counter1ListModel = new DefaultListModel<>();
    private DefaultListModel<String> counter2ListModel = new DefaultListModel<>();
    private DefaultListModel<String> counter3ListModel = new DefaultListModel<>();

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RestaurantManagement frame = new RestaurantManagement();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RestaurantManagement() {
        setResizable(false);
        setTitle("Restaurant Chicken & Rice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1231, 760);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        countLabel = new JLabel("Count : 0");
        countLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setBounds(575, 10, 100, 13);
        contentPane.add(countLabel);

        JButton showDataButton = new JButton("Show Data");
        showDataButton.setBackground(new Color(255, 255, 255));
        showDataButton.setFont(new Font("Dubai", Font.BOLD, 15));
        showDataButton.setBounds(376, 45, 127, 25);
        showDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShowDataFrame(customerQueue).setVisible(true);
            }
        });
        contentPane.add(showDataButton);

        JButton addNewCusButton = new JButton("Add New Customer");
        addNewCusButton.setBackground(new Color(255, 255, 255));
        addNewCusButton.setFont(new Font("Dubai", Font.BOLD, 15));
        addNewCusButton.setBounds(531, 45, 176, 25);
        addNewCusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewCustomer();
            }
        });
        contentPane.add(addNewCusButton);

        JButton nextQueueButton = new JButton("Next Queue");
        nextQueueButton.setBackground(new Color(255, 255, 255));
        nextQueueButton.setFont(new Font("Dubai", Font.BOLD, 15));
        nextQueueButton.setBounds(737, 45, 121, 25);
        nextQueueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextQueue();
            }
        });
        contentPane.add(nextQueueButton);

        createCounterButtons(84, 568, counter1Queue, "Counter 1", counter1Receipts);
        createCounterButtons(486, 568, counter2Queue, "Counter 2", counter2Receipts);
        createCounterButtons(910, 568, counter3Queue, "Counter 3", counter3Receipts);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 118, 386, 427);
        contentPane.add(scrollPane);
        
        JList<String> counter1List = new JList<>(counter1ListModel);
        counter1List.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
        scrollPane.setViewportView(counter1List);

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(422, 118, 372, 427);
        contentPane.add(scrollPane1);

        JList<String> counter2List = new JList<>(counter2ListModel);
        counter2List.setFont(new Font("Segoe UI", Font.BOLD, 13));
        scrollPane1.setViewportView(counter2List);

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(819, 118, 372, 427);
        contentPane.add(scrollPane2);

        JList<String> counter3List = new JList<>(counter3ListModel);
        counter3List.setFont(new Font("Segoe UI", Font.BOLD, 13));
        scrollPane2.setViewportView(counter3List);

        JButton recordButton = new JButton("Record");
        recordButton.setBackground(new Color(255, 255, 255));
        recordButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        recordButton.setBounds(0, 683, 1212, 40);
        recordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RecordFrame(counter1Receipts, counter2Receipts, counter3Receipts).setVisible(true);
            }
        });
        contentPane.add(recordButton);

        JLabel counter1Label = new JLabel("Counter 1");
        counter1Label.setFont(new Font("Nirmala UI", Font.BOLD, 15));
        counter1Label.setHorizontalAlignment(SwingConstants.CENTER);
        counter1Label.setBounds(172, 95, 100, 13);
        contentPane.add(counter1Label);

        JLabel counter2Label = new JLabel("Counter 2");
        counter2Label.setHorizontalAlignment(SwingConstants.CENTER);
        counter2Label.setFont(new Font("Nirmala UI", Font.BOLD, 15));
        counter2Label.setBounds(560, 95, 100, 13);
        contentPane.add(counter2Label);

        JLabel counter3Label = new JLabel("Counter 3");
        counter3Label.setHorizontalAlignment(SwingConstants.CENTER);
        counter3Label.setFont(new Font("Nirmala UI", Font.BOLD, 14));
        counter3Label.setBounds(968, 95, 100, 13);
        contentPane.add(counter3Label);
    }

    private void createCounterButtons(int x, int y, Queue<String> queue, String counterName, StringBuilder receipts) {
        JButton paymentButton = new JButton("Payment");
        paymentButton.setBackground(new Color(255, 255, 255));
        paymentButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        paymentButton.setBounds(x, y, 85, 25);
        paymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processPayment(queue, counterName, receipts);
                updateListModels();
            }
        });
        contentPane.add(paymentButton);

        JButton receiptButton = new JButton("Receipt");
        receiptButton.setBackground(new Color(255, 255, 255));
        receiptButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        receiptButton.setBounds(x + 171, y, 85, 25);
        receiptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showReceipt(receipts, counterName);
            }
        });
        contentPane.add(receiptButton);
    }

    private void addNewCustomer() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Downloads\\customerList.txt"))) {
            String line;
            while ((line = br.readLine()) != null && customerQueue.size() < 100) {
                customerQueue.add(line);
            }
            customerCount = customerQueue.size();
            countLabel.setText("Count : " + customerCount);
            JOptionPane.showMessageDialog(this, "100 New Customers added successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void nextQueue() {
        // Separate customers into the three queues
        while (!customerQueue.isEmpty() && (counter1Queue.size() < 5 || counter2Queue.size() < 5 || counter3Queue.size() < 5)) {
            String customer = customerQueue.poll();
            if (customer != null) {
                // Add debugging to verify customer format
                System.out.println("Customer Data: " + customer);
                try {
                    int quantity = Integer.parseInt(customer.split(",")[6].trim()); // Adjusted index to match the quantity field
                    System.out.println("Customer Quantity: " + quantity);

                    if (quantity <= 5 && counter1Queue.size() < 5) {
                        counter1Queue.add(customer);
                        System.out.println("Added to Counter 1: " + customer);
                    } else if (quantity <= 5 && counter2Queue.size() < 5) {
                        counter2Queue.add(customer);
                        System.out.println("Added to Counter 2: " + customer);
                    } else if (quantity > 5 && counter3Queue.size() < 5) {
                        counter3Queue.add(customer);
                        System.out.println("Added to Counter 3: " + customer);
                    } else {
                        customerQueue.add(customer);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing quantity for customer: " + customer);
                }
            }
        }
        updateListModels();
        updateQueueCounts();
    }

    private void processPayment(Queue<String> queue, String counterName, StringBuilder receipts) {
        if (!queue.isEmpty()) {
            String customer = queue.poll();
            // Process the payment for the customer
            receipts.append("Processed payment for ").append(customer.split(",")[1]).append(" at ").append(counterName).append("\n");
            JOptionPane.showMessageDialog(this, "Processed payment for " + customer.split(",")[1] + " at " + counterName);
        } else {
            JOptionPane.showMessageDialog(this, counterName + " is empty.");
        }
    }

    private void showReceipt(StringBuilder receipts, String counterName) {
        if (receipts.length() > 0) {
            JOptionPane.showMessageDialog(this, receipts.toString());
        } else {
            JOptionPane.showMessageDialog(this, counterName + " has no receipts.");
        }
    }

    private void updateQueueCounts() {
        // Update the counters based on current queue sizes
        countLabel.setText("Count : " + customerQueue.size());
    }

    private void updateListModels() {
        counter1ListModel.clear();
        counter2ListModel.clear();
        counter3ListModel.clear();

        for (String customer : counter1Queue) {
            counter1ListModel.addElement(customer);
        }

        for (String customer : counter2Queue) {
            counter2ListModel.addElement(customer);
        }

        for (String customer : counter3Queue) {
            counter3ListModel.addElement(customer);
        }

        // Debugging to ensure counters are updated correctly
        System.out.println("Counter 1 Queue: " + counter1Queue);
        System.out.println("Counter 2 Queue: " + counter2Queue);
        System.out.println("Counter 3 Queue: " + counter3Queue);
    }
}