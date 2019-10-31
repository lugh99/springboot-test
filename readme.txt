1. 模拟两个资金账户，如下：
	{
        "id": 1,
        "accountNo": "A000001",
        "accountName": "Account_A",
        "accountBalance": 1000.0,
        "remark": ""
    }
    {
        "id": 2,
        "accountNo": "B000001",
        "accountName": "Account_B",
        "accountBalance": 2000.0,
        "remark": null
    }
2. 提供了两个接口
    1）/account/getAccount/{accountNo}，RequestMethod.GET
    2）/account/transaction， RequestMethod.POST
       参数：{"accountNo": "A000001","amount": "120.00"}  
3. springboot版本为2.0.8版本，springcloud版本为Finchley.RELEASE，占用端口信息为9000,9001
3. 提供了swaggerAPI帮助文档访问：http://localhost:9001/swagger-ui.html
4. 部署方式有两种：
	一、1）run eurekaServer模块下com.test.EurekaServer.java，启动eureka注册服务中心；
	       2）run module-api模块下的com.module.api.ApiApp.java，把接口信息注册到服务中心；
	二、1）按顺序启动项目下的project-jar包下的两个jar包，依次是
	           java -jar eurekaServer.jar
	           java -jar module-api.jar
5. 测试用例在module-api模块下com.module.api.test.AccountApiTest