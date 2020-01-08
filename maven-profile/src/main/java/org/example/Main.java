package org.example;

import com.iqiyi.qiwen.commons.config.ConfigUtil;
import com.typesafe.config.Config;

public class Main {
    private static final Config config = ConfigUtil.getConfig();
    public static void main(String[] args) {
        System.out.println(config.getString("env"));
    }
}
