
<#include "/common/commoncss.ftl">
<link rel="stylesheet" type="text/css" href="css/common/checkbox.css" />
<link rel="stylesheet" href="css/common/tanchuang.css" />
<script type="text/javascript" src="js/task/task.js" ></script>
<style type="text/css">
a {
	color: black;
}

a:hover {
	text-decoration: none;
}



.text {
	min-height: 114px;
}
.reciver{
	position: relative;
    top: -27px;
    float: right;
    right: 4px;
    cursor: pointer;
}
</style>
<script>
	$(function(){
	
	})

</script>
<div class="row" style="padding-top: 10px;">
	<div class="col-md-2">
		<h1 style="font-size: 24px; margin: 0;" class="">订单管理</h1>
	</div>
	<div class="col-md-10 text-right">
		<a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a
			disabled="disabled">订单管理</a>
	</div>
</div>
<div class="row" style="padding-top: 15px;">
	<div class="col-md-12">
		<!--id="container"-->
		<div class="bgc-w box">
			<!--盒子头-->
			<div class="box-header">
				<h3 class="box-title">
					<a href="javascript:history.back();" class="label label-default"
						style="padding: 5px;">
						 <i class="glyphicon glyphicon-chevron-left"></i> <span>返回</span>
					</a>
				</h3>
			</div>
			<!--盒子身体-->
			<form action="/saveOrder" method="post">
			<div class="box-body no-padding">
				<div class="box-body">
					<div class="row">

							<#--<div class="col-md-6 form-group">-->
								<#--<label class="control-label">订单ID</label>-->
								<#--<input id="starTime" name="orderId" class="form-control" value="${order.orderId}"/>-->
							<#--</div>-->
                        <#--<div class="col-md-6 form-group">-->
                            <#--<label class="control-label">订单车辆</label>-->
                            <#--<input id="starTime" name="vehicle.vehicleName" class="form-control" value="${order.vehicle.vehicleName}"/>-->
                        <#--</div>-->
								<div class="col-md-6 form-group">
                                    <label class="control-label"> <span>订单车辆</span></label>
                                    <select class="form-control" name="vehicleName">
									<#list vehicleList as vehicle>
										<option value="${(vehicle.vehicleName)!''}">${(vehicle.vehicleName)!''}</option>
									</#list>
                                    </select>
                                </div>
                        <div class="col-md-6 form-group">
                            <label class="control-label">开始日期</label>
							<input id="starTime" name="beginTime" class="form-control"  value="${(order.beginTime)!''}"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label class="control-label">结束日期</label>
							<input id="endTime" name="endTime" class="form-control" value="${(order.endTime)!''}"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label class="control-label">订单金额</label>
                            <input id="endTime" name="money" class="form-control" value="${(order.money)!''}"/>
                        </div>
                        <div class="col-md-6 form-group">
                            <label class="control-label"> <span>品牌</span></label>
                            <select class="form-control" name="brandId">
							<#list brandList as brand>
								<option value="${(brand.brandId)!''}">${(brand.brandName)!''}</option>
							</#list>
                            </select>
                        </div>

                        <div class="col-md-6 form-group">
                            <label class="control-label"> <span>类型</span></label>
                            <select class="form-control" name="typeId">
							<#list typeList as type>
								<option value="${(type.typeId)!''}">${(type.typeName)!''}</option>
							</#list>
                            </select>
                        </div>

						<div class="col-md-6 form-group">
							<label class="control-label">订单状态</label>
							<select class="form-control" name="state">
								<option value="${(order.state)!''}"></option>
								<#if order.state ==0>
								<#else>
								<option value="0">未接单</option>
								</#if>
								<#if order.state ==1>
								<#else>
								<option value="1">进行中</option>
								</#if>
								<#if order.state ==2>
								<#else>
								<option value="2">已完成</option>
								</#if>
							</select>
						</div>

						<div class="col-md-6 form-group">
							<label class="control-label">下单用户</label>
                            <input name="user.userName" class="form-control" value="${(order.user.userName)!''}"/>
						</div>

                        <div class="col-md-6 form-group">
                            <label class="control-label">备注</label>
                            <input id="endTime" name="remark" class="form-control" value="${(order.remark)!''}"/>
                        </div>

						<input name="taskId" type="text" style="display:none;"value="${(order.orderId)!''}" hidden>
					</div>
				</div>
			</div>
			<!--盒子尾-->
			<div class="box-footer">
				<input class="btn btn-primary" id="save" type="submit" value="保存" />
				<input class="btn btn-default" id="cancel" type="submit" value="取消"
					onclick="window.history.back();" />
			</div>
			</form>
		</div>
	</div>
</div>

<!-- 接收人弹窗-->

<script type="text/javascript" src="js/common/data.js"></script>
<script type="text/javascript" src="plugins/My97DatePicker/WdatePicker.js"></script>