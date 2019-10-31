package com.module.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.module.api.entity.Account;
import com.module.api.entity.AccountDto;
import com.module.api.exception.LowBalanceAccountException;
import com.module.api.exception.NullAccountException;
import com.module.api.service.AccountService;
import com.module.api.util.ResultCode;
import com.module.api.util.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Account / 资金账号查找/新增/更新/删除服务")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/account/getAccount/{accountNo}", method = RequestMethod.GET)
	@ApiOperation(value="根据资金账号检索余额")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "accountNo", value = "资金账号", required = true, paramType="query", type="String"),
	})
	public ResultMsg RetrieveBalance(@PathVariable(value="accountNo") String accountNo) {
		ResultMsg resultMsg = new ResultMsg();
		try {
			Account account = accountService.findByNo(accountNo);
			if(account == null ) {
				throw new NullAccountException("该账户为空账户，请重新输入账号");
			}else{
				resultMsg.setCode(ResultCode.SUCCESS);
				resultMsg.setMsg("账户检索成功！");
				resultMsg.setObject(account);
			}
		} catch(NullAccountException ae){
			ae.printStackTrace();
			resultMsg.setCode(ResultCode.NULL_ACCOUNT);
			resultMsg.setMsg(ae.getMessage());
			resultMsg.setObject(null);
		} catch(Exception e){
			e.printStackTrace();
			resultMsg.setCode(ResultCode.SYSTEM_ERROR);
			resultMsg.setMsg(e.getMessage());
			resultMsg.setObject(null);
		} finally {
			return resultMsg;
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value="/account/transaction", method = RequestMethod.POST)
	@ApiOperation(value="根据资金账号进行转账")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "accountNo", value = "资金账户号码", required = true, type="String"),
		@ApiImplicitParam(name = "amount", value = "转账金额", required = true, type="Double"),
	})
	@Validated
	public ResultMsg transaction(@RequestBody AccountDto accountDto) {
		ResultMsg resultMsg = new ResultMsg();
		try {
			Account account = accountService.findByNo(accountDto.getAccountNo());
			if( account == null ) {
				throw new NullAccountException("该账户为空账户，请重新输入账号");
			} else if(account.getAccountBalance() < accountDto.getAmount()) {
				throw new LowBalanceAccountException("该账户余额不足，请重新输入转账金额");
			} else {
				Double remainBalance = account.getAccountBalance() - accountDto.getAmount();
				account.setAccountBalance(remainBalance);
				resultMsg.setCode(ResultCode.SUCCESS);
				resultMsg.setMsg("账户转账操作成功！");
				resultMsg.setObject(account);
			}
		} catch(NullAccountException ae){
			ae.printStackTrace();
			resultMsg.setCode(ResultCode.SYSTEM_ERROR);
			resultMsg.setMsg(ae.getMessage());
			resultMsg.setObject(null);
		}  catch(LowBalanceAccountException le){
			le.printStackTrace();
			resultMsg.setCode(ResultCode.LOW_BALANCE);
			resultMsg.setMsg(le.getMessage());
			resultMsg.setObject(null);
		} catch(Exception e){
			e.printStackTrace();
			resultMsg.setCode(ResultCode.SYSTEM_ERROR);
			resultMsg.setMsg(e.getMessage());
			resultMsg.setObject(null);
		} finally {
			return resultMsg;
		}
	}
}
