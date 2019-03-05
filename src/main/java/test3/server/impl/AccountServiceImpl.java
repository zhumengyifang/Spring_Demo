package test3.server.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test3.dao.AccountDao;
import test3.server.AccountService;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outer, String inner, Integer money) {
        accountDao.out(outer, money);
        //断电
        int i = 1 / 0;
        accountDao.in(inner, money);
    }
}
