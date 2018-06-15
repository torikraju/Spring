package org.torikraju.bean;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.torikraju.AppUtil.RandomUtil;
import org.torikraju.domain.UserInfo;
import org.torikraju.repository.UserInfoRepository;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitializingBeanExampleBean implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(InitializingBean.class);

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("Initializing user data");
        userInfoRepository.saveAll(createUser());
    }

    private List<UserInfo> createUser() {
        List<UserInfo> userInfoList = new ArrayList<>();

        for (int i = 0; i < 100; i++)
            userInfoList.add(new UserInfo(RandomUtil.getName(), RandomUtil.getAge()));

        return userInfoList;
    }

}
