package copypictures;

import java.awt.Desktop;
import java.awt.Rectangle;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CopyPictures_list extends javax.swing.JFrame {

    public CopyPictures_list() {

        initComponents();
        jProgressBar1.setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        picturesGroup = new javax.swing.ButtonGroup();
        listLabel = new javax.swing.JLabel();
        listTextField = new javax.swing.JTextField();
        listBrowseButton = new javax.swing.JButton();
        resolutionLabel = new javax.swing.JLabel();
        resolutionComboBox = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        outLabel = new javax.swing.JLabel();
        outTextCheckBox = new javax.swing.JCheckBox();
        outTextField = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        outItemComboBox = new javax.swing.JComboBox();
        jSeparator7 = new javax.swing.JSeparator();
        pictureNumberCheckBox = new javax.swing.JCheckBox();
        pictureTextCheckBox = new javax.swing.JCheckBox();
        outExampleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        listStartButton = new javax.swing.JButton();
        jRowCounterLabel = new javax.swing.JLabel();
        only_2RadioButton = new javax.swing.JRadioButton();
        allpictRadioButton = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pictures copy");
        setMinimumSize(new java.awt.Dimension(470, 350));
        setPreferredSize(new java.awt.Dimension(470, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listLabel.setText("List of items:");
        getContentPane().add(listLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 30));

        listTextField.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        listTextField.setToolTipText("Path to Excel list with items");
        getContentPane().add(listTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 215, 30));
        listTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }
            public void changed() {
                if (!listTextField.getText().equals("")){
                    listStartButton.setEnabled(true);
                }
                else {
                    listStartButton.setEnabled(false);
                }
            }
        });

        listBrowseButton.setText("Browse");
        listBrowseButton.setToolTipText("Click to browse Excel list with items");
        listBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBrowseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(listBrowseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 70, 30));

        resolutionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resolutionLabel.setText("Resolution:");
        getContentPane().add(resolutionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 21));

        resolutionComboBox.setMaximumRowCount(2);
        resolutionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HR", "LR" }));
        resolutionComboBox.setToolTipText("choose description between Item number, SAP number and EAN code");
        getContentPane().add(resolutionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 400, 10));

        outLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        outLabel.setText("Filename designer:");
        getContentPane().add(outLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 21));

        outTextCheckBox.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        outTextCheckBox.setSelected(true);
        outTextCheckBox.setText("text");
        outTextCheckBox.setToolTipText("add text info in filename");
        outTextCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outTextCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        outTextCheckBox.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        outTextCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        outTextCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outTextCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(outTextCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 20));

        outTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        outTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outTextField.setToolTipText("type text info in filename");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, resolutionComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem}"), outTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, outTextCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected}"), outTextField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        getContentPane().add(outTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, 30));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 5, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel2.setText("description");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, 18));

        outItemComboBox.setMaximumRowCount(4);
        outItemComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item", "SAP", "SAP_no dots", "EAN" }));
        outItemComboBox.setToolTipText("choose description between Item number, SAP (with or without dots) number and EAN code");
        outItemComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outItemComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(outItemComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 200, -1, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 5, 50));

        pictureNumberCheckBox.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        pictureNumberCheckBox.setSelected(true);
        pictureNumberCheckBox.setText("picture number");
        pictureNumberCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pictureNumberCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pictureNumberCheckBox.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pictureNumberCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, only_2RadioButton, org.jdesktop.beansbinding.ELProperty.create("${selected}"), pictureNumberCheckBox, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        pictureNumberCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pictureNumberCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(pictureNumberCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 100, -1));

        pictureTextCheckBox.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        pictureTextCheckBox.setText("_picture");
        pictureTextCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pictureTextCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pictureTextCheckBox.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pictureTextCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pictureTextCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pictureTextCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(pictureTextCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 100, -1));

        outExampleLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        outExampleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outExampleLabel.setText("Example:  HR_1003676_2.jpg");
        getContentPane().add(outExampleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 380, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 400, 10));

        listStartButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listStartButton.setText("START");
        listStartButton.setEnabled(false);
        listStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listStartButtonActionPerformed(evt);
            }
        });
        getContentPane().add(listStartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, 40));
        getContentPane().add(jRowCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, -1));

        picturesGroup.add(only_2RadioButton);
        only_2RadioButton.setSelected(true);
        only_2RadioButton.setText("Only \"Side view right angle\" picture (_2.jpg)");
        getContentPane().add(only_2RadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        picturesGroup.add(allpictRadioButton);
        allpictRadioButton.setText("All available pictures");
        allpictRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allpictRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(allpictRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 300, -1));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String mainfolder = "X:\\Smartwares - Product Content\\PRODUCTS";

    private void label(String sapNodot, String itemNo, String ean, Integer p, JFileChooser dest, File source) throws IOException {

        String sapWdot = sapNodot.substring(0, 2) + "." + sapNodot.substring(2, 5) + "." + sapNodot.substring(5, 7);

        String text = "";
        if (outTextCheckBox.isSelected()) {
            text = outTextField.getText() + "_";
        }

        String description = "";
        switch (outItemComboBox.getSelectedItem().toString()) {
            case "Item":
                description = itemNo;
                break;
            case "SAP":
                description = sapWdot;
                break;
            case "SAP_no dots":
                description = sapNodot;
                break;
            case "EAN":
                description = ean;
                break;
        }

        String pictureNumber = "";
        if (pictureNumberCheckBox.isSelected()) {
            pictureNumber = "_" + p;
        } else {
            pictureNumber = "";
        }

        String pictureText = "";
        if (pictureTextCheckBox.isSelected()) {
            pictureText = "_picture";
        } else {
            pictureText = "";
        }

        File subdir = dest.getSelectedFile();
        File output = new File(subdir + "\\" + text + description + pictureNumber + pictureText + ".jpg");

        if (!subdir.exists()) {
            subdir.mkdir();
        }

        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(output);
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        int i = 0;
        for (i = 0; i < 300; i++) {
            jProgressBar1.setValue(i);
            jProgressBar1.setName("Working...");
            Rectangle progressRect = jProgressBar1.getBounds();
            progressRect.x = 0;
            progressRect.y = 0;
            jProgressBar1.paintImmediately(progressRect);
        }
    }

    private void listBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBrowseButtonActionPerformed
        JFileChooser list = new JFileChooser();
        list.setDialogTitle("Select excel file with list");
        list.setFileSelectionMode(JFileChooser.FILES_ONLY);
        list.setFileFilter(new FileNameExtensionFilter(".xlsx", ".xls", "xls", "xlsx"));
        list.showOpenDialog(null);
        listTextField.setText(list.getSelectedFile().getPath());
    }//GEN-LAST:event_listBrowseButtonActionPerformed

    private void listStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listStartButtonActionPerformed
        List<String> noitem = new ArrayList<String>();
        try {
            JFileChooser dest = new JFileChooser();
            dest.setDialogTitle("Select destination folder");
            dest.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            dest.showSaveDialog(null);

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            String[][] Table = null;

            con = copypictures.Utils.getConnection();
            try {
                st = con.createStatement();

                String SQL = "SELECT sap,item,ean from elro.items;";
                rs = st.executeQuery(SQL);
                rs.last();
                int rowNumb = rs.getRow();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnS = rsmd.getColumnCount();
                rs.beforeFirst();
                Table = new String[rowNumb][columnS];
                int i = 0;
                int j = 0;
                while (rs.next() && i < rowNumb) {

                    for (j = 0; j < columnS; j++) {
                        Table[i][j] = (rs.getString(j + 1));
                    }
                    i++;

                }
                i = j = 0;

                String path = listTextField.getText();
                FileInputStream fis1 = null;
                fis1 = new FileInputStream(path);
                XSSFWorkbook wb = new XSSFWorkbook(fis1);
                XSSFSheet sheet = wb.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {

                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell = cellIterator.next();
                    String item = cell.getStringCellValue();
                    String sapNodot = item.replaceAll("\\s+", "").replace(".", "");
                    String itemNo = null;
                    String ean = null;
                    int ni = 0;

                    if (only_2RadioButton.isSelected()) {
                        int p = 2;
                        File source = new File(mainfolder + "\\" + sapNodot + "\\" + resolutionComboBox.getSelectedItem().toString() + "_" + sapNodot + "_" + p + ".jpg");
                        if (source.exists()) {

                            for (i = 0; i < Table.length; i++) {
                                if (Table[i][0].equals(item)) {
                                    itemNo = Table[i][1];
                                    itemNo = itemNo.replace("/", "_");
                                    ean = Table[i][2];
                                    label(sapNodot, itemNo, ean, p, dest, source);
                                } else {
                                    ni++;
                                }
                            }
                            if (ni == Table.length) {
                                itemNo = sapNodot;
                                ean = sapNodot;
                                label(sapNodot, itemNo, ean, p, dest, source);
                            }
                        } else {
                            noitem.add("\n" + sapNodot);
                        }
                    } else if (allpictRadioButton.isSelected()) {
                        for (int p = 1; p < 53; p++) {
                            if (p != 26 && p != 27 && p != 29 && p != 30) {
                                File source = new File(mainfolder + "\\" + sapNodot + "\\" + resolutionComboBox.getSelectedItem().toString() + "_" + sapNodot + "_" + p + ".jpg");
                                if (source.exists()) {

                                    for (i = 0; i < Table.length; i++) {
                                        if (Table[i][0].equals(item)) {
                                            itemNo = Table[i][1];
                                            itemNo = itemNo.replace("/", "_");
                                            ean = Table[i][2];
                                            label(sapNodot, itemNo, ean, p, dest, source);
                                        } else {
                                            ni++;
                                        }
                                    }
                                    if (ni == Table.length) {
                                        itemNo = sapNodot;
                                        ean = sapNodot;
                                        label(sapNodot, itemNo, ean, p, dest, source);
                                    }
                                } else {
                                    noitem.add("\n" + sapNodot);
                                }
                            }
                        }
                    }
                }
//                if (noitem.size() > 0) {
//                    JOptionPane.showMessageDialog(null, "No pictures for folowing items: " + noitem.toString(), "MISSING INFO", JOptionPane.ERROR_MESSAGE);
//                }
                jProgressBar1.setName("Finish");
                File subdir = new File(dest.getSelectedFile() + "\\");
                Desktop desktop = Desktop.getDesktop();
                desktop.open(subdir);
            } catch (SQLException ex) {
                Logger.getLogger(CopyPictures_list.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                copypictures.Utils.closeDB(rs, st, con);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopyPictures_list.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopyPictures_list.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listStartButtonActionPerformed

    private void outItemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outItemComboBoxActionPerformed
        String text = "";
        if (outTextCheckBox.isSelected()) {
            text = resolutionComboBox.getSelectedItem().toString() + "_";
        }
        String description = "";
        switch (outItemComboBox.getSelectedIndex()) {
            case 0:
                description = "HL120";
                break;
            case 1:
                description = "10.036.76";
                break;
            case 2:
                description = "1003676";
                break;
            case 3:
                description = "8711658257747";
                break;
        }
        String pictureNumber = "";
        if (pictureNumberCheckBox.isSelected()) {
            pictureNumber = "_2";
        }
        String pictureText = "";
        if (pictureTextCheckBox.isSelected()) {
            pictureText = "_picture";
        }
        outExampleLabel.setText("Example:   " + text + description + pictureNumber + pictureText + ".jpg");
    }//GEN-LAST:event_outItemComboBoxActionPerformed

    private void outTextCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outTextCheckBoxActionPerformed
        String text = "";
        if (outTextCheckBox.isSelected()) {
            text = resolutionComboBox.getSelectedItem().toString() + "_";
        }
        String description = "";
        switch (outItemComboBox.getSelectedIndex()) {
            case 0:
                description = "HL120";
                break;
            case 1:
                description = "10.036.76";
                break;
            case 2:
                description = "1003676";
                break;
            case 3:
                description = "8711658257747";
                break;
        }
        String pictureNumber = "";
        if (pictureNumberCheckBox.isSelected()) {
            pictureNumber = "_2";
        }
        String pictureText = "";
        if (pictureTextCheckBox.isSelected()) {
            pictureText = "_picture";
        }
        outExampleLabel.setText("Example:   " + text + description + pictureNumber + pictureText + ".jpg");
    }//GEN-LAST:event_outTextCheckBoxActionPerformed

    private void pictureNumberCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pictureNumberCheckBoxActionPerformed
        String text = "";
        if (outTextCheckBox.isSelected()) {
            text = resolutionComboBox.getSelectedItem().toString() + "_";
        }

        String description = "";
        switch (outItemComboBox.getSelectedIndex()) {
            case 0:
                description = "HL120";
                break;
            case 1:
                description = "10.036.76";
                break;
            case 2:
                description = "1003676";
                break;
            case 3:
                description = "8711658257747";
                break;
        }
        String pictureNumber = "";
        if (pictureNumberCheckBox.isSelected()) {
            pictureNumber = "_2";
        }
        String pictureText = "";
        if (pictureTextCheckBox.isSelected()) {
            pictureText = "_picture";
        }
        outExampleLabel.setText("Example:   " + text + description + pictureNumber + pictureText + ".jpg");
    }//GEN-LAST:event_pictureNumberCheckBoxActionPerformed

    private void allpictRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allpictRadioButtonActionPerformed
        if (allpictRadioButton.isSelected()) {
            pictureNumberCheckBox.setSelected(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_allpictRadioButtonActionPerformed

    private void pictureTextCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pictureTextCheckBoxActionPerformed
        String text = "";
        if (outTextCheckBox.isSelected()) {
            text = resolutionComboBox.getSelectedItem().toString() + "_";
        }

        String description = "";
        switch (outItemComboBox.getSelectedIndex()) {
            case 0:
                description = "HL120";
                break;
            case 1:
                description = "10.036.76";
                break;
            case 2:
                description = "1003676";
                break;
            case 3:
                description = "8711658257747";
                break;
        }
        String pictureNumber = "";
        if (pictureNumberCheckBox.isSelected()) {
            pictureNumber = "_2";
        }
        String pictureText = "";
        if (pictureTextCheckBox.isSelected()) {
            pictureText = "_picture";
        }
        outExampleLabel.setText("Example:   " + text + description + pictureNumber + pictureText + ".jpg");
    }//GEN-LAST:event_pictureTextCheckBoxActionPerformed

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(CopyPictures_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CopyPictures_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CopyPictures_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CopyPictures_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CopyPictures_list().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allpictRadioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel jRowCounterLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton listBrowseButton;
    private javax.swing.JLabel listLabel;
    private javax.swing.JButton listStartButton;
    private javax.swing.JTextField listTextField;
    private javax.swing.JRadioButton only_2RadioButton;
    private javax.swing.JLabel outExampleLabel;
    private javax.swing.JComboBox outItemComboBox;
    private javax.swing.JLabel outLabel;
    private javax.swing.JCheckBox outTextCheckBox;
    private javax.swing.JTextField outTextField;
    private javax.swing.JCheckBox pictureNumberCheckBox;
    private javax.swing.JCheckBox pictureTextCheckBox;
    private javax.swing.ButtonGroup picturesGroup;
    private javax.swing.JComboBox resolutionComboBox;
    private javax.swing.JLabel resolutionLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
