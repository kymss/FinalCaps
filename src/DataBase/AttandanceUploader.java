/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author User1
 */
public class AttandanceUploader {
    
    private static AttandanceUploader instance = null;    
      public static AttandanceUploader getInstance() {
      if(instance == null) {
         instance = new AttandanceUploader();
      }
      return instance;
    }
    
}
