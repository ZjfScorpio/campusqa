package cau.mickey.campusqa.constant;

/**
 * 一些配置常量
 */
public class Constant {

    //根据需要选择localIp还是remoteIp
    private static String localIp = "localhost";
    private static String remoteIp = "47.102.193.234";

    //项目运行服务器
    public static final String IP = localIp;
    public static final String PORT = "80";

    //redis服务器
    public static final String REDIS_IP = remoteIp;
    public static final int REDIS_PORT = 6379;

    //solr服务器
    public static final String SOLR_IP = remoteIp;
    public static final String SOLR_PORT = "8983";
    public static final String SOLR_CORE = "/solr/campusqa";

    //163邮箱
//    public static final String MAIL_NICKNAME = "校园内自动知识应答平台-米老鼠团队";//昵称
//    public static final String INTERNET_ADDRESS = "<mickeyschool@163.com>";//网络地址
//    public static final String USER_NAME = "mickeyschool@163.com";//用户名
//    public static final String PASSWORD = "mickeyschool16";//授权码
//    public static final String MAIL_HOST = "smtp.163.com";//主机


    //qq邮箱
    public static final String MAIL_NICKNAME = "校园内自动知识应答平台-米老鼠团队";//昵称
    public static final String INTERNET_ADDRESS = "<565421368@qq.com>";//网络地址
    public static final String USER_NAME = "565421368@qq.com";//用户名
    public static final String PASSWORD = "iowmfsornqbzbbfe";//授权码
    public static final String MAIL_HOST = "smtp.qq.com";//主机


}
