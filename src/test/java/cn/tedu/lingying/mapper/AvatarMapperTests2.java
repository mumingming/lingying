package cn.tedu.lingying.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import cn.tedu.lingying.entity.Avatar;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AvatarMapperTests2 {


    @Resource
    private AvatarMapper mapper;


    /**
     *
     */
    @Test
    public void findBycpname() {
        String cpname = "7";
        List<Avatar> avatar = mapper.find(cpname);
        System.err.println(avatar);
    }


}
