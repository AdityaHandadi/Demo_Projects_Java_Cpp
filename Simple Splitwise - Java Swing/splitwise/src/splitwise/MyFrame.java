/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitwise;

import splitwise.dao.MyConnection;

/**
 *
 * @author adityahandadi
 */
public class MyFrame extends javax.swing.JFrame {
    
    public String groupName;
    public String message;
    public MyConnection myConnection;

    public MyFrame() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyConnection getMyConnection() {
        return myConnection;
    }

    public void setMyConnection(MyConnection myConnection) {
        this.myConnection = myConnection;
    }
    
    
    
    
}
