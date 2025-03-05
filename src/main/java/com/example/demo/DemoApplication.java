package com.example.demo;

import com.example.demo.services.AccountService;
import com.example.demo.services.UserService;
import com.freshworks.account.v2.GetAccountByProductIdRequest;
import com.freshworks.commons.v2.Account;
import com.freshworks.commons.v2.User;
import com.freshworks.user.v2.GetUserByProductIdRequest;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.JsonFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static final String CLIENT_ID = "xxx";
	public static final String CLIENT_SECRET = "xxx";
	public static final String PRODUCT_ACCOUNT_ID = "2220000170";
	public static final String PRODUCT_USER_ID = "1000";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		getUser();
		//getAccount();
	}

	private static void getUser() throws Exception {
		UserService userService = new UserService(CLIENT_ID, CLIENT_SECRET);
		StringValue productAccount = StringValue.newBuilder().setValue(PRODUCT_ACCOUNT_ID).build();
		StringValue productUser = StringValue.newBuilder().setValue(PRODUCT_USER_ID).build();
		User user = userService.getUserByProductUserId(
				GetUserByProductIdRequest.newBuilder().setProductAccountId(productAccount)
						.setProductUserId(productUser).build());
		System.out.printf(JsonFormat.printer().print(user));
	}

	private static void getAccount() throws Exception {
		AccountService accountService = new AccountService(CLIENT_ID, CLIENT_SECRET);
		StringValue productAccount = StringValue.newBuilder().setValue(PRODUCT_ACCOUNT_ID).build();
		Account account = accountService.getAccount(
				GetAccountByProductIdRequest.newBuilder().setProductAccountId(productAccount).build());
		System.out.printf(JsonFormat.printer().print(account));
	}

}
