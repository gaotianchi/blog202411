-- 插入权限表初始数据
insert into blog_auth.permission (code, name, description, created_at, updated_at)
values
    (1000, 'ALL', '管理员权限', now(), now()),
    (1001, 'READ', '阅读权限', now(), now());

-- 插入角色表初始数据
insert into blog_auth.role (code, name, description, created_at, updated_at)
values
    (10, 'ADMIN', '管理员角色', now(), now()),
    (11, 'SUBSCRIBER', '订阅者角色', now(), now());

-- 插入角色权限表初始数据
insert into blog_auth.role_permission (role_code, permission_code)
values
    (10, 1000),
    (11, 1001);

-- 插入用户表初始数据
insert into blog_auth.user (username, password, email, created_at, updated_at, is_enabled)
values
    ('admin', '{noop}admin', 'admin@example.com', now(), now(), 1), -- 默认管理员
    ('user1', '{noop}user1', 'user1@example.com', now(), now(), 1); -- 默认普通用户

-- 插入用户角色表初始数据
insert into blog_auth.user_role (user_id, role_code)
values
    (1, 10), -- admin 用户拥有 ADMIN 角色
    (2, 11); -- user1 用户拥有 USER 角色

-- 插入 client 表初始数据
insert into blog_auth.client (client_id, client_id_issued_at, client_secret, client_name, redirect_uris)
values ('default_client', now(), '{noop}default_client',  'Public Client', 'https://oauthdebugger.com/debug');
