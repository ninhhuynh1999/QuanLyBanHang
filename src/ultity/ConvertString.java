/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultity;

/**
 *
 * @author ninhh
 */
public class ConvertString {
   public  static int getNumbers(String s) {

    String[] n = s.split(""); //array of strings
    StringBuffer f = new StringBuffer(); // buffer to store numbers

    for (int i = 0; i < n.length; i++) {
        if((n[i].matches("[0-9]+"))) {// validating numbers
            f.append(n[i]); //appending
        }else {
            //parsing to int and returning value
            return Integer.parseInt(f.toString()); 
        }   
    }
    return 0;
 }
}
