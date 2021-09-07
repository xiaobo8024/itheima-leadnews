package com.itheima.common.constants;

/**
 * 业务常量
 */
public class BusinessConstants {


    //实名认证
    public static class ApUserRealnameConstants{
        //通过
        public static final Integer MEDIA_STATUS_SUCCESS=9;

        //失败
        public static final Integer MEDIA_STATUS_FAILED=2;

        //在审核
        public static final Integer MEDIA_STATUS_WAITING=1;

        //创建中
        public static final Integer MEDIA_STATUS_ING=1;
    }

    //实名认证
    public static class AwUserMediaConstants{
        //通过
        public static final Integer ARTICLE_STATUS_SUCCESS=9;

        //失败
        public static final Integer ARTICLE_STATUS_FAILED=2;

        //在审核
        public static final Integer ARTICLE_STATUS_WAITING=1;

        //创建中
        public static final Integer ARTICLE_STATUS_ING=1;
    }

    //作者状态
    public static class ArticleConstants{
        //自媒体人
        public static final Integer ARTICLE_MEDIA=2;

        //合约
        public static final Integer ARTICLE_AGREEMENT=1;

        //机器
        public static final Integer ARTICLE_JIQI=0;

    }
}