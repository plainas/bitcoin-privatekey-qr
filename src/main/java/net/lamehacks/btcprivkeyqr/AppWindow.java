package net.lamehacks.btcprivkeyqr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.glxn.qrgen.QRCode;

public class AppWindow extends javax.swing.JFrame {

    AddessesDialog addessesDialog = new AddessesDialog(this, true);
    ViewQRCode viewQRCode = new ViewQRCode(this, true);

    public AppWindow() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BitcoinPrivatekeyQR");

        jLabel1.setFont(jLabel1.getFont());
        jLabel1.setText("Enter your private keys, one per line");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Show all QR codes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(jButton2.getFont());
        jButton2.setText("View addresses");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 420, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jButton2.getAccessibleContext().setAccessibleName("View addresses");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //TODO: move this stuff to its own class
        JDialog AllQRCodesWindow = new JDialog(this, true);
        JPanel jpanelContainer = new JPanel();
        jpanelContainer.setLayout(new BoxLayout(jpanelContainer, BoxLayout.PAGE_AXIS));

        String keysRawString = jTextArea1.getText();
        ArrayList<String[]> keyAddressPairs = WIFParser.parseWIFtext(keysRawString);

        for (String[] stringskeyAddressPair : keyAddressPairs) {
            try {
                File file = QRCode.from( stringskeyAddressPair[0]).withSize(200, 200).file();
                BufferedImage bufferedImage = ImageIO.read(file);
                JPanel singleAddressPanel = new JPanel();
                singleAddressPanel.setLayout(new BoxLayout(singleAddressPanel, BoxLayout.LINE_AXIS));
                singleAddressPanel.add(new JLabel(new ImageIcon(bufferedImage)));
                singleAddressPanel.add(new JLabel(stringskeyAddressPair[0]));
                jpanelContainer.add(singleAddressPanel);
            } catch (IOException e) {
                System.out.println("Error generating QR code");
            }
        }

        AllQRCodesWindow.getContentPane().add(jpanelContainer);
        AllQRCodesWindow.pack();
        AllQRCodesWindow.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String keysRawString = jTextArea1.getText();
        ArrayList<String[]> keyAddressPairs = WIFParser.parseWIFtext(keysRawString);

        ReadOnlyTableModel model = new ReadOnlyTableModel();
        model.setColumnIdentifiers(new String[]{"Private Key", "Address"});
        model.setContents(keyAddressPairs);

        addessesDialog.setTableModel(model);
        addessesDialog.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
