package com.vstl.TestFaceBook;

import com.vstl.FaceBook.FBSignUp;
import com.vstl.generic.GenericMethods;

public class TestSignupPage extends GenericMethods {

	public static void main(String[] args) throws InterruptedException {
		
		FBSignUp objSignUp = new FBSignUp();
		objSignUp.invokeApplication();
		objSignUp.setFirstNameOnFBSignUp();
		objSignUp.setLastNameOnFBSignUp();
		objSignUp.setMobileNumberOnSignUpPage();
		objSignUp.setPassWordOnFBSignUpPage();
		objSignUp.setDayOfDOBOnFBSignUpPage();
		objSignUp.setMonthOfDOBOnFBSignUpPage();
		objSignUp.setYearOfDOBOnFBSignUpPage();
		objSignUp.selectGenderOnFBSignUpPage();
		objSignUp.mouseHoverLearnMoreOnSignUpPage();
		objSignUp.clickTermsInSignUpPageOnFBSignUpPage();
		objSignUp.clickDataPolicyOnFBSignUpPage();
		objSignUp.clickOnCookiesPolicyOnSignUpPage();
		objSignUp.clickOnLearnMoreOnSignUp();
		objSignUp.tearDown();
	}

}
