# Tourism Resource Management System

## 接口文档

### login表：
​	查全部（用于个人中心数据渲染）localhost：9090/mine/user/info

​	根据name查（用于登陆页面信息核对）localhost:9090/login/user/{username}

​	更新数据（用于个人中心修改密码）localhost:9090/mine/user/update

### guiders表：
​	查全部	localhost:9090/guider/info

​	按age降序排序	localhost:9090/guider/sortByAge

​	按从业时间降序排序	localhost:9090/guider/sortByWorkExp	

​	根据id查	localhost:9090/guider/info/searchById/{id}

​	根据name查	localhost:9090/guider/info/searchByName/{name}

​	根据phone查	localhost:9090/guider/info/searchByPhone/{phone}

​	新增	localhost:9090/guider/insert	

​	修改	localhost:9090/guider/update	

​	删除	localhost:9090/guider/delete/{id}

### hotel表：

​	查全部	localhost:9090/hotel/info	

​	按容量降序排序	localhost:9090/hotel/info/capacitySort	

​	按星级降序排序	localhost:9090/hotel/info/levelSort	

​	根据id查	localhost:9090/hotel/search/{id}	

​	修改	localhost:9090/hotel/edit	

​	删除	localhost:9090/hotel/delete/{id}	

​	添加 localhost:9090/hotel/add

### parking表：

​	查全部	localhost:9090/parking/info	

​	按停车时间排序	localhost:9090/parking/info/sortTime	

​	根据车牌号查询	localhost:9090/parking/search/{car_num}	

​	修改（出库）	localhost:9090/parking/leave/{car_num}	

​	删除	localhost:9090/parking/delete/{car_num}	

​	添加	localhost:9090/parking/add

### feedback表：

​	查全部	localhost:9090/feedback/info	

​	按分数降序排序	localhost:9090/feedback/info/scoreSort	

​	根据name查	localhost:9090/feedback/searchName/{name}	

​	根据phone查	localhost:9090/searchPhone/{phone}	

​	添加	localhost:9090/feedback/add	

​	修改	localhost:9090/feedback/edit	

​	删除	localhost:9090/feedback/delete/{id}

### tourist_attraction表：

​	查全部	localhost:9090/tourist_attraction/info	

​	根据id查	localhost:9090/tourist_attraction/selectById/{id}	

​	添加	localhost:9090/tourist_attraction/insert	

​	修改	localhost:9090/tourist_attraction/update	

​	删除	localhost:9090/tourist_attraction/delete/{id}

### travel_agency表：

​	查全部	localhost:9090/travel_agency/info	

​	根据id查	localhost:9090/travel_agency/searchById/{id}	

​	添加	localhost:9090/travel_agency/insert	

​	删除	localhost:9090/travel_agency/delete/{id}	

​	修改	localhost:9090/travel_agency/update

## VUE配置说明

cd到vue项目所在的文件夹下	

动态修改标题：npm install vue-wechat-title --save	

不同页面传参：npm install js-cookie --save