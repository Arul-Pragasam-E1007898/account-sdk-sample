package com.example.demo.services;

import com.freshworks.account.v2.AccountServiceGrpc;
import com.freshworks.account.v2.GetAccountByProductIdRequest;
import com.freshworks.commons.v2.Account;

public class AccountService extends AbstractService {

    public AccountService(String clientId, String clientSecret) throws Exception {
        super(clientId, clientSecret);
    }

    public Account getAccount(GetAccountByProductIdRequest request) throws Exception {
        AccountServiceGrpc.AccountServiceBlockingStub stub = createStub(AccountServiceGrpc.newBlockingStub(getChannel()));
        return stub.getAccountByProductAccountId(request);

    }
}
