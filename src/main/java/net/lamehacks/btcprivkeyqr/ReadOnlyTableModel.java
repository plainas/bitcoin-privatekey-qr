
package net.lamehacks.btcprivkeyqr;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ReadOnlyTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
    public void setContents(ArrayList<String[]> listOfArrayRows){
        for (String[] row : listOfArrayRows) {
            this.addRow(row);
        }
    }
}
