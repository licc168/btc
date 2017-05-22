package com.licc.btc.chbtcapi.res.account;

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/19 10:10
 * @see
 */
public class AccountBase {
    private Boolean auth_google_enabled;   // 是否开通谷歌验证
    private Boolean auth_mobile_enabled;   // 是否开通手机验证
    private Boolean trade_password_enabled;// 是否开通交易密码
    private String  username;

    public Boolean getAuth_google_enabled() {
        return auth_google_enabled;
    }

    public void setAuth_google_enabled(Boolean auth_google_enabled) {
        this.auth_google_enabled = auth_google_enabled;
    }

    public Boolean getAuth_mobile_enabled() {
        return auth_mobile_enabled;
    }

    public void setAuth_mobile_enabled(Boolean auth_mobile_enabled) {
        this.auth_mobile_enabled = auth_mobile_enabled;
    }

    public Boolean getTrade_password_enabled() {
        return trade_password_enabled;
    }

    public void setTrade_password_enabled(Boolean trade_password_enabled) {
        this.trade_password_enabled = trade_password_enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
