package bankapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DepositMenu extends javax.swing.JDialog {

    private final Customer customer;

    public DepositMenu(java.awt.Frame parent, boolean modal, Customer customer) {
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
        depositButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        amountLabel.setText("Deposit Amount");

        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
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
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(depositButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
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
                    .addComponent(depositButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        //verify the deposit is not empty
        StringBuilder warnings = new StringBuilder();
        if(amountField.getText().trim().isEmpty()) {
            warnings.append("Deposit amount is required\n");
        }
        else{
            //verify the deposit is a positive number
            double amount = 0;
            try {
                amount = Bank.round(Double.parseDouble(amountField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Deposit "+String.format("%.2f", amount)+" to this account?\nInterest Earned: $"+String.format("%.2f", customer.getAccount().getInterest())+"\n");
                //make the deposit
                if(result == JOptionPane.OK_OPTION){
                    try {
                        customer.getAccount().deposit(amount);
                        this.dispose();
                    } catch (InvalidAmountException ex) {
                        warnings.append("Deposit amount is invalid\n");
                    }
                    
                }
            }
            catch(NumberFormatException ex) {
                warnings.append("Deposit amount must be a number\n");
            }
        }
        if(warnings.length() > 0){
            JOptionPane.showMessageDialog(this, warnings.toString(), "Deposit Warnings", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_depositButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton depositButton;
    // End of variables declaration//GEN-END:variables
}
