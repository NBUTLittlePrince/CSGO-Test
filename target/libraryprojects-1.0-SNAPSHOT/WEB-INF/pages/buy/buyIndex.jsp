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
    <title>购买皮肤</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/public.css" media="all">
    <style>
        .layui-layer {background: #343434;}
        blockquote, body, button, dd, div, dl, dt, form, h1, h2, h3, h4, h5, h6, input, li, ol, p, pre, td, textarea, th, ul {background: #343434;}
        .layui-layer-dialog .layui-layer-content{background: #343434;}
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
                    武器名称
                    <div class="layui-inline">
                        <input class="layui-input" name="name" id="name" autocomplete="off">
                    </div>
                    武器外观
                    <div class="layui-inline">
                        <select name="featureId" id="featureId" lay-verify="required">
                            <option value="">请选择</option>
                        </select>
                    </div>
                    武器质量
                    <div class="layui-inline">
                        <select name="qualityId" id="qualityId" lay-verify="required">
                            <option value="">请选择</option>
                        </select>
                    </div>
                    武器类型
                    <div class="layui-inline">
                        <select name="typeId" id="typeId" lay-verify="required">
                            <option value="">请选择</option>
                        </select>
                    </div>
                    <button class="layui-btn" data-type="reload">查询</button>
                    <%--<button class="layui-btn" lay-submit data-type="reload"  lay-filter="queryBook">高级查询</button>--%>
                </div>
            </div>
        </div>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="moneypay"> 充值 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="buy">购买</a>
        </script>

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
            url: '<%=basePath%>weaponAll',//查询武器数据
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'weaponid', width: 100, title: 'ID', sort: true},
                {field: 'weaponname', width: 200, title: '武器名称'},
                {field: 'weaponprice', width: 80, title: '价格'},
                {field: 'weaponstore', width: 80, title: '余量'},
                {templet:'<div>{{d.weaponfeature.weaponfeaturename}}</div>', width: 150, title: '武器外观'},
                {templet:'<div>{{d.weaponquality.weaponqualityname}}</div>', width: 150, title: '武器质量'},
                {templet:'<div>{{d.weapontype.weapontypename}}</div>', width: 150, title: '武器类型'},

                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id:'testReload'
        });

        //动态获取武器类型的数据
        $.get("findTypeList",{},function (data) {
            var list=data;
            var select=document.getElementById("typeId");
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].weapontypeid);
                    option.innerText=list[c].weapontypename;
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json")

        //动态获取武器外观的数据
        $.get("findFeatureList",{},function (data) {
            var list=data;
            var select=document.getElementById("featureId");
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].weaponfeatureid);
                    option.innerText=list[c].weaponfeaturename;
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json")


        //动态获取武器质量的数据
        $.get("findQualityList",{},function (data) {
            var list=data;
            var select=document.getElementById("qualityId");
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].weaponqualityid);
                    option.innerText=list[c].weaponqualityname;
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json")

        var $ = layui.$, active = {
            reload: function(){
                var name = $('#name').val();
                var feature= $('#featureId').val();
                var quality= $('#qualityId').val();
                var type= $('#typeId').val();
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        weaponname:name,
                       weaponfeatureid:feature,
                        weaponqualityid:quality,
                        weapontypeid:type
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


        function buyWeaponByIds(ids ,index){
            //向后台发送请求
            $.ajax({
                url: "buyWeapon",
                type: "POST",
                data: {ids: ids},
                success: function (result) {
                    if (result.code == 0) {//如果成功
                        layer.msg('购买成功', {
                            icon: 6,
                            time: 500
                        }, function () {
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        });
                    } else {
                        layer.msg("购买失败");
                    }
                }
            })
        };

        table.on('tool(currentTableFilter)', function (obj) {
            var data=obj.data;
            if (obj.event === 'buy') {  // 监听添加操作
                var index = layer.open({
                    title: '购买皮肤',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['60%', '60%'],
                    content: '<%=basePath%>queryGoodById?id='+data.weaponid,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        /**
         * 获取选中记录的id信息
         */
        function getCheackId(data){
            var arr=new Array();
            for(var i=0;i<data.length;i++){
                arr.push(data[i].weaponid);
            }
            //拼接id
            return arr.join(",");
        };


        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'moneypay') {  // 监听添加操作
                var index = layer.open({
                    title: '添加武器',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['60%', '60%'],
                    content: '<%=basePath%>moneyUpdate',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }
        });

    });
</script>

</body>
</html>
