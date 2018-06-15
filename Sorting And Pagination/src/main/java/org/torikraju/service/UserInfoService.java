package org.torikraju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.torikraju.repository.UserInfoRepository;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


}
