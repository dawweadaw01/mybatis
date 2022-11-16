package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectAccountByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.selectOne("com.powernode.bank.dao.AccountDao.selectAccountByActno", actno);
    }

    @Override
    public int updateAccountByActno(Account account) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.update("com.powernode.bank.dao.AccountDao.updateAccountByActno", account);
    }
}
