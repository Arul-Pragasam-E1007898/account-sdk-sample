package com.example.demo.services;

import com.freshworks.sdk.Configuration;
import com.freshworks.sdk.SDKManager;
import com.freshworks.sdk.authorization.Token;
import io.grpc.CallCredentials;
import io.grpc.Channel;
import io.grpc.stub.AbstractStub;

public abstract class AbstractService {
    protected final SDKManager sdkManager;

    public AbstractService(String clientId, String clientSecret) throws Exception {
        this.sdkManager = new SDKManager(Configuration.builder()
                .forRegion(Configuration.FreshworksRegion.SANDBOX)
                .setClientCredentials(clientId, clientSecret)
                .build());
    }

    protected CallCredentials getCallCredentials() throws Exception {
        Token token = sdkManager.generateClientAccessToken();
        return sdkManager.generateCallCredentialsWithToken(token.getAccessToken());
    }

    protected Channel getChannel() {
        return sdkManager.getChannel();
    }

    protected <T extends AbstractStub<T>> T createStub(T stub) throws Exception {
        CallCredentials callCredentials = getCallCredentials();
        Channel channel = getChannel();
        return stub.withCallCredentials(callCredentials).withChannel(channel);
    }
}
