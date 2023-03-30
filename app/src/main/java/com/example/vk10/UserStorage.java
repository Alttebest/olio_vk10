package com.example.vk10;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage userstorage = null;

    private UserStorage(){
    }
    public static UserStorage getInstance(){
        if(userstorage == null){
            userstorage = new UserStorage();
        }
        return userstorage;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(int i){
        users.remove(i);
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Tallentaminen ei onnistunut");
        }
    }

    public void loadUsers(Context context){
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Lataaminen ei onnistunut");
        } catch (IOException e) {
            System.out.println("Lataaminen ei onnistunut");
        }

    }
}
