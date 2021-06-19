<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>修改武器信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/public.css" media="all">
    <style>
        body {
            background-color: #343434;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <input type="hidden" name="weaponid"   value="${weapon.weaponid}">
    <div class="layui-form-item">
        <label class="layui-form-label required">武器名称</label>
        <div class="layui-input-block">
            <input type="text" name="weaponname" lay-verify="required"  value="${weapon.weaponname}" class="layui-input">
            <tip>填写武器名称</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">武器价格</label>
        <div class="layui-input-block">
            <input type="number" name="weaponprice"  value="${weapon.weaponprice}"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">武器余量</label>
        <div class="layui-input-block">
            <input type="number" name="weaponstore"  value="${weapon.weaponstore}"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">武器外观</label>
        <div class="layui-input-block">
            <select name="weaponfeatureid" id="featureId" lay-verify="required">
                <option value="${weapon.weaponfeatureid}">请选择</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">武器质量</label>
        <div class="layui-input-block">
            <select name="weaponqualityid" id="qualityId" lay-verify="required">
                <option value="${weapon.weaponqualityid}">请选择</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">武器类型</label>
        <div class="layui-input-block">
            <select name="weapontypeid" id="typeId" lay-verify="required">
                <option value="${weapon.weapontypeid}">请选择</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认修改</button>
        </div>
    </div>
</div>
<script src="<%=basePath%>lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate=layui.laydate,
            $ = layui.$;

        //日期
        laydate.render({
            elem: '#date',
            trigger:'click'
        });

        //动态获取武器类型的数据
        $.get("findTypeList",{},function (data) {
            var list=data;
            var select=document.getElementById("typeId");
            var type= $('#typeId').val();
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].weapontypeid);
                    option.innerText=list[c].weapontypename;
                    select.appendChild(option);
                    if (list[c].weapontypeid==type){
                        option.setAttribute("selected","selected");
                        layui.form.render('select');
                    }
                }
            }
            form.render('select');
        },"json")

        //动态获取武器外观的数据
        $.get("findFeatureList",{},function (data) {
            var list=data;
            var select=document.getElementById("featureId");
            var feature= $('#featureId').val();
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].weaponfeatureid);
                    option.innerText=list[c].weaponfeaturename;
                    select.appendChild(option);
                    if (list[c].weaponfeatureid==feature){
                        option.setAttribute("selected","selected");
                        layui.form.render('select');
                    }
                }
            }
            form.render('select');
        },"json")


        //动态获取武器质量的数据
        $.get("findQualityList",{},function (data) {
            var list=data;
            var select=document.getElementById("qualityId");
            var quality= $('#qualityId').val();
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].weaponqualityid);
                    option.innerText=list[c].weaponqualityname;
                    select.appendChild(option);
                    if (list[c].weaponqualityid==quality){
                        option.setAttribute("selected","selected");
                        layui.form.render('select');
                    }
                }
            }
            form.render('select');
        },"json")


        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas=data.field;//form单中的数据信息
            console.log(datas)
            //向后台发送数据提交添加
            $.ajax({
                url:"updateWeaponInfoSubmit",
                type:"POST",
                contentType :"application/json",
                data:JSON.stringify(datas),
                success:function(result){
                    if(result.code==0){//如果成功
                        layer.msg('修改成功',{
                            icon:6,
                            time:500
                        },function(){
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                         layer.msg("修改失败了");
                    }
                }
            })
            return false;
        });




    });
</script>
</body>
</html>
