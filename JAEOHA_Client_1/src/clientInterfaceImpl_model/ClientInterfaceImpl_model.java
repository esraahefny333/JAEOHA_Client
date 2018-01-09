/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientInterfaceImpl_model;

import controllers.Controller_login;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javafx.application.Platform;
import rmi.interfaces.ClientInterface;

/**
 *
 * @author esraa
 */
public class ClientInterfaceImpl_model extends UnicastRemoteObject implements ClientInterface{
   Controller_login controller_login;
    public ClientInterfaceImpl_model(Controller_login controller_login ) throws RemoteException
    {
        this.controller_login=controller_login;
    }
   

    
    
}


