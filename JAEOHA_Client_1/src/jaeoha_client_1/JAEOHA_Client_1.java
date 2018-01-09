/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaeoha_client_1;

import controllers.Controller_login;
import databaseclasses.Users;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.interfaces.ServerInterface;

/**
 *
 * @author esraa
 */
public class JAEOHA_Client_1 extends Application {
    
    Registry registry;
    Controller_login controller_login;
     ServerInterface serverRemoteObject;
    public JAEOHA_Client_1()
    {
        try {
            registry=LocateRegistry.getRegistry("127.0.0.1", 1099);
            serverRemoteObject=(ServerInterface) registry.lookup("chat");
            Users u=new Users();
            u.setActive(1);
            System.err.println(serverRemoteObject.signUp(u));
            
        } catch (RemoteException ex) {
            Logger.getLogger(JAEOHA_Client_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(JAEOHA_Client_1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    @Override
    public void start(Stage stage) throws Exception {
        
       FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/myViewFXML.fxml"));
       controller_login=new  Controller_login (serverRemoteObject);
       loader.setController(controller_login);
      // this.model.setController(controller);//make obj from clientimpl and register
       Parent root=loader.load();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
