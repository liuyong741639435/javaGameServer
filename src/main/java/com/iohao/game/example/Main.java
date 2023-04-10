package com.iohao.game.example;

import com.iohao.game.bolt.broker.client.external.config.ExternalGlobalConfig;
import com.iohao.game.example.action.DemoCmd;
import com.iohao.game.example.server.DemoLogicServer;
import com.iohao.game.simple.SimpleHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var accessAuthenticationHook = ExternalGlobalConfig.accessAuthenticationHook;
        // 表示登录才能访问业务方法
        accessAuthenticationHook.setVerifyIdentity(true);
        // 添加不需要登录也能访问的业务方法 (action)
        accessAuthenticationHook.addIgnoreAuthenticationCmd(DemoCmd.cmd, DemoCmd.loginVerify);

        // 游戏对外服端口
        int port = 10100;

        // 逻辑服
        var demoLogicServer = new DemoLogicServer();

        // 启动 对外服、网关服、逻辑服; 并生成游戏业务文档
        SimpleHelper.run(port, List.of(demoLogicServer));

        /*
         * 该示例文档地址
         * https://www.yuque.com/iohao/game/zm6qg2
         */
    }
}
