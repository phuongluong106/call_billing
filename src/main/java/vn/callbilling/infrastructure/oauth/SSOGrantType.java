package vn.callbilling.infrastructure.oauth;

import lombok.Getter;

@Getter
public enum SSOGrantType {
    password,
    client_credentials;
}
