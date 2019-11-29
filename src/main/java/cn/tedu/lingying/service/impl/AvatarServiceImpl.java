package cn.tedu.lingying.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.lingying.entity.Admin;
import cn.tedu.lingying.entity.Avatar;
import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.mapper.AvatarMapper;
import cn.tedu.lingying.mapper.UserMapper;
import cn.tedu.lingying.service.AvatarService;
import cn.tedu.lingying.service.UserService;
import cn.tedu.lingying.service.ex.InsertException;
import cn.tedu.lingying.service.ex.PasswordNotMatchException;
import cn.tedu.lingying.service.ex.UserNotFoundException;
import cn.tedu.lingying.service.ex.UsernameDuplicateException;

@Service
public class AvatarServiceImpl implements AvatarService{
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
