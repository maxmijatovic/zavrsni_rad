/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import maxmijatovic.jp21zavrsni.controller.ObradaBirdCount;
import maxmijatovic.jp21zavrsni.controller.ObradaParticipant;
import maxmijatovic.jp21zavrsni.controller.ObradaSite;
import maxmijatovic.jp21zavrsni.controller.ObradaSpecies;
import maxmijatovic.jp21zavrsni.model.BirdCount;
import maxmijatovic.jp21zavrsni.model.Counter;
import maxmijatovic.jp21zavrsni.model.Participant;
import maxmijatovic.jp21zavrsni.model.Site;
import maxmijatovic.jp21zavrsni.model.Species;
import maxmijatovic.jp21zavrsni.util.BirdCounterException;
import maxmijatovic.jp21zavrsni.util.Pomocno;

/**
 *
 * @author Alice
 */
public class ViewBirdCount extends javax.swing.JFrame {
    
    private final ObradaBirdCount obrada;
   
    

    /**
     * Creates new form ViewBirdCount
     */
    public ViewBirdCount() {
        initComponents();
        obrada = new ObradaBirdCount();
        postInitComponents();
        ucitajSite();
        ucitajParticipant();
        ucitajSpecies();
        ucitaj();
        DatePickerSettings dps = new DatePickerSettings(new Locale("en", "GB"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy.");
        dpDate.setSettings(dps);
        
    }
    
    private void postInitComponents() {
        setTitle("BirdCounts - " + Pomocno.LOGIRAN.getSurname());
        ucitaj();
    }
    
    private void ucitaj() {
        DefaultListModel<BirdCount> m = new DefaultListModel<>();
        obrada.getPodaci().forEach(s -> m.addElement(s));
        lstPodaci.setModel(m);
    }
    
    private void ucitajVrijednosti(){
        obrada.getEntitet().setName(txtName.getText());
        obrada.getEntitet().setCoverage(txtCoverage.getText());
        obrada.getEntitet().setWeather(txtWeather.getText());
        obrada.getEntitet().setWater(txtWater.getText());
        obrada.getEntitet().setIce(txtIce.getText());
        
        
        if(dpDate.getDate()!=null){
            Date d = Pomocno.convertToDateViaInstant(dpDate.getDate());
            obrada.getEntitet().setDate(d);
        }
        
        
        
        obrada.getEntitet().setSite(cmbSite.getModel()
                .getElementAt(cmbSite.getSelectedIndex()));
        
        obrada.getEntitet().setParticipant(cmbParticipant.getModel()
                .getElementAt(cmbParticipant.getSelectedIndex()));
        
       
        
                
        
        try {
            DefaultListModel<Counter> m = (DefaultListModel<Counter>)lstSpeciesInCount.getModel();
            obrada.getEntitet().getCounters();
            for(int i=0;i<m.getSize();i++){
                obrada.getEntitet().getCounters().add(m.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
        
        
        
        
    }
    
    private void postaviVrijednosti(){
        txtName.setText(obrada.getEntitet().getName());
        txtCoverage.setText(obrada.getEntitet().getCoverage());
        txtWeather.setText(obrada.getEntitet().getWeather());
        txtWater.setText(obrada.getEntitet().getWater());
        txtIce.setText(obrada.getEntitet().getIce());
        
        if(obrada.getEntitet().getDate()==null){
            dpDate.setDate(null);
        }else{
            dpDate.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getDate()));
        }
        
        postaviSite();
        postaviParticipant();
        postaviSpecies();
        postaviCounter();
        
        
        
    }
    
    private void ucitajSite(){
        DefaultComboBoxModel<Site> m = new DefaultComboBoxModel<>();
        new ObradaSite().getPodaci().forEach(s -> m.addElement(s));
        cmbSite.setModel(m);
        
    }
    
    private void ucitajParticipant(){
        DefaultComboBoxModel<Participant> m = new DefaultComboBoxModel<>();
        new ObradaParticipant().getPodaci().forEach(p -> m.addElement(p));
        cmbParticipant.setModel(m);
    }
    
    private void ucitajSpecies(){
        DefaultComboBoxModel<Species> m = new DefaultComboBoxModel<>();
        new ObradaSpecies().getPodaci().forEach(s-> m.addElement(s));
        cmbSpecies.setModel(m);
    }
    
        
   
                
    private void postaviSite(){
        
         ComboBoxModel<Site> m = cmbSite.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getId().equals(
                    obrada.getEntitet().getSite().getId())){
                cmbSite.setSelectedIndex(i);
                break;
            }
        }
        
    }
    
    private void postaviParticipant(){
        
        for(int i=0;i<cmbParticipant.getModel().getSize();i++){
            if(cmbParticipant.getModel().getElementAt(i).getId().equals(
                    obrada.getEntitet().getParticipant().getId())){
                cmbParticipant.setSelectedIndex(i);
                break;
            }
        }
        
    }
    
    private void postaviSpecies(){
        for(int i=0;i<cmbSpecies.getModel().getSize();i++){
            if(cmbSpecies.getModel().getElementAt(i).getId().equals(
                    obrada.getEntitet().getParticipant().getId())){
                cmbSpecies.setSelectedIndex(i);
                break;
            }
        }
        
    }
    
        
    private void postaviCounter() {
      DefaultListModel<Counter> m = new DefaultListModel<>();
      obrada.getEntitet().getCounters().forEach(c->{m.addElement(c);});
      lstSpeciesInCount.setModel(m);
    }
    
  
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnCreateNew = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSite = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbParticipant = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbSpecies = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNumberOfBirds = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCoverage = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtWeather = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtWater = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIce = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSpeciesInCount = new javax.swing.JList<>();
        btnDodajSpecies = new javax.swing.JButton();
        dpDate = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnCreateNew.setText("Create New");
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Date");

        jLabel3.setText("Site");

        jLabel4.setText("Participant");

        jLabel6.setText("Species");

        jLabel7.setText("Number of Birds");

        jLabel8.setText("Coverage");

        jLabel9.setText("Weather");

        jLabel10.setText("Water");

        jLabel11.setText("Ice");

        jScrollPane2.setViewportView(lstSpeciesInCount);

        btnDodajSpecies.setText("Add Birds");
        btnDodajSpecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajSpeciesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(txtCoverage, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtWater, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIce)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(cmbSite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtWeather, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbParticipant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDodajSpecies)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNumberOfBirds)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumberOfBirds)
                            .addComponent(dpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtCoverage))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtWeather, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtWater)
                                    .addComponent(txtIce))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnDodajSpecies)
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
      if(evt.getValueIsAdjusting()) {
          return;
      }
      obrada.setEntitet(lstPodaci.getSelectedValue());
      if(obrada.getEntitet() == null) {
          return;
      }
      
     postaviVrijednosti();
     
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        try {
            obrada.setEntitet(new BirdCount());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (BirdCounterException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnCreateNewActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Please, first select the item.");
            return;
        }

        ucitajVrijednosti();
        try {
            obrada.update();
            ucitaj();
        } catch (BirdCounterException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Please, first select the item.");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (BirdCounterException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDodajSpeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajSpeciesActionPerformed
     //prvo dohvatiti model liste Counter
     
    if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Please, first select the item.");
            return;
        }
     
    DefaultListModel<Counter> m = (DefaultListModel<Counter>) lstSpeciesInCount.getModel();
     
          
              
    Counter c = new Counter();
    c.setSpecies((Species)cmbSpecies.getSelectedItem());
    c.setBirdCount(obrada.getEntitet());
    c.setNumberOfBirds(Integer.parseInt(txtNumberOfBirds.getText()));
    
    
     try {
             m = (DefaultListModel<Counter>) lstSpeciesInCount.getModel();
            } catch (Exception e) {
                m = new DefaultListModel<>();
                lstSpeciesInCount.setModel(m);
            }  
    
   
    m.addElement(c);
    
   
   
    
   
    
    
     //na dohvaceni model dodati Counter
     
    }//GEN-LAST:event_btnDodajSpeciesActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDodajSpecies;
    private javax.swing.JComboBox<Participant> cmbParticipant;
    private javax.swing.JComboBox<Site> cmbSite;
    private javax.swing.JComboBox<Species> cmbSpecies;
    private com.github.lgooddatepicker.components.DatePicker dpDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<BirdCount> lstPodaci;
    private javax.swing.JList<Counter> lstSpeciesInCount;
    private javax.swing.JTextField txtCoverage;
    private javax.swing.JTextField txtIce;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberOfBirds;
    private javax.swing.JTextField txtWater;
    private javax.swing.JTextField txtWeather;
    // End of variables declaration//GEN-END:variables

   
}
