<!DOCTYPE html>
<html>
    <head>
        <title>Market Time</title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css"/>
        <#list cssResources as cssResource>
             <link rel="stylesheet" href="${baseURL}/styles/${cssResource}.css"/>    
         </#list>
    </head>
    <body>
        <#import "spring.ftl" as spring>
        <#if sections??>
            <div class="wrapper">
                <#list sections?keys as sectionName>
                    <div id="${sectionName}-container">
                        <#include "${sections[sectionName]}.ftl">
                    </div>
                </#list>
            </div>
        </#if>
        <#list jsResources as jsResource>
            <script src="${baseURL}/scripts/${jsResource}.js"></script>
         </#list>
    </body>
</html>