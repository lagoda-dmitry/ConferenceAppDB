/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
/**
 *
 * @author senhe
 */
public class LoginPage implements ActionListener {
    HashMap<String,String> logininfo = new HashMap<String,String>(); 
    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo = loginInfoOriginal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 