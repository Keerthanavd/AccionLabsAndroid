package org.lsac.androidTests;

import org.testng.annotations.Test;

import android.pages.SigninPageA;
import android.pages.HomePageA;
import android.pages.AccountAccessPageA;
import android.utils.ExcelConnect;

public class VerifyJDAccountSignInA extends ChromeBase{

	
	@Test(dataProvider="Login",dataProviderClass = ExcelConnect.class)
	public void verifyJDAccountSignInA(String username, String password) {
		HomePageA homepage = new HomePageA(driver);
		homepage.clickNavigationMenu();
		
		AccountAccessPageA accountAccessPage = new AccountAccessPageA(driver);
		accountAccessPage.clickLogInToYourAccount();
		
		SigninPageA signinPage = new SigninPageA(driver);
		signinPage.signin(username, password);
	}
}
