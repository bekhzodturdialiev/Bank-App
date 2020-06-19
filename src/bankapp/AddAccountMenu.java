package bankapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Shaxzod
 */
public class AddAccountMenu extends javax.swing.JDialog {
    
    private Bank bank;
    private Customer customer;
    /**
     * Creates new form AddAccountMenu
     */
    public AddAccountMenu(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        customer = null;
        
    }

    Customer getCustomer() {
        return customer;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        ssnLabel = new javax.swing.JLabel();
        ssnField = new javax.swing.JTextField();
        depositLabel = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        passwordText = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account Menu");

        firstNameLabel.setText("First Name:");
        firstNameLabel.setMaximumSize(new java.awt.Dimension(174, 40));
        firstNameLabel.setMinimumSize(new java.awt.Dimension(174, 40));
        firstNameLabel.setPreferredSize(new java.awt.Dimension(174, 40));

        firstNameField.setMaximumSize(new java.awt.Dimension(174, 40));
        firstNameField.setMinimumSize(new java.awt.Dimension(174, 40));
        firstNameField.setPreferredSize(new java.awt.Dimension(174, 40));

        lastNameLabel.setText("Last Name:");
        lastNameLabel.setMaximumSize(new java.awt.Dimension(174, 40));
        lastNameLabel.setMinimumSize(new java.awt.Dimension(174, 40));
        lastNameLabel.setPreferredSize(new java.awt.Dimension(174, 40));

        lastNameField.setMaximumSize(new java.awt.Dimension(174, 40));
        lastNameField.setMinimumSize(new java.awt.Dimension(174, 40));
        lastNameField.setPreferredSize(new java.awt.Dimension(174, 40));

        ssnLabel.setText("Social Security Number:");
        ssnLabel.setMaximumSize(new java.awt.Dimension(174, 40));
        ssnLabel.setMinimumSize(new java.awt.Dimension(174, 40));
        ssnLabel.setPreferredSize(new java.awt.Dimension(174, 40));

        ssnField.setMaximumSize(new java.awt.Dimension(174, 40));
        ssnField.setMinimumSize(new java.awt.Dimension(174, 40));
        ssnField.setPreferredSize(new java.awt.Dimension(174, 40));

        depositLabel.setText("Initial Deposit:");
        depositLabel.setMaximumSize(new java.awt.Dimension(174, 40));
        depositLabel.setMinimumSize(new java.awt.Dimension(174, 40));
        depositLabel.setPreferredSize(new java.awt.Dimension(174, 40));

        depositField.setMaximumSize(new java.awt.Dimension(174, 40));
        depositField.setMinimumSize(new java.awt.Dimension(174, 40));
        depositField.setPreferredSize(new java.awt.Dimension(174, 40));

        typeLabel.setText("Account Type:");
        typeLabel.setMaximumSize(new java.awt.Dimension(174, 40));
        typeLabel.setMinimumSize(new java.awt.Dimension(174, 40));
        typeLabel.setPreferredSize(new java.awt.Dimension(174, 40));

        typeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Checking", "Savings", "Credit" }));
        typeField.setMaximumSize(new java.awt.Dimension(174, 40));
        typeField.setMinimumSize(new java.awt.Dimension(174, 40));
        typeField.setPreferredSize(new java.awt.Dimension(174, 40));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        passwordText.setText("Password");
        passwordText.setMaximumSize(new java.awt.Dimension(174, 40));
        passwordText.setMinimumSize(new java.awt.Dimension(174, 40));
        passwordText.setPreferredSize(new java.awt.Dimension(174, 40));

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(passwordText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(depositLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ssnLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeField, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(depositField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ssnField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(depositField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        String firstName = "", lastName = "", password = "", ssn = "", depositString = "";
        double amount = 0;
        //verify all the fields
        if(firstNameField.getText().isEmpty()) {
            warnings.append("First name must not be empty!\n");
        }
        else if(!firstNameField.getText().trim().matches("([A-Za-z\\s?])+")) {
            warnings.append("First name must contain only letters or dash!\n");
        }
        else {
            firstName = firstNameField.getText();
        }
        
        if(lastNameField.getText().isEmpty()) {
            warnings.append("Last name must not be empty!\n");
        }
        else if(!lastNameField.getText().trim().matches("([A-Za-z\\s?])+")) {
            warnings.append("Last name must contain only letters or dash!\n");
        }
        else {
            lastName = lastNameField.getText();
        }
        
        if(String.valueOf(passwordField.getPassword()).isEmpty()) {
            warnings.append("Password field must not be empty!\n");
        }
        else if(String.valueOf(passwordField.getPassword()).length() < 6 || String.valueOf(passwordField.getPassword()).length() > 16) {
            warnings.append("Password length must be between 6 and 16!\n");
        }
        else if(!String.valueOf(passwordField.getPassword()).trim().matches("(?=^.{6,16}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s)[0-9a-zA-Z!@#$%^&*()]*$")) {
            warnings.append("Password must contain one uppercase, one lowercase letter and one number at least!\n");
        }
        else {
            password = String.valueOf(passwordField.getPassword());
        }
        
        if(!ssnField.getText().matches("\\d+")) {
            warnings.append("Social Security Number must be a number!\n");
        }
        if(ssnField.getText().trim().isEmpty()) {
            warnings.append("SSN must not be empty!\n");
        }
        else if(!ssnField.getText().matches("(\\d){9}")) {
            warnings.append("Social Security Number must be 9 numbers!\n");
        }
        else {
            ssn = ssnField.getText().replace("-", "");
        }
        
        if(depositField.getText().isEmpty()) {
            warnings.append("Initial deposit must be entered!\n");
        }
        else{
            try {
                amount = Bank.round(Double.parseDouble(depositField.getText()), 2);
            }
            catch(NumberFormatException ex) {
                warnings.append("Deposit must be a number!\n");
            }
        }
        if(warnings.length() > 0){
            JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //JOptionPane.showMessageDialog(this, firstName + "\n" + lastName + "\n" + ssn + "\n" + amount);
            Account account = null;
            if(typeField.getSelectedItem().toString() == "Checking") {
                if(amount >= 100) {
                    account = new Checking(amount);
                }
                else{
                    warnings.append("Initial deposit must be at least $100 for Checking accounts");
                }
                
            }
            else if(typeField.getSelectedItem().toString() == "Savings") {
                if(amount >= 100) {
                    account = new Savings(amount);
                }
                else{
                    warnings.append("Initial deposit must be at least $50 for Savings accounts");
                }
            }
            else if(typeField.getSelectedItem().toString() == "Credit") {
                if(amount > 1000) {
                    account = new Credit(amount);
                }
                else{
                    warnings.append("Credit amount must be greater then $1000");
                }
            }
            if(account != null){
                customer = new Customer(firstName, lastName, password, ssn, account);
                bank.addCustomer(customer);
            }
            else{
                JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warning", JOptionPane.WARNING_MESSAGE);
            }
            
            this.dispose();
        }

        //create an account
    }//GEN-LAST:event_okButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordText;
    private javax.swing.JTextField ssnField;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JComboBox<String> typeField;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    
}
