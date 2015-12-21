/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitwise;

/**
 *
 * @author adityahandadi
 */
public class Expense {
    
    private String spentBy;
    private Double amount;
    private String splitWith;
    private String groupName;

    public Expense() {
    }

    public Expense(String spentBy, Double amount, String splitWith, String groupName) {
        this.spentBy = spentBy;
        this.amount = amount;
        this.splitWith = splitWith;
        this.groupName = groupName;
    }

    public String getSpentBy() {
        return spentBy;
    }

    public void setSpentBy(String spentBy) {
        this.spentBy = spentBy;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSplitWith() {
        return splitWith;
    }

    public void setSplitWith(String splitWith) {
        this.splitWith = splitWith;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    
    
}
