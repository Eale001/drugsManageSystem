<style type="text/css">
	.table>tbody>tr>td{
		padding: 15px;
	}
	.table{
		border: 0;
	}
</style>
<fieldset id="">
	<legend style="padding-left:5%;">车辆基本信息</legend>
	<table class="table" border=""  style="width: 90%;margin: auto;margin-bottom: 20px;">
		<tr>
			<td class="text-right"  >车辆名:</td>
			<td >	${(vehicle.vehicleName)!''}</td>
			<td rowspan="3" colspan="2">
				<div id="">
					<img src="images/${(vehicle.picture)!'car.jpg'}" style="width: 120px;height: 120px;border-radius: 50%;margin-left: 15%;"/>
				</div>
			</td>
		</tr>
		<tr>
			<td class="text-right" >车辆品牌:</td>
			<td>	${(vehicle.brand.brandName)!''}</td>
		</tr>
		<tr>
			<td class="text-right" >车辆类型:</td>
			<td>${(vehicle.type.typeName)!''}</td>
		</tr>	
		<tr>
			<td class="text-right" width="15%">车辆座位:</td>
			<td width="35%">${(vehicle.vehicleSeat)!'空的'}</td>
			<td class="text-right" width="15%">车辆单价:</td>
			<td class="text-left" width="35%">${(vehicle.vehiclePrice)!''}</td>
		</tr>
		<tr>
			<td class="text-right" >车辆状态:</td>
			<td>${(vehicle.vehicleState)!'空闲'}</td>
			<td class="text-right">车辆备注:</td>
			<td class="text-left">${(vehicle.remark)!'空的'}</td>
		</tr>
	</table>
	<div class="box-footer" style="padding-left:5%;">
		<a href="javascript:void(0);" class="label label-default returninaddress" style="padding: 5px;"> <i class="glyphicon glyphicon-chevron-left"></i> <span>返回</span>
		</a>
	</div>
</fieldset>