/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import rmi.interfaces.ServerInterface;

/**
 *
 * @author esraa
 */
public class Controller_login implements Initializable{

    ServerInterface serverRemoteObject;
    public Controller_login( ServerInterface serverRemoteObject)
    {
        this.serverRemoteObject=serverRemoteObject;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    
    }
    
}
