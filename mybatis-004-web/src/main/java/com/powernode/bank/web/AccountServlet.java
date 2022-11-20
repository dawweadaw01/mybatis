package com.powernode.bank.web;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private final AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        String money = request.getParameter("money");
        System.out.println(request.getContextPath());
        //调用service的转账方法完成转账
        try {
            accountService.transfer(fromActno, toActno, Double.valueOf(money));
            //转账成功，跳转到转账成功页面
            response.sendRedirect(request.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath()+"/error1.html");

        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath()+"/error2.html");

        }
    }
}
