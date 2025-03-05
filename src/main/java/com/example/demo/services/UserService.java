package com.example.demo.services;

import com.freshworks.commons.v2.User;
import com.freshworks.user.v2.GetUserByProductIdRequest;
import com.freshworks.user.v2.UserServiceGrpc;

public class UserService extends AbstractService {

    public UserService(String clientId, String clientSecret) throws Exception {
        super(clientId, clientSecret);
    }

    public User getUserByProductUserId(GetUserByProductIdRequest request) throws Exception {
        UserServiceGrpc.UserServiceBlockingStub stub = createStub(UserServiceGrpc.newBlockingStub(getChannel()));
        return stub.getUserByProductUserId(request);
    }

}
