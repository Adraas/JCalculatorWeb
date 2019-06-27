package ru.wkn.repository.service;

import ru.wkn.entities.User;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.UserH2Dao;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UserService extends Service<User, Integer> {

    public UserService(IDao<User, Integer> iDao) {
        super(iDao);
    }

    public User logIn(String login, String password) {
        return ((UserH2Dao) super.getDao()).logIn(login, password);
    }

    public String registryCookie(String fullName, String login, String password) {
        byte[] startMessage = fullName.concat(login).concat(password).getBytes(StandardCharsets.UTF_8);
        Base64.Encoder encoder = Base64.getEncoder();
        String codedMessage = new String(encoder.encode(startMessage));
        while (((UserH2Dao) super.getDao()).isExistCookie(codedMessage)) {
            codedMessage = new String(encoder.encode(codedMessage.getBytes(StandardCharsets.UTF_8)));
        }
        return codedMessage;
    }

    public boolean checkCookieToExist(String cookie) {
        return ((UserH2Dao) super.getDao()).isExistCookie(cookie);
    }
}
