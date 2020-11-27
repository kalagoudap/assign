package com.assign.assing.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assign.assing.Entity.UserRegistration;
import com.assign.assing.Repository.Userrepository;
import com.assign.assing.dto.Userdto;

import lombok.Getter;

@Getter
@Service
public class UserService 
{
	@Autowired
	Userrepository userrepository;

	Long id;

	public UserRegistration getdetails(Long id)
	{
		return userrepository.findById(id).get();
	}

	public void savedetails(Userdto userdto)
	{
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setName(userdto.getName());
		userRegistration.setEmail(userdto.getEmail());
		userRegistration.setAddress(userdto.getAddress());
		userRegistration.setPhonenumber(userdto.getPhonenumber());
		userRegistration.setPincode(userdto.getPincode());

		userrepository.save(userRegistration);
	}

	public ResponseEntity<UserRegistration> editdetails(Userdto userdto,Long id)
	{
		UserRegistration userRegistration=userrepository.findById(id).get();
		if(userdto != null)
		{
			if(userdto.getName()!=null&&userdto.getName()!="")
				userRegistration.setName(userdto.getName());
			if(userdto.getEmail()!=null && userdto.getEmail()!="")
				userRegistration.setEmail(userdto.getEmail());
			if(userdto.getAddress()!=null && userdto.getAddress()!="")
				userRegistration.setAddress(userdto.getAddress());
			if(userdto.getPhonenumber()!=null) 
				userRegistration.setPhonenumber(userdto.getPhonenumber());
			if(userdto.getPincode()!=null)
				userRegistration.setPincode(userdto.getPincode());

			return new ResponseEntity<UserRegistration>(userrepository.save(userRegistration), HttpStatus.OK);
		}
		else
			return new ResponseEntity<UserRegistration>(HttpStatus.BAD_REQUEST);
	}

	public String deletedetails(Long id)
	{
		userrepository.deleteById(id);
		return "record is deleted";
	}

	public UserRegistration  loginform(Userdto userdto)
	{
		int flag=0;
		List<UserRegistration> record=userrepository.findAll();
		for (UserRegistration userRegistration : record) 
		{
			if (userRegistration.getEmail().equalsIgnoreCase(userdto.getEmail()) && userRegistration.getPhonenumber().equals(userdto.getPhonenumber()))
			{
				id=userRegistration.getId();
				flag=1;
			}
		}

		if(flag==1)
		{
			return userrepository.findById(id).get();
		}
		else
		{
			return null;
		}	
	}
}

