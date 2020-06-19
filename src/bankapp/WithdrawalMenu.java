package bankapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WithdrawalMenu extends javax.swing.JDialog {

    private final Customer customer;

    public WithdrawalMenu(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.customer = customer;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        withdrawButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        amountLabel.setText("Withdrawal Amount");

        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(withdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(amountField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amountField, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(withdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        if(amountField.getText().trim().isEmpty()) {
            warnings.append("withdrawal amount is required\n");
        }
        else{
            double amount = 0;
            try {
                amount = Bank.round(Double.parseDouble(amountField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Withdraw $"+String.format("%.2f", amount)+" from the account?\nTransaction Fee: $"+String.format("%.2f", amount * 0.02)+"?\n");
                if(result == JOptionPane.OK_OPTION){
                    try {
                        customer.getAccount().withdraw(amount);
                        this.dispose();
                    } catch (InsufficientFundsException ex) {
                        warnings.append("Insufficient funds to complete transaction\n");
                    }
                    
                }
            }
            catch(NumberFormatException ex) {
                warnings.append("Withdrawal amount must be a number\n");
            }
        }
        if(warnings.length() > 0){
            JOptionPane.showMessageDialog(this, warnings.toString(), "Withdrawal Warnings", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
