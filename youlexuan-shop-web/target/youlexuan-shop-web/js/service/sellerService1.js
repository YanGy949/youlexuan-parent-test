//商户服务层
app.service('sellerService1',function($http){
	//重置密码
	this.resetPassword = function (entity) {
		return $http.post('../seller/resetPassword.do',entity);
    }
	//发送验证码
	this.sendMail = function (email) {
		return $http.get('../seller/sendMail.do?email='+email);
    }
    //修改密码
    this.updatePassword=function(entity){
        return  $http.post('../seller/updatePassword.do',entity );
    }
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../seller/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../seller/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../seller/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../seller/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../seller/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../seller/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../seller/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});