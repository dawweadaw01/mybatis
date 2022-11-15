package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno 账号
     * @return 账户信息
     */
    Account selectAccountByActno(String actno);

    /**
     * 更新账户余额
     * @param account 账户信息
     */
    int updateAccountByActno(Account account);
}

