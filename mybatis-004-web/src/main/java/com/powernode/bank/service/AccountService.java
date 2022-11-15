package com.powernode.bank.service;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;

/**
 * 账号业务类
 * 业务方法最好见名知意
 */
public interface AccountService {
    /**
     * 转账
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转账金额
     */

    void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferException;


}
