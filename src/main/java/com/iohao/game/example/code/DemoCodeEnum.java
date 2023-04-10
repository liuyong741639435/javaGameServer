package com.iohao.game.example.code;

import com.iohao.game.action.skeleton.core.exception.MsgExceptionInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum DemoCodeEnum implements MsgExceptionInfo {
    /** jsr330 */
    jackson_error(100, "异常机制测试，name 必须是 jackson !");
    /** 消息码 */
    final int code;
    /** 消息模板 */
    final String msg;

    DemoCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
