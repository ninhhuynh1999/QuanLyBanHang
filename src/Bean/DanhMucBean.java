/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ninhh
 */
public class DanhMucBean {
    private String kind;
    private JPanel pn;
    private JLabel lb;

    public DanhMucBean(String kind, JPanel pn, JLabel lb) {
        this.kind = kind;
        this.pn = pn;
        this.lb = lb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getPn() {
        return pn;
    }

    public void setPn(JPanel pn) {
        this.pn = pn;
    }

    public JLabel getLb() {
        return lb;
    }

    public void setLb(JLabel lb) {
        this.lb = lb;
    }
    
}
