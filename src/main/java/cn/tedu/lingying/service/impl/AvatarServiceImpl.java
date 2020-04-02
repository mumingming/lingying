package cn.tedu.lingying.service.impl;

import cn.tedu.lingying.entity.Avatar;
import cn.tedu.lingying.mapper.AvatarMapper;
import cn.tedu.lingying.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService {
    @Autowired
    private AvatarMapper mapper;

    @Override
    public Integer insert(String address, String cpname) {

        return mapper.insert(address, cpname);
    }


    @Override
    public List<Avatar> findbycpname(String cpname) {
        return mapper.find(cpname);
    }


    @Override
    public Integer deletebyaddress(String address) {

        return mapper.delbyaddress(address);
    }


}
