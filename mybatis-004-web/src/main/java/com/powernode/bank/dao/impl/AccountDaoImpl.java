package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectAccountByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("account.selectAccountByActno", actno);
        return account;
    }

    @Override
    public int updateAccountByActno(Account account) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateAccountByActno", account);
        return count;
    }
}
