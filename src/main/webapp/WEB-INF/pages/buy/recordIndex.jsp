<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查询购买记录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/public.css" media="all">
    <style>
        .layui-table td, .layui-table th, .layui-table-col-set, .layui-table-view,.layui-table-fixed-r, .layui-table-grid-down, .layui-table-header, .layui-table-page, .layui-table-tips-main, .layui-table-tool, .layui-table-total, .layui-table-view, .layui-table[lay-skin=line], .layui-table[lay-skin=row]{
            border-color: #4a4a4a;
            background: #292929;
            color: whitesmoke;
        }
        .layui-icon{
            color: whitesmoke;
        }
        .layui-table-page .layui-laypage span {
            margin-left: 0;
            padding: 0;
            color: whitesmoke;
        }
        .layui-form-select dl dd {
            /* cursor: pointer; */
            color: black;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layuimini-main">
            <div class="demoTable">
                <div class="layui-form-item layui-form ">
                    <input type="hidden" name="userid" id="userid" value="${user.id}">
                </div>
            </div>
        </div>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>


    </div>
</div>
<script src="<%=basePath%>lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '<%=basePath%>dealForUser',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 100, title: 'ID', sort: true},
                {templet:'<div>{{d.weapon.weaponname}}</div>', width: 150, title: '武器名称'},
                {templet:'<div>{{d.weaponfeature.weaponfeaturename}}</div>', width: 150, title: '武器外观'},
                {templet:'<div>{{d.weaponquality.weaponqualityname}}</div>', width: 150, title: '武器质量'},
                {field: 'total', width: 150, title: '交易金额'},
                {field: 'userid', width: 150, title: '用户Id'},
                {templet:'<div>{{d.user.username}}</div>', width: 150, title: '用户名'},
                {field: 'ispay', width: 150, title: '支付状态'},
                {templet:"<div>{{layui.util.toDateString(d.createdate,'yyyy-MM-dd HH:mm:ss' )}}</div>", width: 280, title: '创建时间'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id:'testReload'
        });


        var $ = layui.$, active = {
            reload: function(){
                var userid = $('#userid').val();
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        userid: userid,
                    }
                }, 'data');
            }
        };
     

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });








    });
</script>

</body>
</html>
