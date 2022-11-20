package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.utils.GenerateDaoProxy;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
   private final AccountDao accountDao = new AccountDaoImpl();
    //private AccountDao accountDao = (AccountDao)GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);
    @Override
    public void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //1.判断转出账户的余额否充足
        Account fromAct = accountDao.selectAccountByActno(fromActno);
        if (fromAct.getBalance() < money) {
            //2.余额不足提示用户
            throw new MoneyNotEnoughException("余额不足");
        }
        //3.扣除转出账户的余额
          //得到转出账户的余额
//        String s = null;
//        s.toString();
        Account toAct = accountDao.selectAccountByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        //4.增加转入账户的余额
        toAct.setBalance(toAct.getBalance() + money);
        //数据库更新
        int count = accountDao.updateAccountByActno(fromAct);
        count+=accountDao.updateAccountByActno(toAct);
        if (count!=2) {
            throw new TransferException("转账失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
