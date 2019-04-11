package ru.wkn.repository.service;

import ru.wkn.entities.User;
import ru.wkn.repository.IDao;
import ru.wkn.repository.dao.h2.UserH2Dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService extends Service<User, Integer> {

    public UserService(IDao<User, Integer> iDao) {
        super(iDao);
    }

    public User logIn(String login, String password) {
        return ((UserH2Dao) super.getDao()).logIn(login, password);
    }

    public String registryCookie(String fullName, String login, String password) {
        byte[] startMessage = fullName.concat(login).concat(password).getBytes();
        String codedMessage;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                codedMessage = new String(messageDigest.digest(startMessage));
                if (!((UserH2Dao) super.getDao()).isExistCookie(codedMessage)) {
                    return codedMessage;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
