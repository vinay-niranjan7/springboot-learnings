package com.vinay7.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdNotificationServiceImp implements NotificationService{
    @Override
    public String sendNoti() {
        return "Real Notification";
    }
}
