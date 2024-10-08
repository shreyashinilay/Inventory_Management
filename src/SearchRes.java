
import DAO.ConnectionProvider;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OPR
 */
public class SearchRes extends javax.swing.JFrame {
String URole;
String result;
int SN;
    /**
     * Creates new form SearchRes
     */
    public SearchRes() {
        initComponents();
        if(Home.URole.equals("Admin")){
            btnFinish.setVisible(false);
            btnUpdate.setVisible(false);
        }
        SN=0;
    }
    
    public SearchRes(String res){
        result=res;
        initComponents();
        SN=0;
        tableFails.setEnabled(false);
        labD.setVisible(false);
        btnFinish.setVisible(false);
            labF.setVisible(false);
            labR.setVisible(false);
            labC.setVisible(false);
            txtD.setVisible(false);
            txtF.setVisible(false);
            txtR.setVisible(false);
            txtC.setVisible(false);
            btnAddhis.setVisible(false);
            btnUpdhis.setVisible(false);
        if(Home.URole.equals("Admin")){
            labD.setVisible(false);
            labF.setVisible(false);
            labR.setVisible(false);
            labC.setVisible(false);
            txtD.setVisible(false);
            txtF.setVisible(false);
            txtR.setVisible(false);
            txtC.setVisible(false);
            btnAddhis.setVisible(false);
            btnUpdhis.setVisible(false);
            btnUpdate.setVisible(false);
        }
        try{
                
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from equipment");
                while(rs.next()){
                    String slno=rs.getString("slno");
                    String asset=rs.getString("ID");
                    String eq=rs.getString("eqID");
                    if(slno.equalsIgnoreCase(res)||asset.equalsIgnoreCase(res)||eq.equalsIgnoreCase(res)){
                        txtID.setText(rs.getString("eqID")); txtID.setEditable(false);
                        txtName.setText(rs.getString("eqName")); txtName.setEditable(false);
                        txtSlno.setText(rs.getString("slno")); txtSlno.setEditable(false);
                        txtAsset.setText(rs.getString("ID")); txtAsset.setEditable(false);
                        txtLoc.setText(rs.getString("loc")); txtLoc.setEditable(false);
                        txtFails.setText(rs.getString("fails")); txtFails.setEditable(false);
                        String srv=rs.getString("srvNo"); 
                        if (srv.equals(""))
                                txtSRV.setText("-");
                        else
                            txtSRV.setText(srv);
                        txtSRV.setEditable(false);  
                    } 
                }
                DefaultTableModel model=(DefaultTableModel) tableFails.getModel();
                rs=st.executeQuery("select * from historyCard");
                
                int i=1;
                while(rs.next()){
                    if(rs.getString("ID").equals(txtID.getText())){
                        model.addRow(new Object[]{i++,rs.getString("reportDate"),rs.getString("failedDate"),rs.getString("rectifiedDate"),rs.getString("correctiveActionRefNo")});
                        SN=rs.getInt("SN");
                    }
                }
                
                SN=SN-i;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLoc = new javax.swing.JTextField();
        txtSlno = new javax.swing.JTextField();
        txtAsset = new javax.swing.JTextField();
        txtSRV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFails = new javax.swing.JTable();
        txtFails = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labD = new javax.swing.JLabel();
        txtD = new javax.swing.JTextField();
        labF = new javax.swing.JLabel();
        txtF = new javax.swing.JTextField();
        labR = new javax.swing.JLabel();
        txtR = new javax.swing.JTextField();
        labC = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        btnAddhis = new javax.swing.JButton();
        btnUpdhis = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setText("EQUIPMENT DETAILS");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Equipment ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Serial No:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Equipment Name:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Asset ID:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Location:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Store Ref / SRV No:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("History card of the equipment (fails):");

        txtID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtLoc.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtSlno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSlno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSlnoActionPerformed(evt);
            }
        });

        txtAsset.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtSRV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        tableFails.setFont(new java.awt.Font("Times New Roman", 0, 16));
        tableFails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN", "Date", "Failed On", "Rectified On", "Corrective Action Reference No."
            }
        ));
        tableFails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableFailsMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tableFails);

        txtFails.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labD.setText("Date");

        txtD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        labF.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labF.setText("Failed On");

        txtF.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        labR.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labR.setText("Rectified On");

        txtR.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        labC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labC.setText("Corrective Action Reference No.");

        txtC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        btnAddhis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAddhis.setText("ADD history card");
        btnAddhis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddhisActionPerformed(evt);
            }
        });

        btnUpdhis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdhis.setText("UPDATE history card");
        btnUpdhis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdhisActionPerformed(evt);
            }
        });

        btnFinish.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnFinish.setText("FINISH");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(818, 818, 818))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFinish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFails, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtName)))
                                        .addGap(405, 405, 405)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSRV, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSlno, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAddhis)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdhis)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtC)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSlno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSRV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labD)
                    .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labF)
                    .addComponent(txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labR)
                    .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labC)
                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddhis)
                    .addComponent(btnUpdhis))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnBack)
                    .addComponent(btnFinish))
                .addGap(157, 157, 157))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtSlnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlnoActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        JOptionPane.showMessageDialog(null,"The fields are editable now!");
        tableFails.setEnabled(true);
        labD.setVisible(true);
            labF.setVisible(true);
            labR.setVisible(true);
            labC.setVisible(true);
            txtD.setVisible(true);
            txtF.setVisible(true);
            txtR.setVisible(true);
            txtC.setVisible(true);
            btnAddhis.setVisible(true);
            btnAddhis.setEnabled(true);
            btnUpdhis.setVisible(true);
            btnUpdhis.setEnabled(false);
        txtSRV.setEditable(true);
        txtName.setEditable(true);
        txtSlno.setEditable(true);
        txtAsset.setEditable(true);
        txtLoc.setEditable(true);
        txtFails.setEditable(true);
        btnFinish.setVisible(true);
        btnUpdate.setVisible(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        new Equipment().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdhisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdhisActionPerformed
        String date=txtD.getText();
        String failed=txtF.getText();
        String rect=txtR.getText();
        String act=txtC.getText();
        if(date.equals("")||failed.equals("")||rect.equals("")||act.equals("")){
            JOptionPane.showMessageDialog(null,"All fields are required!!!");
        }
        else{
            try{
                Connection con=ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("update historyCard set reportDate=?,failedDate=?,rectifiedDate=?,correctiveActionRefNo=? where SN=?");
                ps.setString(1,date);
                ps.setString(2,failed);
                ps.setString(3,rect);
                ps.setString(4,act);
                String sn=SN+"";
                ps.setString(5,sn);
               
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update successful!");
                setVisible(false);
                new SearchRes(result).setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnUpdhisActionPerformed

    private void tableFailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFailsMouseClicked
        int index=tableFails.getSelectedRow();
        TableModel model= tableFails.getModel();
        String id=model.getValueAt(index,0).toString();
        
        SN=SN+Integer.parseInt(id)+1;
        String date=model.getValueAt(index, 1).toString();
        String failed=model.getValueAt(index, 2).toString();
        String rect=model.getValueAt(index, 3).toString();
        String act=model.getValueAt(index, 4).toString();
        txtD.setText(date);
        txtF.setText(failed);
        txtR.setText(rect);
        txtC.setText(act);
        
        btnAddhis.setEnabled(false);
        btnUpdhis.setEnabled(true);
        
    }//GEN-LAST:event_tableFailsMouseClicked

    private void btnAddhisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddhisActionPerformed
        String date=txtD.getText();
        String failed=txtF.getText();
        String rect=txtR.getText();
        String act=txtC.getText();
        if(date.equals("")||failed.equals("")||rect.equals("")||act.equals("")){
            JOptionPane.showMessageDialog(null,"All fields are required!");
        }
        else{
            try{
                Connection con=ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("insert into historyCard (ID, reportDate, failedDate, rectifiedDate, correctiveActionRefNo) values (?,?,?,?,?)");
                ps.setString(1,txtID.getText());
                ps.setString(2,date);
                ps.setString(3,failed);
                ps.setString(4,rect);
                ps.setString(5,act);
                
                ps.executeUpdate();
                int i=Integer.parseInt(txtFails.getText());
                i++;
                PreparedStatement p=con.prepareStatement("update equipment set fails=? where eqID=?");
                p.setString(1,i+"");
                p.setString(2,result);
                
                JOptionPane.showMessageDialog(null,"History added successfully!");
                setVisible(false);
                new SearchRes(result).setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnAddhisActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        
    }//GEN-LAST:event_btnFinishActionPerformed

    private void tableFailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tableFailsMouseEntered

//    private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
//        DefaultTableModel model=(DefaultTableModel) tableFails.getModel();
//        try{
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select * from historyCard where ID='"+txtID);
//            int i=1;
//            while(rs.next()){
//                model.addRow(new Object[]{i++,rs.getString("date"),rs.getString("failedOn"),rs.getString("rectifiedOn"),rs.getString("correctiveActionRefNo")});
//            }
//        }
//         catch(Exception e){
//                JOptionPane.showMessageDialog(null,e);
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchRes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddhis;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdhis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labC;
    private javax.swing.JLabel labD;
    private javax.swing.JLabel labF;
    private javax.swing.JLabel labR;
    private javax.swing.JTable tableFails;
    private javax.swing.JTextField txtAsset;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtF;
    private javax.swing.JTextField txtFails;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLoc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtR;
    private javax.swing.JTextField txtSRV;
    private javax.swing.JTextField txtSlno;
    // End of variables declaration//GEN-END:variables
}
