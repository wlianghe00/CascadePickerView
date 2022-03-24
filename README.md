# CascadePickerView
> 级联选择组件,包括基础组件和城市选择组件   
> 目前公开的记录组件基本都有限制，限制选择级别，如很多城市组件只能选择三级：省、市、县   
> 本组件不限制级别，可无极显示，只要安装要求组织数据即可   
## 数据格式
````json
[

  {
    "value": "11",
    "name": "北京市",
    "children":[
      {
        "value": "1101",
        "name": "朝阳",
        "children":[
          
        ]
       }
    ]
   }
]
````
> children属性可无线添加下去
## setData
> 组织好数据可通过setData方法设置数据
## 组件默认实现城市选择器
> 目前数据只处理到市级，数据是国家统计局发布的区划数据2021版，区划数据需要解析下载后续将更新区划选择到村一级别
![图片1](https://www.jianguoyun.com/p/DWbQeUQQqLmJChjo4LQE)