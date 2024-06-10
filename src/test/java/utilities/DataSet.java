package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidData")
    public static Object invalidLoginData(){
        Object [][] dataset = {
                {"","","Error: ইউজার নাম প্রয়োজন"},
                {"jibon@mailto.plus","","Error: The password field is empty."},
                {"","1234Aa@","Error: ইউজার নাম প্রয়োজন"},
                {"hello","11223344","Error: The username hello is not registered on this site. If you are unsure of your username, try your email address instead."},
                {"username","hello","Error: The username username is not registered on this site. If you are unsure of your username, try your email address instead."},
                {"jibon@mailto.plus","password123","Error: The password you entered for the email address jibon@mailto.plus is incorrect. Lost your password?"}
        };

        return dataset;
    }
}
