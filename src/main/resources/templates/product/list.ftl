<html>
    <head>
        <meta charset="utf-8">
        <title>商品列表</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>商品id </th>
                        <th>名称</th>
                        <th>图片</th>
                        <th>单价</th>
                        <th>库存</th>
                        <th>状态</th>
                        <th>描述</th>
                        <th>类目</th>
                        <th>创建时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list productInfoPage.content as productInfo>
                    <tr>
                        <td>${productInfo.productId}</td>
                        <td>${productInfo.productName}</td>
                        <td>${productInfo.productIcon}</td>
                        <td>${productInfo.productPrice}</td>
                        <td>${productInfo.productStock}</td>
                        <td>${productInfo.getProductStatusEnum()}</td>
                        <td>${productInfo.productDescription}</td>
                        <td>${productInfo.categoryType}</td>
                        <td>${productInfo.createTime}</td>
                        <td>
                            <a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a>
                        </td>
                        <td>
                            <#if productInfo.getProductStatusEnum().code == 0>
                                <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                            <#else >
                                <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>

            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                    <li>
                        <a href="#">上一页</a>
                    </li>
                    <#list 1..productInfoPage.getTotalPages() as index>

                        <li>
                            <a href="/sell/seller/product/list?page=${index}&size=${size}">${index} </a>
                        </li>


                    </#list>

                    <li>
                        <a href="#">下一页</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </body>
</html>