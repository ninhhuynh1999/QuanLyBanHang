/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ninhh
 */
public class NhaCungCapDTO {
    private int MaNCC;
    private String TenNCC;

    public NhaCungCapDTO() {
    }
    
      public NhaCungCapDTO(NhaCungCapDTO ncc) {
          this.MaNCC=ncc.getMaNCC();
          this.TenNCC=ncc.getTenNCC();
    }

    public NhaCungCapDTO(int MaNCC, String TenNCC) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }
    
    
}
