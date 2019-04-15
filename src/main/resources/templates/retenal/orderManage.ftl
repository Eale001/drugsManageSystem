<#include "/common/commoncss.ftl">

<style type="text/css">
a {
	color: black;
}

a:hover {
	text-decoration: none;
}

.bgc-w {
	background-color: #fff;
}

.block {
	display: inline-block;
	width: 20px;
}

.co {
	color: blue;
}

.bl {
	color: black;
}

.commen {
	cursor: pointer;
}
</style>
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
	<div class="col-md-12 thistable">
		<!--id="container"-->
        <div class="bgc-w box box-primary">
            <!--盒子头-->
            <div class="box-header">
                <h3 class="box-title">
                    <a href="/orderEdit" class="label label-success" style="padding: 5px;">
                        <span class="glyphicon glyphicon-plus"></span> 新增
                    </a>
                </h3>
                <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                        <input type="text" class="form-control input-sm cha"
                               placeholder="查找..." />
                        <div class="input-group-btn chazhao">
                            <a class="btn btn-sm btn-default"><span
                                    class="glyphicon glyphicon-search"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--盒子身体-->
            <div class="box-body no-padding">
                <div class="table-responsive">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th scope="col" class="co commen ">订单Id<span class="block"></span></th>
                            <th scope="col">订单车辆</th>
                            <th scope="col" class="co commen ">开始时间<span class="block"></span></th>
                            <th scope="col" class="co commen ">结束时间<span class="block"></span></th>
                            <th scope="col">订单金额</th>
                            <th scope="col">订单状态</th>
                            <th scope="col" class="co commen ">车辆类型<span class="block"></span></th>
                            <th scope="col" class="co commen ">车辆品牌<span class="block"></span></th>
                            <th>下订单人</th>
                            <th>备注</th>
                            <th scope="col">操作</th>
                        </tr>
                        </thead>
                        <tbody>
					<#list orderList as order>
                    <tr>
                        <td><span>${(order.orderId)!''}</span></td>
                        <td><span>${(order.vehicle.vehicleName)!''}</span></td>
                        <td><span>${(order.beginTime)!''}</span></td>
                        <td><span>${(order.endTime)!''}</span></td>
                        <td><span>${(order.money)!''}</span></td>
                        <td><span>${(order.state)!''}</span></td>
                        <td><span>${(order.type.typeName)!''}</span></td>
                        <td><span>${(order.brand.brandName)!''}</span></td>
                        <td><span>${(order.user.userName)!''}</span></td>
                        <td><span>${(order.remark)!''}</span></td>
                        <td><a  href="/orderEdit?orderId=${order.orderId}"
                                class="label xiugai"><span
                                class="glyphicon glyphicon-edit"></span> 修改</a>
                            <a href="/myorder?orderId=${order.orderId}" class="label xiugai"><span
                                    class="glyphicon glyphicon-search"></span> 查看</a>
						</td>
                    </tr>
					</#list>

                        </tbody>
                    </table>
                </div>
            </div>

            <!--盒子尾-->
	<#--<#include "/common/paging.ftl">-->
        </div>

        <script>
            /* 分页插件按钮的点击事件 */

            <#--$('.baseKetsubmit').on('click',function(){-->
                <#--var baseKey=$('.baseKey').val();-->
                <#--$('.thistable').load('${url}?baseKey=baseKey');-->
            <#--});-->


            <#--$(function(){-->
                <#--$(".chazhao").click(function(){-->
                    <#--var con=$(".cha").val();-->
                    <#--$(".thistable").load("paixu",{val:con});-->
                <#--});-->

                <#--$(".commen").click(function(){-->

                    <#--/* //寻找指定兄弟节点并去除class-->
                    <#--var $else=$(this).addClass("mm").siblings(".commen").removeClass("mm");-->
                    <#--//点击变换字体颜色-->
                    <#--var $color=$(this).addClass("bl").removeClass("co").siblings(".commen").addClass("co").removeClass("bl");-->
                    <#--//切换img-->
                    <#--$("#img").appendTo(".mm span"); */-->
                    <#--var $val=$(this).text();-->

                    <#--$(".thistable").load("paixu",{val:$val});-->


                <#--})-->

            <#--})-->


        </script>
	</div>
</div>



