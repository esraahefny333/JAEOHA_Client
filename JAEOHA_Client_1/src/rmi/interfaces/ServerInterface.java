/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.interfaces;

import databaseclasses.Users;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author esraa
 */
public interface ServerInterface extends Remote {

    public boolean signUp(Users user)throws RemoteException;
        
     public Vector<Users> myFriends(Users user)throws RemoteException;
    
    public Vector<Users> myFriendRequests(Users user)throws RemoteException;
    
}
