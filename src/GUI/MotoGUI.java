/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.ResultSet;
import DB.Connect;
import DB.Moto;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author NICK BA
 */
public class MotoGUI extends javax.swing.JFrame {

    
     ResultSet rs;
    ArrayList<Moto> TabM = new ArrayList<>();
   
    ArrayList<Moto> TabMBD = new ArrayList<>();
    
    public MotoGUI() {
        initComponents();
        if(Login.Admin==true){
              
          }else{
         
          jButton2.setEnabled(false);
          }
        
        Tableau();    
        Date d = new Date();
    SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");    
    String date = simple.format(d);
        jLabel1.setText(jLabel1.getText()+" le "+date);
         ProprioM.requestFocus();
     
    if(Vehicule.TabM!=null){
         TabM=copiageMoto(Vehicule.TabM);
         
    }     
        
        try {
            TabMBD = getMoto();
       
            TabM=copiageMoto(TabMBD);
           
        } catch (SQLException ex) {
            Logger.getLogger(MotoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

     public void Tableau(){    
        rs= Connect.Affichage("select Proprietaire,immatriculation,Marque,Couleur,Date_heure_Entree,Frais,Date_heure_Sortie from moto");
        Table.setModel(DbUtils.resultSetToTableModel(rs));
    }
     
     public void recherche(){
      
     String value =recherche.getText();    
        rs=Connect.Affichage("select Proprietaire,immatriculation,Marque,Couleur,Date_heure_Entree,Frais,Date_heure_Sortie from moto "
                + "where moto.marque like '%"+value+"%' or moto.immatriculation like'%"+value+"%' ");
        Table.setModel(DbUtils.resultSetToTableModel(rs));
    }
     
     public static ArrayList<Moto> getMoto() throws SQLException{ 
          
        ArrayList<Moto> t = new ArrayList<>();
         
        ResultSet r = null;
        Moto m1;
        
        String query ="select * from moto";
        
        r =Connect.Affichage(query);
        
        while(r.next()){
            
            m1 = new Moto(r.getString("Proprietaire"), r.getString("immatriculation"), r.getString("Marque"), r.getString("Couleur"), r.getString("Date_heure_Entree"),
            r.getInt("Frais"), r.getString("Date_heure_Sortie"),r.getLong("Duree") );
            
            t.add(m1);                 
          }      
            
        return t;
    }
      public static ArrayList<Moto> copiageMoto(ArrayList<Moto> m){
         
         ArrayList<Moto> t = new ArrayList<>();
               
         for(Moto moto: m){
             t.add(moto);
         }
         
         return t;
     }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        imM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        marqueM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        couleurM = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PrintArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ProprioM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        recherche = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/money.png"))); // NOI18N
        jButton4.setText("Payer");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete .png"))); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/printer (1).png"))); // NOI18N
        jButton3.setText("Imprimer");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Effacer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, -1, 40));
        jPanel1.add(imM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Marque");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));
        jPanel1.add(marqueM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 144, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Couleur");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));
        jPanel1.add(couleurM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 142, -1));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 860, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Liste des Motos Entrée");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 31, -1, -1));

        PrintArea.setColumns(20);
        PrintArea.setRows(5);
        jScrollPane2.setViewportView(PrintArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 290, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nom du Proprio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));
        jPanel1.add(ProprioM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nº Immatriculation");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        recherche.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        recherche.setPreferredSize(new java.awt.Dimension(6, 19));
        recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercheKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rechercheKeyTyped(evt);
            }
        });
        jPanel1.add(recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 520, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Recherche");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, -1, -1));

        jMenu1.setText("Naviguation");

        jMenuItem1.setText("Accueil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Enregistrement");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Voitures");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Camions");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
 int compt=0;
    for(int i=0; i<TabM.size(); i++){
        
        if(TabM.get(i).getFrais()==0 && TabM.get(i).getImmatriculation().equals(imM.getText()) && TabM.get(i).getProprietaire()==null ){
          
             TabM.get(i).Payer();
   
         PrintArea.setText(""+TabM.get(i).getDateS()+"\n");
     
         PrintArea.setText(PrintArea.getText()+"Sortie du Parking du "+TabM.get(i).getMarque()+"\n");
         
         PrintArea.setText(PrintArea.getText()+"- - - - - - - - - - -Paiement de "+TabM.get(i).getFrais()+"fbu - - - - - - - - - - -"+"\n");
         PrintArea.setText(PrintArea.getText()+"Merci de nous avoir fait confiance Mr/Mrs "+TabM.get(i).getProprietaire()+"\n");
        
         PrintArea.setText(PrintArea.getText()+"Vous avez passez "+TabM.get(i).getDuree()/60+" minutes"+"\n");       
           
        }else if(compt<1){       
            JOptionPane.showMessageDialog(this,"La Moto est déjà en ordre");
           compt++;
        }    
 }
    
   Tableau();
   
    ProprioM.setText(null);
    imM.setText(null);
    marqueM.setText(null);
    couleurM.setText(null);
  ProprioM.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

   int compt=0;
   
        if(imM.getText()!=null){
           
            for(int i=0 ; i<TabM.size();i++){
             
                if(TabM.get(i).getImmatriculation().equals(imM.getText())){
                    
                    TabM.get(i).setProprietaire(ProprioM.getText());
                    TabM.get(i).setImmatriculation(imM.getText());
                    TabM.get(i).setMarque(marqueM.getText());
                    TabM.get(i).setCouleur(couleurM.getText());
                    
                    TabM.get(i).Modification();
                }else{
                   
                   if(compt<1){
                      JOptionPane.showMessageDialog(this,"Echec de Modification");
                    compt++;
                   }
                    
               }                
            }        
        }
        
       Tableau();
            
            ProprioM.setText(null);
            imM.setText(null);
            marqueM.setText(null);
            couleurM.setText(null);
         
            ProprioM.requestFocus();
             
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
           String questions[]={"Oui","Non"};
        
 int res=JOptionPane.showOptionDialog(this,"Etes-vous sur de vouloir supprimer cette personne?","Avertissement",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,questions,questions[1]);
     
        
     if(res==0){
        if(imM.getText()!=null){
           
            for(int i=0; i<TabM.size();i++){
                
                if(TabM.get(i).getImmatriculation().equals(imM.getText())){
                    
                    TabM.get(i).Suppression();
                }
            }
            
            Tableau();
            JOptionPane.showMessageDialog(this,"Suppression avec success");
            
           ProprioM.setText(null); 
            imM.setText(null);
            marqueM.setText(null);
            couleurM.setText(null);
            
            ProprioM.requestFocus();

        }else{
            JOptionPane.showMessageDialog(this,"Erreur de Suppression");
        }
 
      }   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ProprioM.setText(null);
        imM.setText(null);
        marqueM.setText(null);
        couleurM.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked

       
        int row = Table.getSelectedRow();
        
        String p = (String) Table.getValueAt(row,0);
        String i= (String) Table.getValueAt(row,1);
        String m= (String) Table.getValueAt(row,2);
        String c= (String) Table.getValueAt(row,3);
        
               ProprioM.setText(p);
                 imM.setText(i);
               marqueM.setText(m);
               couleurM.setText(c);
    }//GEN-LAST:event_TableMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

this.dispose();
new Vehicule().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

this.dispose();       
new Login().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

this.dispose();
new VoitureGUI().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

this.dispose();
new CamionGUI().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   
           
     try {
        
        if(PrintArea.getText()!=null){
               
            PrintArea.print();
            
            PrintArea.setText(null);

           }else{
                 JOptionPane.showMessageDialog(null,"Créer d'abord la ligne à imprimer !!");          
             }
       
       } catch (PrinterException ex) {
            Logger.getLogger(VoitureGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheKeyReleased
        if(recherche.getText()==null){
            Tableau();
        }else{
            recherche();
        }

    }//GEN-LAST:event_rechercheKeyReleased

    private void rechercheKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheKeyTyped

    }//GEN-LAST:event_rechercheKeyTyped

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
            java.util.logging.Logger.getLogger(MotoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea PrintArea;
    private javax.swing.JTextField ProprioM;
    private javax.swing.JTable Table;
    private javax.swing.JTextField couleurM;
    private javax.swing.JTextField imM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField marqueM;
    private javax.swing.JTextField recherche;
    // End of variables declaration//GEN-END:variables
}
