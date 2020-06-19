/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Bekhzod
 */
public class MainMenuClerk extends javax.swing.JFrame {

    private Bank bank;

    private String saveLocation = null;

    /**
     * Creates new form MainMenu
     */
    
    public MainMenuClerk(Bank bank) {
        initComponents();
        setLocationRelativeTo(null);
        this.bank = bank;
        reloadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContentPanel = new javax.swing.JPanel();
        addAccountButton = new javax.swing.JButton();
        removeAccountButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        queryField = new javax.swing.JTextField();
        statsAccountButton = new javax.swing.JButton();
        seatchButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        reLoginMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Application (Clerk)");
        setMinimumSize(new java.awt.Dimension(550, 400));

        ContentPanel.setPreferredSize(new java.awt.Dimension(530, 368));

        addAccountButton.setText("Add Account");
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountButtonActionPerformed(evt);
            }
        });

        removeAccountButton.setText("RemoveAccount");
        removeAccountButton.setEnabled(false);
        removeAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAccountButtonActionPerformed(evt);
            }
        });

        accountTable.setAutoCreateRowSorter(true);
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Account Number", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountTable.getTableHeader().setReorderingAllowed(false);
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountTable);
        if (accountTable.getColumnModel().getColumnCount() > 0) {
            accountTable.getColumnModel().getColumn(0).setResizable(false);
            accountTable.getColumnModel().getColumn(1).setResizable(false);
            accountTable.getColumnModel().getColumn(2).setResizable(false);
            accountTable.getColumnModel().getColumn(3).setResizable(false);
        }

        statsAccountButton.setText("Statistical Analysis");
        statsAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsAccountButtonActionPerformed(evt);
            }
        });

        seatchButton.setText("Search");
        seatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContentPanelLayout = new javax.swing.GroupLayout(ContentPanel);
        ContentPanel.setLayout(ContentPanelLayout);
        ContentPanelLayout.setHorizontalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(ContentPanelLayout.createSequentialGroup()
                        .addGroup(ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(queryField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ContentPanelLayout.createSequentialGroup()
                                .addComponent(addAccountButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeAccountButton)
                                .addGap(18, 18, 18)
                                .addComponent(statsAccountButton)))
                        .addGap(18, 18, 18)
                        .addComponent(seatchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ContentPanelLayout.setVerticalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAccountButton)
                    .addComponent(removeAccountButton)
                    .addComponent(statsAccountButton))
                .addGap(18, 18, 18)
                .addGroup(ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryField)
                    .addComponent(seatchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FileMenu.setText("File");

        reLoginMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        reLoginMenuItem.setText("Re-login");
        reLoginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reLoginMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(reLoginMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-16.png"))); // NOI18N
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText("Save As...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveAsMenuItem);

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open-16.png"))); // NOI18N
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(openMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit-16.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(exitMenuItem);

        MenuBar.add(FileMenu);

        EditMenu.setText("Edit");
        MenuBar.add(EditMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void addAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountButtonActionPerformed
        AddAccountMenu menu = new AddAccountMenu(this, true, bank);
        menu.setVisible(true);
        if (menu.getCustomer() != null) {
            addCustomerToTable(menu.getCustomer());
        }
    }//GEN-LAST:event_addAccountButtonActionPerformed

    private void removeAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAccountButtonActionPerformed
        int selectedRow = accountTable.getSelectedRow();
        if (selectedRow >= 0) {
            Customer customer = getSelectedCustomer(selectedRow);
            if (customer != null) {
                bank.removeCustomer(customer);
                removeCustomerFromTable(selectedRow);
            }
        }
    }//GEN-LAST:event_removeAccountButtonActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
        setAccountButtonsActive(true);

        if (evt.getClickCount() == 2) {
            int selectedRow = accountTable.getSelectedRow();
            Customer customer = getSelectedCustomer(selectedRow);
            if (customer != null) {
                AccountDetailsPage page = new AccountDetailsPage(this, true, customer);
                page.setVisible(true);
            }
        }
    }//GEN-LAST:event_accountTableMouseClicked

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        if (saveLocation != null) {
            saveFile(saveLocation);
        } else {
            saveAsMenuItemActionPerformed(evt);
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new BofFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (!chooser.getSelectedFile().toString().toLowerCase().endsWith(".bof")) {
                JOptionPane.showMessageDialog(this, "Unsupported file type selected", "Unsupported File Type", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileInputStream fIn = new FileInputStream(chooser.getSelectedFile());
                    ObjectInputStream objIn = new ObjectInputStream(fIn);
                    Object bankData = objIn.readObject();
                    if (bankData instanceof Bank) {
                        bank = (Bank) bankData;
                        reloadTable();
                    }
                    saveLocation = chooser.getSelectedFile().toString();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainMenuClerk.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuClerk.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainMenuClerk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new BofFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String fileName = file.toString();
            if (!fileName.toLowerCase().endsWith(".bof")) {
                fileName += ".bof";

            }
            boolean saved = saveFile(fileName);
            if (saved) {
                saveLocation = fileName;
            }
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void reLoginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reLoginMenuItemActionPerformed
        LoginForm loginForm = new LoginForm(bank);
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reLoginMenuItemActionPerformed

    private void statsAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsAccountButtonActionPerformed
        Statistics statisticsForm = new Statistics(bank);
        statisticsForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_statsAccountButtonActionPerformed

    private void seatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatchButtonActionPerformed
        eraseTable();
        for(Customer c : bank.findCustomer(queryField.getText())){
            addCustomerToTable(c);
        }
        
    }//GEN-LAST:event_seatchButtonActionPerformed

    private boolean saveFile(String fileName) {
        try {
            FileOutputStream fOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(bank);
            objOut.close();
            fOut.close();
            return true;
        } 
        catch (FileNotFoundException ex) {
            return false;
        }
        catch (IOException ex) {
            return false;
        }
//        try {
//            File file = new File(fileName);
//            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // output pretty printed
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            jaxbMarshaller.marshal(bank, file);
//            jaxbMarshaller.marshal(bank, System.out);
//            return true;
//        }
//        catch (JAXBException e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    private Customer getSelectedCustomer(int selectedRow) {
        Customer customer = null;
        if (selectedRow >= 0) {
            int accountNumber = (int) accountTable.getValueAt(selectedRow, 2);
            customer = bank.getCustomerByAccountNumber(accountNumber);
        }

        return customer;
    }
    
    private void eraseTable() {
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        while(model.getRowCount() != 0) {
            model.removeRow(model.getRowCount()-1);
        }
    }

    private void addCustomerToTable(Customer customer) {
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.addRow(new Object[]{});
        reloadCustomerRowData(model.getRowCount() - 1, customer);
        //model.addRow(new Object[]{customer.getFirstName(), customer.getLastName(), customer.getAccount().getAccountNumber(), customer.getAccount().getBalance()});
    }

    private void removeCustomerFromTable(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.removeRow(selectedRow);
    }

    public void reloadTable() {
        for (Customer c : bank.getCustomers()) {
            addCustomerToTable(c);
        }
    }

    private void reloadCustomerRowData(int selectedRow, Customer customer) {
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.setValueAt(customer.getFirstName(), selectedRow, 0);
        model.setValueAt(customer.getLastName(), selectedRow, 1);
        model.setValueAt(customer.getAccount().getAccountNumber(), selectedRow, 2);
        model.setValueAt(String.format("%.2f", customer.getAccount().getBalance()), selectedRow, 3);
    }

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainMenu().setVisible(true);
//            }
//        });
//    }

    private void setAccountButtonsActive(boolean active) {
        //depositButton.setEnabled(active);
        //withdrawButton.setEnabled(active);
        removeAccountButton.setEnabled(active);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JTable accountTable;
    private javax.swing.JButton addAccountButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTextField queryField;
    private javax.swing.JMenuItem reLoginMenuItem;
    private javax.swing.JButton removeAccountButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton seatchButton;
    private javax.swing.JButton statsAccountButton;
    // End of variables declaration//GEN-END:variables

}