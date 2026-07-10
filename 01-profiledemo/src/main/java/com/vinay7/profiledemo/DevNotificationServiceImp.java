package com.vinay7.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev","staging","default"})
public class DevNotificationServiceImp implements NotificationService{
    @Override
    public String sendNoti() {
        return "dummy notification";
    }
}
