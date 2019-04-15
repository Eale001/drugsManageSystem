<#include "/common/commoncss.ftl"/>
<link rel="stylesheet" type="text/css" href="css/common/iconfont.css" />
<link rel="stylesheet" type="text/css" href="css/common/checkbox.css" />
<link rel="stylesheet" type="text/css" href="css/common/tanchuang.css" />
<style type="text/css">
    .icon {
        width: 1em;
        height: 1em;
        vertical-align: -0.15em;
        fill: currentColor;
        overflow: hidden;
    }

    a {
        color: black;
    }

    a:hover {
        text-decoration: none;
    }

    .bgc-w {
        background-color: #fff;
    }

    .box .nav-stacked>li {
        border-bottom: 1px solid #f4f4f4;
        margin: 0;
    }

    .nav-stacked>li>a {
        border-radius: 0;
        border-top: 0;
        border-left: 3px solid transparent;
        color: #444;
    }

    li.activee>a {
        border-left-color: #3c8dbc;
    }

    .des {
        border: none;
        color: #9e9e9e;
    }
    #thisul li a{
        padding:10px;
    }
    .thisbox-header:HOVER{
        background-color: #eee;
        color:#337ab7;
    }
    #thispills:HOVER{
        cursor: pointer;
    }
    #thispills li{
        border:1px solid #ccc;
        border-left: none;
    }
    #thispills li a:HOVER{
        background-color: #337ab7;
        color:#fff;
    }
    #thispills li a{
        padding:8px;
    }
    .ulfather .collapsed{
        cursor: pointer;
    }
    .nav>li>a {
        padding:15px;
    }
</style>
<#--<div class="row" style="padding-top: 10px;">-->
    <#--<div class="col-md-2">-->
        <#--<h1 style="font-size: 24px; margin: 0;" class="">车辆列表-->
            <#--&lt;#&ndash;<a href="" class="label xinzeng" style="padding: 5px;margin-left:5px;">&ndash;&gt;-->
                <#--&lt;#&ndash;<span class="glyphicon glyphicon-refresh"></span> 刷新&ndash;&gt;-->
            <#--&lt;#&ndash;</a>&ndash;&gt;-->
        <#--</h1>-->
    <#--</div>-->
    <#--<div class="col-md-10 text-right">-->
        <#--<a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a-->
            <#--disabled="disabled">车辆列表</a>-->
    <#--</div>-->
<#--</div>-->
<!--盒子头-->
<div class="box-header">
	<a class="btn btn-sm btn-default thisrefresh" href="javascript:void(0);" title="刷新" style="padding: 5px;margin-top: -8px;">
		<span class="glyphicon glyphicon-refresh"></span>
	</a>
	<div class="box-tools">
		<div class="input-group" style="width: 150px;">
			<input type="text" class="form-control input-sm baseKey" placeholder="" value="" style="width: 220px;"/>
			<div class="input-group-btn">
				<a class="btn btn-sm btn-default baseKeySumbit"> 
					<span class="glyphicon glyphicon-search"></span>
				</a>
			</div>
		</div>
	</div>
</div>
<!--盒子身体-->
<div class="box-body no-padding">
	<div class="table-responsive">
		<table class="table table-hover table-striped">
			<tr>
				<th scope="col">车辆名</th>
				<th scope="col">车辆品牌</th>
				<th scope="col">车辆类型</th>
				<th scope="col">车辆座位</th>
				<th scope="col">车辆单价(多少/小时)</th>
				<th scope="col">车辆状态</th>
				<th scope="col">车辆备注</th>
				<th scope="col">车辆图片</th>
				<th scope="col">操作</th>
			</tr>
			<#--<#if vehicleList?size gt 0>-->
			<#list vehiclelist as vehicle>
			<tr>
				<td><span>${(vehicle.vehicleName)!''}</span></td>
				<td><span>${(vehicle.brand.brandName)!''}</span></td>
				<td><span>${(vehicle.type.typeName)!''}</span></td>
				<#--<td><span>-->
				<#--<#if user.sex=="男">-->
					<#--<img src="images/male.png" alt="男" style="width: 20px;height: 20px" />-->
				<#--<#else>-->
					<#--<img src="images/female.png" alt="女" style="width: 20px;height: 20px" />-->
				<#--</#if>-->
				<#--</span></td>-->
				<td><span>${(vehicle.vehicleSeat)!''}</span></td>
				<td><span>${(vehicle.vehiclePrice)!''}</span></td>
				<#--<td><span>-->
                    <#--<img src="image/${(vehicle.picture)!'car.jpg'}" style="width: 120px;height: 120px;border-radius: 50%;margin-left: 15%;"/>-->
                <#--</span></td>-->
				<td><span>${(vehicle.vehicleState)!''}</span></td>
				<td><span>${(vehicle.remark)!''}</span></td>

                <td><a href="#"> <img src="images/${(vehicle.picture)!'car.jpg'}" class="img-circle"
                                      style="width: 24px; height: 24px;">
                </a></td>
				<td>
					<a href="/findById?vehicleId=${vehicle.vehicleId}" class="label xiugai inlookthis">
						<span class="glyphicon glyphicon-search"></span> 查看
					</a>
                    <a href="/vehicleEdit?vehicleId=${vehicle.vehicleId}" class="label xiugai">
                        <span class="glyphicon glyphicon-edit"></span> 修改</a>
                    <a href="/removeVehicle?vehicleId=${vehicle.vehicleId}" onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};"
                       class="label shanchu"><span
                            class="glyphicon glyphicon-remove"></span> 删除</a>
				</td>
			</tr>
			</#list>
			<#--<#else>-->
				<#--<tr>-->
				<#--<td colspan="7" style="text-align: center;background: #eee;">没能找到车辆~~~</td>-->
				<#--</tr>-->
			<#--</#if>-->
		</table>
	</div>
</div>
<!--盒子尾-->
<#--<#include "/common/paging.ftl"/>-->
<#include "/common/modalTip.ftl"/>
