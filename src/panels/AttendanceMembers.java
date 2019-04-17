
package panels;



public class AttendanceMembers extends javax.swing.JPanel {


    public AttendanceMembers() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        allexpired_tbl = new javax.swing.JTable();

        allexpired_tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        allexpired_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        allexpired_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Firstname", "Lastname", "Start", "End"
            }
        ));
        allexpired_tbl.setToolTipText("");
        allexpired_tbl.setIntercellSpacing(new java.awt.Dimension(0, 0));
        allexpired_tbl.setOpaque(false);
        allexpired_tbl.setRowHeight(25);
        allexpired_tbl.setSelectionBackground(new java.awt.Color(0, 204, 51));
        allexpired_tbl.setShowVerticalLines(false);
        allexpired_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allexpired_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(allexpired_tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void allexpired_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allexpired_tblMouseClicked
//        renewal();
    }//GEN-LAST:event_allexpired_tblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allexpired_tbl;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
