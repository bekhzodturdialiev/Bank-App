package bankapp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TransferMenu extends javax.swing.JDialog {

    private final Customer customer;
    private Bank bank;

    public TransferMenu(java.awt.Frame parent, boolean modal, Customer customer, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.customer = customer;
        this.bank = bank;
        initiateAccounts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        transferButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        accountLabel = new javax.swing.JLabel();
        accountField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        amountLabel.setText("Transfer Amount");

        transferButton.setText("Transfer");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        accountLabel.setText("Account ID to transfer");

        accountField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose an Account" }));
        accountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(amountField))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accountField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(accountField))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amountField, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transferButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void initiateAccounts() {
        ArrayList<Customer> customers = bank.getCustomers();
        
        for(Customer c : customers) {
            accountField.addItem(String.valueOf(c.getAccount().getAccountNumber()));
        }
        
    }
    
    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        //verify the deposit is not empty
        StringBuilder warnings = new StringBuilder();
        if(accountField.getSelectedItem().equals("Choose an Account")) {
            warnings.append("Account ID is required\n");
        }
        else if(amountField.getText().trim().isEmpty()) {
            warnings.append("Transfer amount is required\n");
        }
        else{
            //verify the deposit is a positive number
            double amount = 0;
            try {
                amount = Bank.round(Double.parseDouble(amountField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Transfer $"+String.format("%.2f", amount)+" to account number "+ accountField.getSelectedItem()+"?\nTransaction Fee: $"+String.format("%.2f", amount * 0.02)+"\n");
                //make the deposit
                Customer customerToTransfer = null;
                if(result == JOptionPane.OK_OPTION){
                    for(Customer c : bank.getCustomers()){
                        if(accountField.getSelectedItem().equals(String.valueOf(c.getAccount().getAccountNumber()))) {
                            customerToTransfer = c;
                        }
                    }
                    try {
                        customer.getAccount().transfer(amount, customerToTransfer);
                        this.dispose();
                    } catch (InvalidAmountException ex) {
                        warnings.append("Transfer amount is invalid\n");
                    } catch (InsufficientFundsException ex) {
                        warnings.append("Insufficient funds in balance\n");
                    }
                    
                }
            }
            catch(NumberFormatException ex) {
                warnings.append("Transfer amount must be a number\n");
            }
        }
        if(warnings.length() > 0){
            JOptionPane.showMessageDialog(this, warnings.toString(), "Transfer Warnings", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_transferButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void accountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountField;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton transferButton;
    // End of variables declaration//GEN-END:variables
}
