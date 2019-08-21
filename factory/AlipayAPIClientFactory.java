package net.messi.early.factory;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

import net.messi.early.constant.AlipayServiceEnvConstants;

public class AlipayAPIClientFactory {


    /**
     * API调用客户端
     */
    private static AlipayClient alipayClient;

    /**
     * 获得API调用客户端
     *
     * @return
     */
    public static AlipayClient getAlipayClient() {
        if (null == alipayClient) {
            alipayClient = new DefaultAlipayClient(AlipayServiceEnvConstants.SERVER_URL, AlipayServiceEnvConstants.APP_ID, AlipayServiceEnvConstants.PRIVATE_KEY,
                    AlipayServiceEnvConstants.FORMAT, AlipayServiceEnvConstants.CHARSET, AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY,
                    AlipayServiceEnvConstants.SIGN_TYPE);
        }
        return alipayClient;
    }
}
