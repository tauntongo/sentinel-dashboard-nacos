package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 *<p></p>
 *@author <a href="mailto:tangdong@supermonkey.com.cn">tangdong</a>
 *@version
 *@since
 *@date Created in 2020-10-27 15:11
 */
@Component
@ConfigurationProperties(prefix = "nacos.server")
public class NacosProperties {
    private static final String NACOS_SERVER_ADDR = "NACOS_SERVER_ADDR";
    private static final String NACOS_GROUP_ID = "NACOS_GROUP_ID";
    private static final String NACOS_NAMESPACE = "NACOS_NAMESPACE";
    private static final String NACOS_PORT = "NACOS_PORT";
    private static final String NACOS_IP = "NACOS_IP";

    private String ip = "localhost";

    private String port = "8848";

    private String namespace;

    //private String groupId = "DEFAULT_GROUP";

    public String getIp() {
        String nacosIp = getEnv(NACOS_IP);
        if (StringUtils.isNotBlank(nacosIp)) {
            return nacosIp;
        }
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        String nacosPort = getEnv(NACOS_PORT);
        if (StringUtils.isNotBlank(nacosPort)) {
            return nacosPort;
        }
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getNamespace() {
        String nacosNamespace = getEnv(NACOS_NAMESPACE);
        if (StringUtils.isNotBlank(nacosNamespace)) {
            return nacosNamespace;
        }
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    //public String getGroupId() {
    //    String nacosGroupId = getEnv(NACOS_GROUP_ID);
    //    if (StringUtils.isNotBlank(nacosGroupId)) {
    //        return nacosGroupId;
    //    }
    //    return groupId;
    //}
    //
    //public void setGroupId(String groupId) {
    //    this.groupId = groupId;
    //}

    public String getServerAddr() {
        String nacosServerAddr = getEnv(NACOS_SERVER_ADDR);
        if (StringUtils.isNotBlank(nacosServerAddr)) {
            return nacosServerAddr;
        }
        return this.getIp() + ":" + this.getPort();
    }

    private static String getEnv(String key) {
        return System.getenv(key);
    }
}
