/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaeoha_client_1;

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

    public JAEOHA_Client_1() {

        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            ServerInterface serverRemoteObject = (ServerInterface) registry.lookup("chat");

            System.out.println("client connected successfully");

            //check sign up 
//            Users u = new Users();
//            u.setUserName("abanoub samy saib");
//            u.setEmail("abanoubsamy333@yahoo.com");
//            u.setGender("male");
//            u.setPassword("121221");
//            
//            u=serverRemoteObject.signUp(u);
//            
//            if(u==null)
//            {
//                System.out.println("change email email is already exist");
//                
//            }
//            
//            else
//            {System.out.println(u.getUserName());
//                System.out.println(u.getActive());
//                
//            }
//check log in
            Users u2 = new Users();

            u2.setEmail("abanoubsamy567@yahoo.com");
            u2.setPassword("121221");
            u2 = serverRemoteObject.signIn(u2);
            if (u2 == null) {
                System.out.println("user ont exist u should sign up first");

            } else {
                System.out.println(u2.getId());
                System.out.println(u2.getUserName());
                System.out.println(u2.getActive());

            }

//check sign out
//if(serverRemoteObject.signOut(u2))
//{
//    System.out.println("signed out successfully");
//}
// change my status
//            System.out.println(u2.getStatus());
//            u2 = serverRemoteObject.changeMyStatus(u2, "available");
//
//            System.out.println(u2.getStatus());
            Users u = serverRemoteObject.selectByEmail("samy@hg367.com");

            if (u != null) {
                System.out.println(u.getUserName());
                System.out.println(u.getActive());

                boolean f = serverRemoteObject.checkRequestedOrNot(u2, u);
                if (f) {

                    System.out.println("requested");
                } else {
                    System.out.println("not requested add him");
                }

            } else {

                System.out.println("no users found");
            }

        } catch (Exception ex) {
            Logger.getLogger(JAEOHA_Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
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
