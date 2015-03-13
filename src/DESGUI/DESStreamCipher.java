/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DESGUI;

import DES.DES;
import static DES.DES.cutTo16Bytes;
import static DES.DES.hexStringToByteArray;
import static DES.DES.paddingZeroEachByte;
import static DES.DES.removePadding;
import static DES.DES.permute;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author moh.afifun.naily - 1106016802
 * @author haris.dwi - 1206239011
 */
public class DESStreamCipher extends javax.swing.JFrame {

    public File plaintextFile;
    public File ciphertextFile;
    public File keyEncriptFile;
    public File keyDecryptFile;
    public DES des;

    /**
     * Creates new form DESStreamChipher
     */
    public DESStreamCipher() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        EncryptionPanel = new javax.swing.JPanel();
        encryptionButton = new javax.swing.JButton();
        PlaintextLabel = new javax.swing.JLabel();
        KeyEncryptLabel = new javax.swing.JLabel();
        KeyEncryptButton = new javax.swing.JButton();
        plaintextButton = new javax.swing.JButton();
        copyrightLabelEnkripsi = new javax.swing.JLabel();
        DecryptionPanel = new javax.swing.JPanel();
        CiphertextLabel = new javax.swing.JLabel();
        keyDecryptLabel = new javax.swing.JLabel();
        ciphertextButton = new javax.swing.JButton();
        keyDecryptButton = new javax.swing.JButton();
        decryptionButton = new javax.swing.JButton();
        CopyrightLabelDekripsi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        encryptionButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        encryptionButton.setText("Encrypt");
        encryptionButton.setInheritsPopupMenu(true);
        encryptionButton.setName(""); // NOI18N
        encryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionButtonActionPerformed(evt);
            }
        });

        PlaintextLabel.setText("Input plaintext file");
        PlaintextLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KeyEncryptLabel.setText("Input key file");
        KeyEncryptLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KeyEncryptButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        KeyEncryptButton.setText("Input Key");
        KeyEncryptButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KeyEncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyEncryptButtonActionPerformed(evt);
            }
        });

        plaintextButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        plaintextButton.setText("Input Plaintext");
        plaintextButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        plaintextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plaintextButtonActionPerformed(evt);
            }
        });

        copyrightLabelEnkripsi.setText("@author : Moh. Afifun Naily & Haris Dwi Prakoso");

        javax.swing.GroupLayout EncryptionPanelLayout = new javax.swing.GroupLayout(EncryptionPanel);
        EncryptionPanel.setLayout(EncryptionPanelLayout);
        EncryptionPanelLayout.setHorizontalGroup(
            EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncryptionPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encryptionButton)
                    .addGroup(EncryptionPanelLayout.createSequentialGroup()
                        .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PlaintextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(KeyEncryptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(plaintextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KeyEncryptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(77, 77, 77))
            .addGroup(EncryptionPanelLayout.createSequentialGroup()
                .addComponent(copyrightLabelEnkripsi)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EncryptionPanelLayout.setVerticalGroup(
            EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncryptionPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlaintextLabel)
                    .addComponent(plaintextButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyEncryptLabel)
                    .addComponent(KeyEncryptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encryptionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(copyrightLabelEnkripsi))
        );

        jTabbedPane1.addTab("DES Encryption", EncryptionPanel);

        CiphertextLabel.setText("Input ciphertext file");
        CiphertextLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        keyDecryptLabel.setText("Input key file");
        keyDecryptLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ciphertextButton.setText("Input Ciphertext");
        ciphertextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciphertextButtonActionPerformed(evt);
            }
        });

        keyDecryptButton.setText("Input Key");
        keyDecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyDecryptButtonActionPerformed(evt);
            }
        });

        decryptionButton.setText("Decrypt");
        decryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionButtonActionPerformed(evt);
            }
        });

        CopyrightLabelDekripsi.setText("@author : Moh. Afifun Naily & Haris Dwi Prakoso");

        javax.swing.GroupLayout DecryptionPanelLayout = new javax.swing.GroupLayout(DecryptionPanel);
        DecryptionPanel.setLayout(DecryptionPanelLayout);
        DecryptionPanelLayout.setHorizontalGroup(
            DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptionPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decryptionButton)
                    .addGroup(DecryptionPanelLayout.createSequentialGroup()
                        .addGroup(DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CiphertextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(keyDecryptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ciphertextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(keyDecryptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(DecryptionPanelLayout.createSequentialGroup()
                .addComponent(CopyrightLabelDekripsi)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DecryptionPanelLayout.setVerticalGroup(
            DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptionPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CiphertextLabel)
                    .addComponent(ciphertextButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DecryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyDecryptLabel)
                    .addComponent(keyDecryptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decryptionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(CopyrightLabelDekripsi))
        );

        jTabbedPane1.addTab(" DES Decryption", DecryptionPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptionButtonActionPerformed
        Enkripsi(plaintextFile, keyEncriptFile);
    }//GEN-LAST:event_encryptionButtonActionPerformed

    private void plaintextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plaintextButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
//            FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
//            fc.setFileFilter(filter);
            File file = fc.getSelectedFile();
            if (file == null) {
                JOptionPane.showMessageDialog(this, "Tipe file harus berupa text file (.txt)", "Input Salah", JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = file.getAbsolutePath();
                PlaintextLabel.setText(filename);
                this.plaintextFile = file;
            }
        }
    }//GEN-LAST:event_plaintextButtonActionPerformed

    private void KeyEncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyEncryptButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
//            FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
//            fc.setFileFilter(filter);
            File file = fc.getSelectedFile();
            if (file == null) {
                JOptionPane.showMessageDialog(this, "Tipe file harus berupa text file (.txt)", "Input Salah", JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = file.getAbsolutePath();
                KeyEncryptLabel.setText(filename);
                this.keyEncriptFile = file;
            }
        }
    }//GEN-LAST:event_KeyEncryptButtonActionPerformed

    private void ciphertextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciphertextButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
//            FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
//            fc.setFileFilter(filter);
            File file = fc.getSelectedFile();
            if (file == null) {
                JOptionPane.showMessageDialog(this, "Tipe file harus berupa text file (.txt)", "Input Salah", JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = file.getAbsolutePath();
                CiphertextLabel.setText(filename);
                this.ciphertextFile = file;
            }
        }

    }//GEN-LAST:event_ciphertextButtonActionPerformed

    private void keyDecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyDecryptButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
//            FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
//            fc.setFileFilter(filter);
            File file = fc.getSelectedFile();
            if (file == null) {
                JOptionPane.showMessageDialog(this, "Tipe file harus berupa text file (.txt)", "Input Salah", JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = file.getAbsolutePath();
                keyDecryptLabel.setText(filename);
                this.keyDecryptFile = file;
            }
        }
    }//GEN-LAST:event_keyDecryptButtonActionPerformed

    private void decryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionButtonActionPerformed
        Dekripsi(ciphertextFile, keyDecryptFile);
    }//GEN-LAST:event_decryptionButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                DESStreamCipher window = new DESStreamCipher();
                window.setTitle("DES Application");
                window.setVisible(true);
            }
        });
    }
    
    public String getFileExtension(File file){
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") > 0)
        return fileName.substring(fileName.lastIndexOf("."));
        else return "";
    }

    public void Enkripsi(File text, File key) {
        String homedir = System.getProperty("user.home") + "/resultGui" + getFileExtension(text);
        doDES(text, key, homedir, 0);
    }

    public void Dekripsi(File text, File key) {
        String homedir = System.getProperty("user.home") + "/resultGui2" + getFileExtension(text);
        doDES(text, key, homedir, 1);
    }

    public void doDES(File file, File keyFile, String resultPath, int status) {
        // TODO add your handling code here:
        if (file == null && keyFile == null) {
            JOptionPane.showMessageDialog(this, "Input file belum lengkap", "Input belum lengkap", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Handle input key
        try {

            Path pathFile = Paths.get(file.getAbsolutePath());
            byte[] bytes = Files.readAllBytes(pathFile);
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02X", b));
                System.out.print(b);
            }
            System.out.println();

            String input = sb.toString();

            // inputBits will store the 64 bits of the input as a an int array of
            // size 64. This program uses int arrays to store bits, for the sake
            // of simplicity. For efficient programming, use long data type. But
            // it increases program complexity which is unnecessary for this
            // context.
            System.out.println(input);
            Stack<String> stk = cutTo16Bytes(input);
            Stack<int[]> inputBitsToProcess = new Stack();
            while (!stk.isEmpty()){
                    inputBitsToProcess.push(paddingZeroEachByte(stk.pop()));
                }
            
            // Similar process is followed for the 16 bit key
            System.out.println("Enter the key as a 16 character hexadecimal value:");
            FileReader fileReader = new FileReader(keyFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String key = bufferedReader.readLine();
            System.out.println(key);

            if (key.length() != 16) {
                JOptionPane.showMessageDialog(this, "Key harus berukuran 16 HEX", "Kesalahan panjang input key ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int keyBits[] = new int[64];
            for (int i = 0; i < 16; i++) {
                String s = Integer.toBinaryString(Integer.parseInt(key.charAt(i) + "", 16));
                while (s.length() < 4) {
                    s = "0" + s;
                }
                for (int j = 0; j < 4; j++) {
                    keyBits[(4 * i) + j] = Integer.parseInt(s.charAt(j) + "");
                }
            }
            
            if (status == 0){
                
                // permute(int[] inputBits, int[] keyBits, boolean isDecrypt)
                // method is used here. This allows encryption and decryption to be
                // done in the same method, reducing code.
                System.out.println("\n+++ ENCRYPTION +++");
                Stack<String> outputHexE = new Stack();
                while (!inputBitsToProcess.isEmpty()) {
                    outputHexE.push(permute(inputBitsToProcess.pop(), keyBits, false));
                }

                String eHex = "";
                while (!outputHexE.isEmpty()) {
                    eHex = eHex + outputHexE.pop();
                }
                
                System.out.println("encrypted hex : " + eHex);
                byte[] eb = hexStringToByteArray(eHex);
                Path path1 = Paths.get(resultPath);
                Files.write(path1, eb); //construct encrypted file
                JOptionPane.showMessageDialog(this, "Enkripsi telah selesai", "Finish", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                System.out.println("\n+++ DECRYPTION +++");
                Stack<String> outputHexD = new Stack();
                int[] x = inputBitsToProcess.peek();
                for (int i : x){
                    System.out.print(i);
                }
                System.out.println("");
                
                while (!inputBitsToProcess.isEmpty()){
                    outputHexD.push(permute(inputBitsToProcess.pop(), keyBits, true));
                }
                
                String dhex = "";
                System.out.println(outputHexD.peek());
                String temp = removePadding(outputHexD.pop());
                outputHexD.push(temp);
                while (!outputHexD.isEmpty()){
                    dhex = dhex + outputHexD.pop();
                }
                
                
                System.out.println("decrypted hex : " + dhex);
                byte[] b = hexStringToByteArray(dhex);
                
                
                Path path2 = Paths.get(resultPath);
                Files.write(path2, b); //creates, overwrites
                
                for (byte bt : b){
                    System.out.print(bt);
                }
                System.out.println();
                System.out.println(b[b.length-1]==bytes[bytes.length-1]);
                
                StringBuilder sb2 = new StringBuilder();
                    for (byte br : b) {
                        sb2.append(String.format("%02X", br));
                    }
                    System.out.println();
    
                System.out.println(sb2.toString());
                JOptionPane.showMessageDialog(this, "Dekripsi telah selesai", "Finish", JOptionPane.INFORMATION_MESSAGE);
            }
//            openFile(out1);
//            openFile(out2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openFile(File file) {
        if (!Desktop.isDesktopSupported()) {
            System.err.println("Desktop not supported");
        }

        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.EDIT)) {
            System.err.println("EDIT not supported");
        }

        try {
            desktop.edit(new File(file.getAbsolutePath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CiphertextLabel;
    private javax.swing.JLabel CopyrightLabelDekripsi;
    private javax.swing.JPanel DecryptionPanel;
    private javax.swing.JPanel EncryptionPanel;
    private javax.swing.JButton KeyEncryptButton;
    private javax.swing.JLabel KeyEncryptLabel;
    private javax.swing.JLabel PlaintextLabel;
    private javax.swing.JButton ciphertextButton;
    private javax.swing.JLabel copyrightLabelEnkripsi;
    private javax.swing.JButton decryptionButton;
    private javax.swing.JButton encryptionButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton keyDecryptButton;
    private javax.swing.JLabel keyDecryptLabel;
    private javax.swing.JButton plaintextButton;
    // End of variables declaration//GEN-END:variables
}
