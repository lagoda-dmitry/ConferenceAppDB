
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author senhe
 */
public class IDAndPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDAndPasswords(){
        logininfo.put("Admin", "Alushta2022");
    }
    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
