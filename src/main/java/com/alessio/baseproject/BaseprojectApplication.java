package com.alessio.baseproject;

import com.alessio.baseproject.database.sql.dao.UserDao;
import com.alessio.baseproject.database.sql.dao.model.BatchAdditionalInfoChangeEmail;
import com.alessio.baseproject.database.sql.dao.model.BatchAdditionalInfoSubType;
import com.alessio.baseproject.database.sql.dao.model.UserDto;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseprojectApplication implements ApplicationRunner {
	
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(BaseprojectApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++ ApplicationRunner ++++++++++++++++++++++++++++++");
		UserDto userDto = new UserDto();
		userDto.setName("test additional info");
		userDto.setCreationDate(DateTime.now());
		BatchAdditionalInfoChangeEmail additionalInfo =
				new BatchAdditionalInfoChangeEmail(BatchAdditionalInfoSubType.BATCH_ADDITIONAL_INFO_CHANGE_EMAIL);
		additionalInfo.setUserId("userId1");
		additionalInfo.setNewEmailAddress("new_email");
		additionalInfo.setOldEmailAddress("old_email");
		userDto.setAdditionalInfo(additionalInfo);
		userDao.insert(userDto);
	}
}
