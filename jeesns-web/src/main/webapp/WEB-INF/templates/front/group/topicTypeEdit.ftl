<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改帖子分类 - ${groupTopicType.name} - ${SITE_NAME} - Powered By JEESNS</title>
    <link href="${basePath}/res/common/css/zui.min.css" rel="stylesheet">
    <link href="${basePath}/res/front/css/app.css" rel="stylesheet">
    <link href="${basePath}/res/plugins/layer/skin/layer.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${basePath}/res/common/js/html5shiv.js"></script>
    <script src="${basePath}/res/common/js/respond.min.js"></script>
    <![endif]-->
    <script src="${basePath}/res/common/js/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/res/common/js/jquery.form.js"></script>
    <script src="${basePath}/res/common/js/zui.min.js"></script>
    <script src="${basePath}/res/plugins/layer/layer.js"></script>
    <script src="${basePath}/res/front/js/jeesns.js"></script>
    <script type="text/javascript">
        var basePath = "${basePath}";
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 article-detail">
            <form class="form-horizontal jeesns_form" role="form" action="${groupPath}/topicTypeUpdate" method="post">
                <input type="hidden" name="id" value="${groupTopicType.id}">
                <input type="hidden" name="groupId" value="${groupTopicType.groupId}">
                <div class="form-group">
                    <label class="col-sm-1 control-label">分类名称</label>
                    <input type="text" class="form-control" name="name" placeholder="分类名称" data-type="require"
                           value="${groupTopicType.name}">
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">分类权限</label>
                    <label>
                        <input type="radio" name="juri" value="0" <#if groupTopicType.juri==0>checked</#if>>
                        不限制
                    </label>
                    <label>
                        <input type="radio" name="juri" value="1" <#if groupTopicType.juri==1>checked</#if>>
                        管理员使用
                    </label>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <button type="submit" class="btn btn-info jeesns-submit">保存</button>
                        <a href="javascript:void(0)" onclick="jeesnsDialog.closeAll()"
                           class="btn btn-default jeesns-submit">取消</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>