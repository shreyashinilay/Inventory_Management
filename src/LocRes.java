
import DAO.ConnectionProvider;
import java.sql.Connection;
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
public class LocRes extends javax.swing.JFrame {
String loc;
    /**
     * Creates new form LocRes
     */
    public LocRes() {
        initComponents();
    }
    
    public LocRes(String l) {
        initComponents();
        loc=l;
        labLoc.setText(loc);
        
        try{
                
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                DefaultTableModel model=(DefaultTableModel) tableLoc.getModel();
                ResultSet rs=st.executeQuery("select * from equipment");
                
                int i=1; int f=0;
                while(rs.next()){
                    
                    
                    
                    if(loc.equalsIgnoreCase(rs.getString("loc")))
                        {
                            model.addRow(new Object[]{i++,rs.getString("eqID"),rs.getString("eqName")});
                            f=1;
//                        SN=rs.getInt("SN");
                        }
                    
                    else if(loc.contains("spare")&&loc.contains("tele"))
                    {
                        if(rs.getString("loc").contains("spare")&&rs.getString("loc").contains("tele"))
                        {
                            model.addRow(new Object[]{i++,rs.getString("eqID"),rs.getString("eqName")});
                            f=1;
//                        SN=rs.getInt("SN");
                        }
                    }
                     if(rs.getString("loc").substring(0,3).equalsIgnoreCase(loc.substring(0,3)))
                    {
                        model.addRow(new Object[]{i++,rs.getString("eqID"),rs.getString("eqName")});
                        f=1;
//                        SN=rs.getInt("SN");
                    }
                }
                if(f==0){
                    JOptionPane.showMessageDialog(null, "No equipments in this location");
                    setVisible(false);
                    new Equipment().setVisible(true);
                }    
//                SN=SN-i;
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
        labLoc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLoc = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setText("RESULTS FOR LOCATION:");

        labLoc.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N

        tableLoc.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tableLoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN", "Equipment ID", "Equipment Name"
            }
        ));
        tableLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLoc);

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addComponent(labLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(labLoc))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnBack))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLocMouseClicked
        int index=tableLoc.getSelectedRow();
        TableModel model= tableLoc.getModel();
//        String sn=model.getValueAt(index,0).toString();
        
        
        String id=model.getValueAt(index, 1).toString();
//        String name=model.getValueAt(index, 2).toString();
       
        setVisible(false);
        new SearchRes(id).setVisible(true);
    }//GEN-LAST:event_tableLocMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        new Equipment().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocRes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labLoc;
    private javax.swing.JTable tableLoc;
    // End of variables declaration//GEN-END:variables
}
