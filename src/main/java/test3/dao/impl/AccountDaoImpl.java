package test3.dao.impl;

import test3.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void out(String outer, Integer money) {
        this.getJdbcTemplate().update("update account set money = money - ? where username = ?", money, outer);
    }

    @Override
    public void in(String inner, Integer money) {
        this.getJdbcTemplate().update("update account set money = money + ? where username = ?", money, inner);
    }
}
