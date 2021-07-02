package id.amalia.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by imastudio on 2/9/16.
 */
public class SessionManager {
    private static final String KEY_TOKEN = "tokenLogin";
    private static final String KEY_LOGIN = "isLogin";
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE =0;    Context c;

    //0 agar cuma bsa dibaca hp itu sendiri
    String PREF_NAME="OjekOnlinePref";

    //konstruktor
    public SessionManager(Context c){
        this.c = c;
        pref = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    //membuat session login
    public void createLoginSession(String token){
        editor.putString(KEY_TOKEN, token);
        editor.putBoolean(KEY_LOGIN, true);
        editor.commit();
        //commit digunakan untuk menyimpan perubahan
    }
    //mendapatkan token
    public String getToken(){
        return pref.getString(KEY_TOKEN, "");
    }
    //cek login
    public boolean isLogin(){
        return pref.getBoolean(KEY_LOGIN, false);
    }
    //logout user
    public void logout(){
        editor.clear();
        editor.commit();
    }

    /** Nama **/
    public void setNama(String nama){
        editor.putString("nama", nama);
        editor.commit();
    }
    public String getNama(){
        return pref.getString("nama", "");
    }

    /** Goldarah **/
    public void setGoldar(String goldar){
        editor.putString("goldar", goldar);
        editor.commit();
    }
    public String getGoldar(){
        return pref.getString("goldar", "");
    }


    /** Email **/
    public void setEmail(String email){
        editor.putString("email", email);
        editor.commit();
    }
    public String getEmail(){
        return pref.getString("email", "");
    }

    /** Phone **/
    public void setPhone(String phone){
        editor.putString("phone", phone);
        editor.commit();
    }
    public String getPhone(){
        return pref.getString("phone", "");
    }

//    /** ID **/
//    public void setIduser(String id_user){
//        editor.putString("id_user", id_user);
//        editor.commit();
//    }
//    public String getIdUser(){
//        return pref.getString("id_user", "");
//    }

    /** Alamat **/
    public void setAlamat(String user_alamat){
        editor.putString("user_alamat", user_alamat);
        editor.commit();
    }
    public String getAlamat(){
        return pref.getString("user_alamat", "");
    }


    /** ID 2 **/
    public void setId(String id_user){
        editor.putString("id_user", id_user);
        editor.commit();
    }
    public String getId(){
        return pref.getString("id_user", "");
    }
}
