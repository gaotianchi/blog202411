package com.gaotianchi.auth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户行为日志(ActionLog)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:00:29
 */
@Setter
@Getter
@NoArgsConstructor
public class ActionLog implements Serializable {

    @Serial
    private static final long serialVersionUID = -86918888593827507L;

    private Integer id;  // 自增ID
    private Integer userId;  // 用户ID
    private String action;  // 操作类型
    private Date actionTime;  // 操作时间
    private String objectType;  // 被操作的对象类型
    private Integer objectId;  // 被操作对象的唯一标识符
    private String ipAddress;  // 用户操作的IP地址
    private String deviceInfo;  // 用户操作设备的信息
    private String details;  // 操作的详细细节
    private Date createdAt;  // 日志记录的创建时间


}

