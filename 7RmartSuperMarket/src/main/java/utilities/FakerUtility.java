package utilities;

import com.github.javafaker.Faker;

public class FakerUtility 
{
	Faker faker = new Faker();
	
	public String getFirstName()
	{
		return faker.name().fullName();  //for fullname
	}
	
	public String getPsw()
	{
		return faker.internet().password();  //for password
	}
}
